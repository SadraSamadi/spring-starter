package com.sadrasamadi.springstarter.auth;

import com.sadrasamadi.springstarter.auth.dto.Authorization;
import com.sadrasamadi.springstarter.auth.dto.LoginRequest;
import com.sadrasamadi.springstarter.auth.dto.RegisterRequest;
import com.sadrasamadi.springstarter.auth.dto.UserUpdateRequest;
import com.sadrasamadi.springstarter.auth.user.RoleEntity;
import com.sadrasamadi.springstarter.auth.user.RoleService;
import com.sadrasamadi.springstarter.auth.user.UserEntity;
import com.sadrasamadi.springstarter.auth.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthService {

  private final RoleService roleService;

  private final UserService userService;

  private final PasswordEncoder encoder;

  private final AuthProperties properties;

  @Autowired
  public AuthService(RoleService roleService,
                     UserService userService,
                     PasswordEncoder encoder,
                     AuthProperties properties) {
    this.roleService = roleService;
    this.userService = userService;
    this.encoder = encoder;
    this.properties = properties;
  }

  public Authorization register(RegisterRequest request) {
    String requestUsername = request.getUsername();
    String requestEmail = request.getEmail();
    String requestPassword = request.getPassword();
    String requestRole = request.getRole();
    RoleEntity role = roleService.findOneByName(requestRole);
    UserEntity user = UserEntity.builder()
      .username(requestUsername)
      .email(requestEmail)
      .password(requestPassword)
      .role(role)
      .status(UserEntity.Status.ACTIVE)
      .build();
    UserEntity created = userService.createOne(user);
    return sign(created);
  }

  public Authorization login(LoginRequest request) {
    String requestUsername = request.getUsername();
    String requestPassword = request.getPassword();
    String requestRole = request.getRole();
    UserEntity user = userService.findOneByUsername(requestUsername);
    String userPassword = user.getPassword();
    RoleEntity userRole = user.getRole();
    String userRoleName = userRole.getName();
    if (requestRole != null && !Objects.equals(requestRole, userRoleName))
      throw new RuntimeException("roles dont match");
    if (!encoder.matches(requestPassword, userPassword))
      throw new RuntimeException("wrong password");
    return sign(user);
  }

  public UserEntity findUser() {
    return AuthContext.getUser();
  }

  public UserEntity updateUser(UserUpdateRequest request) {
    UserEntity user = findUser();
    long id = user.getId();
    String requestUsername = request.getUsername();
    String requestEmail = request.getEmail();
    String requestPassword = request.getPassword();
    user.setUsername(requestUsername);
    user.setEmail(requestEmail);
    user.setPassword(requestPassword);
    return userService.replaceOneById(id, user);
  }

  public Authorization sign(UserEntity user) {
    AuthProperties.Jwt jwt = properties.getJwt();
    String prefix = jwt.getPrefix();
    long id = user.getId();
    String token = String.valueOf(id);
    return Authorization.builder()
      .prefix(prefix)
      .token(token)
      .build();
  }

  public UserEntity verify(Authorization auth) {
    String token = auth.getToken();
    long id = Long.parseLong(token);
    return userService.findOneById(id);
  }

}
