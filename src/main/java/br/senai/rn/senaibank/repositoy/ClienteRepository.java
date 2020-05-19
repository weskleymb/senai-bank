package br.senai.rn.senaibank.repositoy;

import br.senai.rn.senaibank.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends GenericRepository<Cliente> {

    Optional<Cliente> findByCpf(String cpf);

}
