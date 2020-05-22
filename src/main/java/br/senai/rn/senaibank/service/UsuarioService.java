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
public interface UsuarioService extends GenericService<Usuario> {



}
