package br.com.vector.cfrdocarmo.controller.form;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.vector.cfrdocarmo.model.Documento;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocumentoForm {

	@NotEmpty
	@Length(min = 6)
	private String codigo;

	@NotEmpty
	@Length(min = 6)
	private String resumo;

	@NotEmpty
	@Length(min = 6)
	private String solicitante;
	

	public Documento converter() {
		return new Documento(codigo, resumo, solicitante);
	}
}
