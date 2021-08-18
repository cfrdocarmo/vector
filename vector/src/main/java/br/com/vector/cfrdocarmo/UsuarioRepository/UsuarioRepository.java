package br.com.vector.cfrdocarmo.UsuarioRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vector.cfrdocarmo.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Optional<Usuario> findByEmail(String email);
}
