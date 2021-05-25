package com.sadrasamadi.springstarter.auth.prop;

import com.sadrasamadi.springstarter.core.CoreRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PropRepository<P extends PropEntity> extends CoreRepository<P> {

}
