package com.sadrasamadi.springstarter.auth.user;

import com.sadrasamadi.springstarter.core.CoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService extends CoreService<RoleEntity, RoleRepository> {

  @Autowired
  public RoleService(RoleRepository repository) {
    super(repository);
  }

  public RoleBuilder builder() {
    return new RoleBuilder(this);
  }

  public RoleEntity findOneByName(String name) {
    Optional<RoleEntity> optional = repository.findByName(name);
    return optional.orElseThrow();
  }

}
