package com.sadrasamadi.springstarter.app.post;

import com.sadrasamadi.springstarter.auth.prop.PropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService extends PropService<PostEntity, PostRepository> {

  @Autowired
  public PostService(PostRepository repository) {
    super(repository);
  }

}
