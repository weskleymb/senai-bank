package br.senai.rn.senaibank.service.impl;

import br.senai.rn.senaibank.model.AuditableEntity;
import br.senai.rn.senaibank.repository.GenericRepository;
import br.senai.rn.senaibank.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public abstract class GenericServiceImpl<T extends AuditableEntity> implements GenericService<T> {

    @Autowired
    private GenericRepository<T> repository;

    @Override
    public List buscaTodos() {
        return repository.findAll();
    }

    @Override
    public T buscaPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void remover(T entidade) {
        repository.deleteById(entidade.getId());
    }

    @Override
    public T salva(T entidade) {
        return repository.save(entidade);
    }

}
