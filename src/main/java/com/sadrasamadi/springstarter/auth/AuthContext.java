package com.sadrasamadi.springstarter.auth;

import com.sadrasamadi.springstarter.auth.user.PermissionEntity;
import com.sadrasamadi.springstarter.auth.user.UserEntity;
import lombok.Data;

@Data
public class AuthContext {

  private UserEntity user;

  private PermissionEntity permission;

  private static final ThreadLocal<AuthContext> context = ThreadLocal.withInitial(AuthContext::new);

  public static AuthContext getContext() {
    return context.get();
  }

  public static UserEntity getUser() {
    AuthContext context = getContext();
    return context.user;
  }

  public static void setUser(UserEntity user) {
    AuthContext context = getContext();
    context.user = user;
  }

  public static PermissionEntity getPermission() {
    AuthContext context = getContext();
    return context.permission;
  }

  public static void setPermission(PermissionEntity permission) {
    AuthContext context = getContext();
    context.permission = permission;
  }

}
