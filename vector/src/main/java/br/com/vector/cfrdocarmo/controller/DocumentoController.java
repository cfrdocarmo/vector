package br.com.vector.cfrdocarmo.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.vector.cfrdocarmo.UsuarioRepository.DocumentoRepository;
import br.com.vector.cfrdocarmo.controller.dto.DocumentoDto;
import br.com.vector.cfrdocarmo.controller.form.AtualizacaoDocumentoDto;
import br.com.vector.cfrdocarmo.controller.form.DocumentoForm;
import br.com.vector.cfrdocarmo.model.Documento;

@RestController
public class DocumentoController {

	@Autowired 
	DocumentoRepository documentoRepository;
	
	@GetMapping("/documentos")
	public Page<Documento> lista(@RequestParam(required = false) String nomeCurso,
			@PageableDefault(sort = "id", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {
		
			return documentoRepository.findAll(paginacao);
		
	}
	
	@PostMapping("/documento")
	public ResponseEntity<DocumentoDto> cadastrar(@RequestBody DocumentoForm form, UriComponentsBuilder uriBuilder) {
		Documento documento = form.converter();
		documentoRepository.save(documento);
	
		URI uri = uriBuilder.path("/documentos/{id}").buildAndExpand(documento.getId()).toUri();
		return ResponseEntity.created(uri).body(new DocumentoDto(documento));
	}
	
	@GetMapping("documentos/{id}")
	public ResponseEntity<DocumentoDto> detalhar(@PathVariable Long id) {
		Optional<Documento> documento = documentoRepository.findById(id);
		if (documento.isPresent()) {
			return ResponseEntity.ok(new DocumentoDto(documento.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("documento/{id}")
	public ResponseEntity<DocumentoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoDocumentoDto form){
		Optional<Documento> optional = documentoRepository.findById(id);
		if (optional.isPresent()) {
			Documento documento = form.atualizar(id, documentoRepository);
			return ResponseEntity.ok(new DocumentoDto(documento));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id){
		Optional<Documento> optional = documentoRepository.findById(id);
		if (optional.isPresent()) {
			documentoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
