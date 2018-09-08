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

import com.br.matrix.lancamentos.lancamentos.models.Categoria;
import com.br.matrix.lancamentos.lancamentos.services.CategoriaService;

@RestController
public class CategoriaResource {

	@Autowired
	private CategoriaService categoriaService;
	
	@PostMapping("/categoria")
	public ResponseEntity<Categoria> cadastrar(@RequestBody @Valid Categoria categoria)
	{
		Categoria categoriaCadastrada = categoriaService.cadastar(categoria);
		return new ResponseEntity<>(categoriaCadastrada, HttpStatus.OK);
	}
	
	@PutMapping("/categoria")
	public ResponseEntity<Categoria> atualizar(@RequestBody @Valid Categoria categoria)
	{
		Categoria categoriaAtualizada = categoriaService.atualizar(categoria);
		return new ResponseEntity<>(categoriaAtualizada, HttpStatus.OK);
	}
	
	@GetMapping("/categoria")
	public ResponseEntity<List<Categoria>> listar()
	{
		List<Categoria> listaDeCategorias = categoriaService.listar();
		return new ResponseEntity<>(listaDeCategorias, HttpStatus.OK);
	}
	
	@DeleteMapping("/categoria/{id}")
	public ResponseEntity<?> deletar(@PathVariable("id") Long id)
	{
		categoriaService.remover(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	// BUSCAR PELO ID
}
