package com.br.matrix.lancamentos.lancamentos.models;

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

@Entity
@Getter @Setter
public class Lancamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "empresaId", referencedColumnName = "id")
	private Empresa empresa;
	
	@ManyToOne
	@JoinColumn(name = "categoriaId", referencedColumnName = "id")
	private Categoria categoria;
	private String tipo;
	private BigDecimal valor;
	private LocalDate vencimento;
}
