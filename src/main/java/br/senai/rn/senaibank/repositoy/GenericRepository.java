package br.senai.rn.senaibank.repositoy;

import br.senai.rn.senaibank.model.AuditableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface GenericRepository<T extends AuditableEntity> extends JpaRepository<T, Long> {

    @Override
    @Query(value = "SELECT entity FROM #{#entityName} entity WHERE entity.ativo = TRUE")
    List<T> findAll();

    @Override
    @Query(value = "SELECT entity FROM #{#entityName} entity WHERE entity.ativo = TRUE AND entity.id = :id")
    Optional<T> findById(@Param(value = "id") Long id);

    @Override
    @Transactional
    @Modifying
    @Query(value = "UPDATE #{#entityName} entity SET entity.ativo = FALSE WHERE entity = :entity")
    void delete(@Param(value = "entity") T entity);

    @Override
    @Transactional
    @Modifying
    @Query(value = "UPDATE #{#entityName} entity SET entity.ativo = FALSE WHERE entity.id = :id")
    void deleteById(@Param(value = "id") Long id);

    @Query(value = "SELECT COUNT(entity) FROM #{#entityName} entity WHERE entity.ativo = TRUE")
    Long countAtivo();

}
