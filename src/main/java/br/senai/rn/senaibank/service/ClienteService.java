package br.senai.rn.senaibank.service;

import br.senai.rn.senaibank.model.Cliente;
import br.senai.rn.senaibank.repositoy.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface ClienteService extends GenericService<Cliente> {



    Cliente findByCpf(String cpf);

}
