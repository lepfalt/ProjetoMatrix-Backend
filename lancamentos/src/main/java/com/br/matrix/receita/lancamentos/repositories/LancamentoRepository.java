package com.br.matrix.receita.lancamentos.repositories;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.matrix.receita.lancamentos.models.Lancamento;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

	Optional <Lancamento> findById(Long id);
	Optional <Lancamento> findByVencimento(LocalDate vencimento);
}
