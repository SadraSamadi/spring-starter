package com.sadrasamadi.springstarter.app.post;

import com.sadrasamadi.springstarter.auth.prop.PropControllerImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController extends PropControllerImp<PostEntity, PostService> {

  @Autowired
  public PostController(PostService service) {
    super(service);
  }

}
