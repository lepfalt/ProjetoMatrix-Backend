package com.br.matrix.receita.lancamentos.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.matrix.receita.lancamentos.models.Lancamento;
import com.br.matrix.receita.lancamentos.repositories.LancamentoRepository;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	public Lancamento salvar(Lancamento lancamento) {
		return lancamentoRepository.save(lancamento);
	}

	public List<Lancamento> listar() {
		return lancamentoRepository.findAll();
	}

	public void remover(Long id) {
		lancamentoRepository.deleteById(id);
	}

	public Lancamento atualizar(Lancamento lancamento) {	
		return lancamentoRepository.save(lancamento);
	}

	public Lancamento buscarPorVencimento(LocalDate vencimento) {
		return lancamentoRepository.findByVencimento(vencimento).get();
	}
}
