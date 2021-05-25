package com.sadrasamadi.springstarter.auth.user;

import com.sadrasamadi.springstarter.core.CoreService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService extends CoreService<UserEntity, UserRepository> {

  private final PasswordEncoder encoder;

  @Autowired
  public UserService(UserRepository repository, PasswordEncoder encoder) {
    super(repository);
    this.encoder = encoder;
  }

  @Override
  public UserEntity findOneById(long id) {
    UserEntity user = super.findOneById(id);
    RoleEntity role = user.getRole();
    Hibernate.initialize(role);
    return user;
  }

  @Override
  public UserEntity create(UserEntity user) {
    encode(user);
    return super.create(user);
  }

  @Override
  public UserEntity replace(UserEntity source, UserEntity target) {
    encode(target);
    String targetPassword = target.getPassword();
    if (targetPassword == null) {
      String sourcePassword = source.getPassword();
      target.setPassword(sourcePassword);
    }
    return super.replace(source, target);
  }

  public UserEntity findOneByUsername(String username) {
    Optional<UserEntity> optional = repository.findByUsernameOrEmail(username, username);
    return optional.orElseThrow();
  }

  private void encode(UserEntity user) {
    String password = user.getPassword();
    if (password != null) {
      String encoded = encoder.encode(password);
      user.setPassword(encoded);
    }
  }

}
