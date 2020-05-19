package br.senai.rn.senaibank.service.impl;

import br.senai.rn.senaibank.model.AuditableEntity;
import br.senai.rn.senaibank.repositoy.GenericRepository;
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

    public T save(T entity) {
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public T findById(Long id) {
        return repository.findById(id).orElse(null);
    }

}
