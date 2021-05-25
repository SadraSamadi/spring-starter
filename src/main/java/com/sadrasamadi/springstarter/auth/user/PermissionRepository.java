package com.sadrasamadi.springstarter.auth.user;

import com.sadrasamadi.springstarter.core.CoreRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends CoreRepository<PermissionEntity> {

}
