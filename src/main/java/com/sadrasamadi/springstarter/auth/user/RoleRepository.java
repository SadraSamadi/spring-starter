package com.sadrasamadi.springstarter.auth.user;

import com.sadrasamadi.springstarter.core.CoreRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends CoreRepository<RoleEntity> {

  Optional<RoleEntity> findByName(String name);

}
