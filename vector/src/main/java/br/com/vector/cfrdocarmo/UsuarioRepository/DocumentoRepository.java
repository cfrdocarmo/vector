package br.com.vector.cfrdocarmo.UsuarioRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vector.cfrdocarmo.model.Documento;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {

	Documento findByCodigo(String codigo);
}
