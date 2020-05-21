package br.senai.rn.senaibank.service.impl;

import br.senai.rn.senaibank.model.Cliente;
import br.senai.rn.senaibank.repositoy.ClienteRepository;
import br.senai.rn.senaibank.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ClienteServiceImpl extends GenericServiceImpl<Cliente> implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Override
    public Cliente findByCpf(String cpf) {
        return repository.findByCpf(cpf).orElse(null);
    }

}
