package com.sadrasamadi.springstarter.app;

import com.sadrasamadi.springstarter.auth.user.*;
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
    RoleEntity adminRole = roleService.builder()
      .name("admin")
      .permission(PermissionConstant.ALL, PermissionConstant.ALL, false)
      .build();
    RoleEntity authorRole = roleService.builder()
      .name("author")
      .permission("posts", PermissionConstant.ALL, true)
      .build();
    RoleEntity userRole = roleService.builder()
      .name("user")
      .permission("posts", PermissionConstant.READ, false)
      .build();
    UserEntity admin = UserEntity.builder()
      .username("admin")
      .email("info@admin.com")
      .password("12345678")
      .role(adminRole)
      .status(UserEntity.Status.ACTIVE)
      .build();
    userService.createOne(admin);
    UserEntity author = UserEntity.builder()
      .username("author")
      .email("info@author.com")
      .password("12345678")
      .role(authorRole)
      .status(UserEntity.Status.ACTIVE)
      .build();
    userService.createOne(author);
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
