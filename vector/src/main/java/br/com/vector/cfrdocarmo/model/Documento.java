package br.com.vector.cfrdocarmo.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode()
@Getter
@Setter
@Entity
public class Documento {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String codigo;

	private String resumo;

	private String solicitante;

	private LocalDateTime dataCriacao = LocalDateTime.now();

	public Documento(String codigo, String resumo, String solicitante) {
		this.codigo = codigo;
		this.resumo = resumo;
		this.solicitante = solicitante;
	}
	
	public Documento() {
	}

}
