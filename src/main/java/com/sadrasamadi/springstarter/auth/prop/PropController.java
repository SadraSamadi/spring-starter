package com.sadrasamadi.springstarter.auth.prop;

import com.sadrasamadi.springstarter.core.CoreController;
import org.springframework.http.ResponseEntity;

public interface PropController<P extends PropEntity> extends CoreController<P> {

  default ResponseEntity<P> findOne() {
    return null;
  }

}
