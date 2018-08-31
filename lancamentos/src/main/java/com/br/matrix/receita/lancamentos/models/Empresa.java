package com.br.matrix.receita.lancamentos.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Empresa {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@NotBlank
	private String nome;
	@NotNull
	@NotBlank
	@Column(length=14)
	private String cnpj;
	private String nomeResponsavel;
	private String contato;
	@OneToMany
	@JoinColumn(name="empresaId")
	private List<Lancamento> lancamentos;
}
