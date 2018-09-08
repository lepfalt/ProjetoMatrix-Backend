package com.br.matrix.lancamentos.lancamentos.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.matrix.lancamentos.lancamentos.models.Lancamento;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

	List<Lancamento> findByVencimentoBetween(LocalDate vencimentoInicial, LocalDate vencimentoFinal);
}
