package br.senai.rn.senaibank.service;

import br.senai.rn.senaibank.model.AuditableEntity;

import java.util.List;

public interface GenericService<T extends AuditableEntity> {

    T save(T entity);

    void delete(Long id);

    List<T> findAll();

    T findById(Long id);

}
