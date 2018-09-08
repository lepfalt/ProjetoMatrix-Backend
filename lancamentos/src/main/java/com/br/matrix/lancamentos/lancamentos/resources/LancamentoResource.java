package com.br.matrix.lancamentos.lancamentos.resources;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import com.br.matrix.lancamentos.lancamentos.models.Lancamento;
import com.br.matrix.lancamentos.lancamentos.models.LancamentoDTO;
import com.br.matrix.lancamentos.lancamentos.services.LancamentoService;

@RestController
public class LancamentoResource {

	@Autowired
	private LancamentoService lancamentoService;
	
	@PostMapping("/lancamento")
	public ResponseEntity<Lancamento> cadastrar(@RequestBody @Valid LancamentoDTO lancamentoDTO)
	{
		return new ResponseEntity<>(lancamentoService.cadastrar(lancamentoDTO), HttpStatus.OK);
	}
	
	@PutMapping("/lancamento")
	public ResponseEntity<Lancamento> atualizar(@RequestBody @Valid LancamentoDTO lancamentoDTO)
	{
		return new ResponseEntity<>(lancamentoService.atualizar(lancamentoDTO), HttpStatus.OK);
	}
	
	@GetMapping("/lancamento")
	public ResponseEntity<List<Lancamento>> listarPorVencimento(
			@RequestParam("dataInicio") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dataInicio,
			@RequestParam("dataFim") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dataFim)
	{
		return new ResponseEntity<>(lancamentoService.buscarPorVencimento(dataInicio, dataFim), HttpStatus.OK);
	}
	
	@DeleteMapping("/lancamento/{id}")
	public ResponseEntity<?> deletar(@PathVariable("id") Long id)
	{
		lancamentoService.remover(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
