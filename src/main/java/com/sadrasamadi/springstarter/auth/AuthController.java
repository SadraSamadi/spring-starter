package com.sadrasamadi.springstarter.auth;

import com.sadrasamadi.springstarter.auth.dto.Authorization;
import com.sadrasamadi.springstarter.auth.dto.LoginRequest;
import com.sadrasamadi.springstarter.auth.dto.RegisterRequest;
import com.sadrasamadi.springstarter.auth.dto.UserUpdateRequest;
import com.sadrasamadi.springstarter.auth.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

  private final AuthService service;

  @Autowired
  public AuthController(AuthService service) {
    this.service = service;
  }

  @PostMapping("/register")
  public ResponseEntity<Authorization> register(@RequestBody RegisterRequest request) {
    Authorization auth = service.register(request);
    return ResponseEntity.ok(auth);
  }

  @PostMapping("/login")
  public ResponseEntity<Authorization> login(@RequestBody LoginRequest request) {
    Authorization auth = service.login(request);
    return ResponseEntity.ok(auth);
  }

  @GetMapping("/user")
  public ResponseEntity<UserEntity> user() {
    UserEntity user = service.findUser();
    return ResponseEntity.ok(user);
  }

  @PutMapping("/user")
  public ResponseEntity<UserEntity> user(@RequestBody UserUpdateRequest request) {
    UserEntity user = service.updateUser(request);
    return ResponseEntity.ok(user);
  }

}
