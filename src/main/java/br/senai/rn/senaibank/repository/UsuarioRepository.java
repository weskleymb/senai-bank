package br.senai.rn.senaibank.repository;

import br.senai.rn.senaibank.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends GenericRepository<Usuario> {

    Optional<Usuario> findByLogin(String login);

}
