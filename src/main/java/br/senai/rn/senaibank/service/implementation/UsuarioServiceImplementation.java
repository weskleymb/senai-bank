package br.senai.rn.senaibank.service.implementation;

import br.senai.rn.senaibank.model.Usuario;
import br.senai.rn.senaibank.repositoy.UsuarioRepository;
import br.senai.rn.senaibank.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UsuarioServiceImplementation extends GenericServiceImplementation<Usuario> implements UsuarioService, UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByLogin(login).orElse(null);
        if (usuario == null) throw new UsernameNotFoundException("Usuário não encontrado!!!");
        return usuario;
    }

}
