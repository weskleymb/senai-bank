package br.senai.rn.senaibank.service;

import br.senai.rn.senaibank.model.Cliente;
import br.senai.rn.senaibank.repositoy.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> buscaTodos() {
        return repository.findAll();
    }

    public Cliente buscaPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Cliente buscaPorCpf(String cpf) {
        Optional<Cliente> optional = repository.findByCpf(cpf);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    public Cliente salva(Cliente cliente) {
        return repository.save(cliente);
    }

    public void remover(Cliente cliente) {
        repository.delete(cliente);
    }
}
