package com.br.matrix.lancamentos.lancamentos.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CNPJ;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 14)
	@CNPJ
	@NotEmpty
	private String cnpj;
	
	@NotEmpty
	private String nome;
	private String nomeResponsavel;
	private String contato;
}
