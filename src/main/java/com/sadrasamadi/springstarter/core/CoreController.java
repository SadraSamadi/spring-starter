package com.sadrasamadi.springstarter.core;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CoreController<E extends CoreEntity> {

  default ResponseEntity<E> createOne(E e) {
    return null;
  }

  default ResponseEntity<E> findOneById(long id) {
    return null;
  }

  default ResponseEntity<Page<E>> findMany(Pageable pageable) {
    return null;
  }

  default ResponseEntity<List<E>> findAll() {
    return null;
  }

  default ResponseEntity<E> replaceOneById(long id, E e) {
    return null;
  }

  default ResponseEntity<E> deleteOneById(long id) {
    return null;
  }

}
