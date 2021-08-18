package br.com.vector.cfrdocarmo.controller.form;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.vector.cfrdocarmo.UsuarioRepository.DocumentoRepository;
import br.com.vector.cfrdocarmo.model.Documento;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtualizacaoDocumentoDto{

	
	@NotEmpty @NotEmpty @Length(min = 6)
	private String resumo;
	
	@NotEmpty @NotEmpty @Length(min = 6)
	private String solicitante;


	public Documento atualizar(Long id, DocumentoRepository documentoRepository) {
		Documento documento = documentoRepository.getOne(id);
		documento.setResumo(this.resumo);
		documento.setSolicitante(this.solicitante);
		
		return documento;
	}
	
	
}
