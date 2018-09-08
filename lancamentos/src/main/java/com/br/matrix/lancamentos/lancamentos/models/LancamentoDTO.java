package com.br.matrix.lancamentos.lancamentos.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LancamentoDTO {

	private Long id;
	private Long empresaId;
	private Long categoriaId;
	private String tipo;
	private BigDecimal valor;
	private LocalDate vencimento;
}
