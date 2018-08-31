package com.br.matrix.receita.lancamentos.resources;

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

import com.br.matrix.receita.lancamentos.models.Categoria;
import com.br.matrix.receita.lancamentos.services.CategoriaService;

@RestController
public class CategoriaResource {

	@Autowired
	private CategoriaService categoriaService;
	
	@PostMapping("/categorias")
	public ResponseEntity<Categoria> criarCategoria(@RequestBody Categoria categoria) {
		Categoria categoriaNova = categoriaService.salvar(categoria);		
		return new ResponseEntity<>(categoriaNova, HttpStatus.CREATED);
	}
	
	@GetMapping("/categorias/listar")
	public ResponseEntity<List<Categoria>> getCategoria(){
		List<Categoria> categorias = categoriaService.listar();
		return new ResponseEntity<List<Categoria>>(categorias, HttpStatus.OK);
	}
	
	@DeleteMapping("/categorias/{id}")
	public ResponseEntity<?> removerCategoria(@PathVariable("id") Long id){
		categoriaService.remover(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/categorias")
	public ResponseEntity<Categoria> atualizarCategoria(@RequestBody Categoria categoria){
		
		Categoria categoriaNova = categoriaService.atualizar(categoria);	
		return new ResponseEntity<Categoria>(categoriaNova, HttpStatus.OK);
	}
	
	@GetMapping("/categorias/buscar")
	public ResponseEntity<Categoria> getCategoriaPorDescricao(@RequestParam("descricao") String descricao){
		Categoria categoria = categoriaService.buscarPorDescricao(descricao);
		return new ResponseEntity<>(categoria, HttpStatus.OK);	
	}
}
