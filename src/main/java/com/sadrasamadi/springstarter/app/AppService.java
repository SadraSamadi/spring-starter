package com.sadrasamadi.springstarter.app;

import com.sadrasamadi.springstarter.auth.user.RoleEntity;
import com.sadrasamadi.springstarter.auth.user.RoleService;
import com.sadrasamadi.springstarter.auth.user.UserEntity;
import com.sadrasamadi.springstarter.auth.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

@Service
public class AppService implements ApplicationRunner {

  private final RoleService roleService;

  private final UserService userService;

  @Autowired
  public AppService(RoleService roleService, UserService userService) {
    this.roleService = roleService;
    this.userService = userService;
  }

  @Override
  public void run(ApplicationArguments args) {
    RoleEntity adminRole = roleService.createOneByName("admin", null);
    RoleEntity userRole = roleService.createOneByName("user", null);
    UserEntity admin = UserEntity.builder()
      .username("admin")
      .email("info@admin.com")
      .password("12345678")
      .role(adminRole)
      .status(UserEntity.Status.ACTIVE)
      .build();
    userService.createOne(admin);
    UserEntity user = UserEntity.builder()
      .username("user")
      .email("info@user.com")
      .password("12345678")
      .role(userRole)
      .status(UserEntity.Status.ACTIVE)
      .build();
    userService.createOne(user);
  }

}
