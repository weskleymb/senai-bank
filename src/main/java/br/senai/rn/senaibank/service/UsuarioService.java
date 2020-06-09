package br.senai.rn.senaibank.service;

import br.senai.rn.senaibank.model.Usuario;
import br.senai.rn.senaibank.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UsuarioService implements UserDetailsService, GenericService<Usuario> {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = repository.findByLogin(login).orElse(null);
        if (usuario == null) throw new UsernameNotFoundException("Usuário não encontrado!!!");
        return usuario;
    }

    @Override
    public List<Usuario> buscaTodos() {
        return repository.findAll();
    }

    @Override
    public Usuario buscaPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void remover(Usuario entidade) {
        repository.deleteById(entidade.getId());
    }

    @Override
    public Usuario salva(Usuario entidade) {
        return repository.save(entidade);
    }

}
