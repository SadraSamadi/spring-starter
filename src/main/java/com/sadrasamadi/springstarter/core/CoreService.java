package com.sadrasamadi.springstarter.core;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public abstract class CoreService<E extends CoreEntity, R extends CoreRepository<E>> {

  protected final R repository;

  protected CoreService(R repository) {
    this.repository = repository;
  }

  public E createOne(E e) {
    E created = create(e);
    return save(created);
  }

  public E findOneById(long id) {
    Optional<E> optional = repository.findById(id);
    return optional.orElseThrow();
  }

  public Page<E> findMany(Pageable pageable) {
    return repository.findAll(pageable);
  }

  public List<E> findAll() {
    return repository.findAll();
  }

  public E replaceOne(E source, E target) {
    E replaced = replace(source, target);
    return save(replaced);
  }

  public E replaceOneById(long id, E target) {
    E source = findOneById(id);
    return replaceOne(source, target);
  }

  public E deleteOne(E e) {
    return remove(e);
  }

  public E deleteOneById(long id) {
    E e = findOneById(id);
    return deleteOne(e);
  }

  public E create(E e) {
    e.id = 0L;
    e.created = null;
    e.updated = null;
    return e;
  }

  public E replace(E source, E target) {
    target.id = source.id;
    target.created = source.created;
    target.updated = source.updated;
    return target;
  }

  public E save(E e) {
    return repository.save(e);
  }

  public E remove(E e) {
    repository.delete(e);
    return e;
  }

}
