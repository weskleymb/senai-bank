package br.senai.rn.senaibank.service;

import br.senai.rn.senaibank.model.Cliente;

public interface ClienteService extends GenericService<Cliente> {

    Cliente findByCpf(String cpf);

}
