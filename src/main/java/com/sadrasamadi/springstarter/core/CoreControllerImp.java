package com.sadrasamadi.springstarter.core;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class CoreControllerImp<E extends CoreEntity, S extends CoreService<E, ?>> implements CoreController<E> {

  protected final S service;

  protected CoreControllerDelegate<E, S> delegate;

  protected CoreControllerImp(S service) {
    this.service = service;
    delegate = new CoreControllerDelegate<>(service);
  }

  @Override
  @PostMapping("/one")
  public ResponseEntity<E> createOne(@RequestBody E e) {
    return delegate.createOne(e);
  }

  @Override
  @GetMapping("/one/{id}")
  public ResponseEntity<E> findOneById(@PathVariable long id) {
    return delegate.findOneById(id);
  }

  @Override
  @GetMapping("/many")
  public ResponseEntity<Page<E>> findMany(@PageableDefault Pageable pageable) {
    return delegate.findMany(pageable);
  }

  @Override
  @GetMapping("/all")
  public ResponseEntity<List<E>> findAll() {
    return delegate.findAll();
  }

  @Override
  @PutMapping("/one/{id}")
  public ResponseEntity<E> replaceOneById(@PathVariable long id, @RequestBody E e) {
    return delegate.replaceOneById(id, e);
  }

  @Override
  @DeleteMapping("/one/{id}")
  public ResponseEntity<E> deleteOneById(@PathVariable long id) {
    return delegate.deleteOneById(id);
  }

}
