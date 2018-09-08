package com.br.matrix.lancamentos.lancamentos.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.matrix.lancamentos.lancamentos.models.Empresa;
import com.br.matrix.lancamentos.lancamentos.services.EmpresaService;

@RestController
public class EmpresaResource {

	@Autowired
	private EmpresaService empresaService;
	
	@PostMapping("/empresa")
	public ResponseEntity<Empresa> cadastrar(@RequestBody @Valid Empresa empresa)
	{
		Empresa empresaCadastrada = empresaService.cadastrar(empresa);
		return new ResponseEntity<>(empresaCadastrada, HttpStatus.OK);
	}
	
	@PutMapping("/empresa")
	public ResponseEntity<Empresa> atualizar(@RequestBody @Valid Empresa empresa)
	{
		Empresa empresaAtualizada = empresaService.atualizar(empresa);
		return new ResponseEntity<>(empresaAtualizada, HttpStatus.OK);
	}
	
	@GetMapping("/empresa")
	public ResponseEntity<List<Empresa>> listar()
	{
		List<Empresa> listaDeEmpresas = empresaService.listar();
		return new ResponseEntity<>(listaDeEmpresas, HttpStatus.OK);
	}
	
	@DeleteMapping("/empresa")
	public ResponseEntity<?> deletar(@PathVariable("id") Long id)
	{
		empresaService.remover(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/empresa/{id}")
	public ResponseEntity<Empresa> buscarPeloId(@PathVariable("id") Long id)
	{
		Empresa empresaBuscada = empresaService.buscarPorId(id);
		return new ResponseEntity<>(empresaBuscada, HttpStatus.OK);
	}
}