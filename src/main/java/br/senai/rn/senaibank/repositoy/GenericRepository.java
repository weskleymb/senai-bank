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
    @Query(value = "select entity from #{#entityName} entity where entity.ativo = true")
    List<T> findAll();

    @Override
    @Query(value = "select entity from #{#entityName} entity where entity.ativo = true and entity.id = :id")
    Optional<T> findById(@Param(value = "id") Long id);

    @Override
    @Transactional
    @Modifying
    @Query(value = "update #{#entityName} entity set entity.ativo = false where entity = :entity")
    void delete(@Param(value = "entity") T entity);

    @Override
    @Transactional
    @Modifying
    @Query(value = "update #{#entityName} entity set entity.ativo = false where entity.id = :id")
    void deleteById(@Param(value = "id") Long id);

    @Override
    default void deleteAll(Iterable<? extends T> iterable) {
        iterable.forEach(entity -> {
            deleteById(entity.getId());
        });
    }

    @Query(value = "select count (entity) from #{#entityName} entity where entity.ativo = true")
    Long countAtivo();

}
