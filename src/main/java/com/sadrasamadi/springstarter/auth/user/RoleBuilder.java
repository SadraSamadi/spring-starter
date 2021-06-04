package com.sadrasamadi.springstarter.auth.user;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class RoleBuilder {

  private final RoleService service;

  private String name;

  private final List<PermissionEntity> permissions = new ArrayList<>();

  public RoleBuilder name(String name) {
    this.name = name;
    return this;
  }

  public RoleBuilder permission(String feature, String action, boolean limited, boolean granted) {
    PermissionEntity permission = PermissionEntity.builder()
      .feature(feature)
      .action(action)
      .limited(limited)
      .granted(granted)
      .build();
    permissions.add(permission);
    return this;
  }

  public RoleBuilder permission(String feature, String action, boolean limited) {
    return permission(feature, action, limited, true);
  }

  public RoleEntity build() {
    RoleEntity role = RoleEntity.builder()
      .name(name)
      .permissions(permissions)
      .build();
    return service.createOne(role);
  }

}
