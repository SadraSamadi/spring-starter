package com.sadrasamadi.springstarter.auth.user;

import com.sadrasamadi.springstarter.core.CoreRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CoreRepository<UserEntity> {

  Optional<UserEntity> findByUsernameOrEmail(String username, String email);

}
