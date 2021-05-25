package com.sadrasamadi.springstarter.app.user;

import com.sadrasamadi.springstarter.auth.user.UserEntity;
import com.sadrasamadi.springstarter.auth.user.UserService;
import com.sadrasamadi.springstarter.core.CoreControllerImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController extends CoreControllerImp<UserEntity, UserService> {

  @Autowired
  public UserController(UserService service) {
    super(service);
  }

}
