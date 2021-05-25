package com.sadrasamadi.springstarter.app.post;

import com.sadrasamadi.springstarter.auth.prop.PropRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends PropRepository<PostEntity> {

}
