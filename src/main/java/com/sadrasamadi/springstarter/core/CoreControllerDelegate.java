package com.sadrasamadi.springstarter.core;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RequiredArgsConstructor
public class CoreControllerDelegate<E extends CoreEntity, S extends CoreService<E, ?>> implements CoreController<E> {

  protected final S service;

  @Override
  public ResponseEntity<E> createOne(E e) {
    E created = service.createOne(e);
    return ResponseEntity.ok(created);
  }

  @Override
  public ResponseEntity<E> findOneById(long id) {
    E one = service.findOneById(id);
    return ResponseEntity.ok(one);
  }

  @Override
  public ResponseEntity<Page<E>> findMany(Pageable pageable) {
    Page<E> page = service.findMany(pageable);
    return ResponseEntity.ok(page);
  }

  @Override
  public ResponseEntity<List<E>> findAll() {
    List<E> list = service.findAll();
    return ResponseEntity.ok(list);
  }

  @Override
  public ResponseEntity<E> replaceOneById(long id, E e) {
    E replaced = service.replaceOneById(id, e);
    return ResponseEntity.ok(replaced);
  }

  @Override
  public ResponseEntity<E> deleteOneById(long id) {
    E deleted = service.deleteOneById(id);
    return ResponseEntity.ok(deleted);
  }

}
