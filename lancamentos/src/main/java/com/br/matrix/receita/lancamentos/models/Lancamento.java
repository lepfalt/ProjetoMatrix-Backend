package com.br.matrix.receita.lancamentos.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Lancamento {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name="empresaId")
	private Empresa empresa;
	@ManyToOne
	@JoinColumn(name="categoriaId")
	private Categoria categoria;
	private String tipo;
	private LocalDate vencimento;
	private BigDecimal valor;
}
