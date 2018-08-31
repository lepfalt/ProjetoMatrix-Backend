package com.br.matrix.receita.lancamentos.resources;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.matrix.receita.lancamentos.models.Lancamento;
import com.br.matrix.receita.lancamentos.services.LancamentoService;

@RestController
public class LancamentoResource {

	@Autowired
	private LancamentoService lancamentoService;
	
	@PostMapping("/lancamentos")
	public ResponseEntity<Lancamento> criarLancamento(@RequestBody Lancamento lancamento) {
		Lancamento lancamentoNovo = lancamentoService.salvar(lancamento);		
		return new ResponseEntity<>(lancamentoNovo, HttpStatus.CREATED);
	}
	
	@GetMapping("/lancamentos/listar")
	public ResponseEntity<List<Lancamento>> getLancamento(){
		List<Lancamento> lancamentos = lancamentoService.listar();
		return new ResponseEntity<List<Lancamento>>(lancamentos, HttpStatus.OK);
	}
	
	@DeleteMapping("/lancamentos/{id}")
	public ResponseEntity<?> removerLancamento(@PathVariable("id") Long id){
		lancamentoService.remover(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/lancamentos")
	public ResponseEntity<Lancamento> atualizarLancamento(@RequestBody Lancamento lancamento){
		
		Lancamento lancamentoNovo = lancamentoService.atualizar(lancamento);	
		return new ResponseEntity<Lancamento>(lancamentoNovo, HttpStatus.OK);
	}
	
	@GetMapping("/lancamentos/buscar")
	public ResponseEntity<Lancamento> getLancamentoPorVencimento(@RequestParam("vencimento") LocalDate vencimento){
		Lancamento lancamento = lancamentoService.buscarPorVencimento(vencimento);
		return new ResponseEntity<>(lancamento, HttpStatus.OK);	
	}
}
