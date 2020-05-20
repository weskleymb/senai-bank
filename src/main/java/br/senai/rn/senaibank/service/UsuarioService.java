package br.senai.rn.senaibank.service;

import br.senai.rn.senaibank.model.Usuario;
import br.senai.rn.senaibank.repositoy.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = repository.findByLogin(login).orElse(null);
        if (usuario == null) throw new UsernameNotFoundException("Usuário não encontrado!!!");
        return usuario;
    }

}
