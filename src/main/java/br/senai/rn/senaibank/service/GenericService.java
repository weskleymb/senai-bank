package br.senai.rn.senaibank.service;

import br.senai.rn.senaibank.model.AuditableEntity;

import java.util.List;

public interface GenericService<T extends AuditableEntity> {

    List<T> buscaTodos();

    T buscaPorId(Long id);

    void remover(T entidade);

    T salva(T entidade);

}
