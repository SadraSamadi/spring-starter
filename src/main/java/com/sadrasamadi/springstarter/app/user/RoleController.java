package com.sadrasamadi.springstarter.app.user;

import com.sadrasamadi.springstarter.auth.user.RoleEntity;
import com.sadrasamadi.springstarter.auth.user.RoleService;
import com.sadrasamadi.springstarter.core.CoreControllerImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RoleController extends CoreControllerImp<RoleEntity, RoleService> {

  @Autowired
  public RoleController(RoleService service) {
    super(service);
  }

}
