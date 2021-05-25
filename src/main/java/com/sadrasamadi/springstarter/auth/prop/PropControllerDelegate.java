package com.sadrasamadi.springstarter.auth.prop;

import com.sadrasamadi.springstarter.core.CoreControllerDelegate;
import org.springframework.http.ResponseEntity;

public class PropControllerDelegate<P extends PropEntity, S extends PropService<P, ?>>
  extends CoreControllerDelegate<P, S> implements PropController<P> {

  public PropControllerDelegate(S service) {
    super(service);
  }

  @Override
  public ResponseEntity<P> findOne() {
    P one = service.findOne();
    return ResponseEntity.ok(one);
  }

}
