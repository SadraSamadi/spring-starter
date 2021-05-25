package com.sadrasamadi.springstarter.auth.dto;

import lombok.Data;

@Data
public class UserUpdateRequest {

  private String username;

  private String email;

  private String password;

}
