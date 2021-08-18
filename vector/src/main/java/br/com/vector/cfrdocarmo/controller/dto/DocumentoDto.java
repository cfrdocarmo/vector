package br.com.vector.cfrdocarmo.controller.dto;

import java.time.LocalDateTime;

import br.com.vector.cfrdocarmo.model.Documento;
import lombok.Getter;

@Getter
public class DocumentoDto {

	private Long id;
	private String codigo;
	private String resumo;
	private LocalDateTime dataCriacao;
	
	public DocumentoDto(Documento documento) {
		this.id = documento.getId();
		this.codigo = documento.getCodigo();
		this.resumo = documento.getResumo();
		this.dataCriacao = documento.getDataCriacao();
	}

	
	
}
