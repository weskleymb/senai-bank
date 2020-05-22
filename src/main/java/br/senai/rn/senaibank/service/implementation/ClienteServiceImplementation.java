package br.senai.rn.senaibank.service.implementation;

import br.senai.rn.senaibank.model.Cliente;
import br.senai.rn.senaibank.repositoy.ClienteRepository;
import br.senai.rn.senaibank.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ClienteServiceImplementation extends GenericServiceImplementation<Cliente> implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente findByCpf(String cpf) {
        return clienteRepository.findByCpf(cpf).orElse(null);
    }

}
