package com.sadrasamadi.springstarter.auth.prop;

import com.sadrasamadi.springstarter.core.CoreControllerImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public abstract class PropControllerImp<P extends PropEntity, S extends PropService<P, ?>>
  extends CoreControllerImp<P, S> implements PropController<P> {

  private final PropControllerDelegate<P, S> delegate;

  protected PropControllerImp(S service, PropControllerDelegate<P, S> delegate) {
    super(service, delegate);
    this.delegate = delegate;
  }

  protected PropControllerImp(S service) {
    this(service, new PropControllerDelegate<>(service));
  }

  @Override
  @GetMapping("/one")
  public ResponseEntity<P> findOne() {
    return delegate.findOne();
  }

}
