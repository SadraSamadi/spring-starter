package com.sadrasamadi.springstarter.auth.prop;

import com.sadrasamadi.springstarter.core.CoreService;

public class PropService<P extends PropEntity, R extends PropRepository<P>> extends CoreService<P, R> {

  protected PropService(R repository) {
    super(repository);
  }

  public P findOne() {
    return null;
  }

}
