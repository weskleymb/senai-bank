package br.senai.rn.senaibank.repositoy;

import br.senai.rn.senaibank.model.Cliente;

import java.util.Optional;

public interface ClienteRepository extends GenericRepository<Cliente> {

    Optional<Cliente> findByCpf(String cpf);

}
