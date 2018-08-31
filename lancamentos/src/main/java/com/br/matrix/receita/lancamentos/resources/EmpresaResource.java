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

import com.br.matrix.receita.lancamentos.models.Empresa;
import com.br.matrix.receita.lancamentos.services.EmpresaService;

@RestController
public class EmpresaResource {

	@Autowired
	private EmpresaService empresaService;
	
	@PostMapping("/empresas")
	public ResponseEntity<Empresa> criarEmpresa(@RequestBody Empresa empresa) {
		Empresa empresaNova = empresaService.salvar(empresa);		
		return new ResponseEntity<>(empresaNova, HttpStatus.CREATED);
	}
	
	@GetMapping("/empresas/listar")
	public ResponseEntity<List<Empresa>> getEmpresas(){
		List<Empresa> empresas = empresaService.listar();
		return new ResponseEntity<List<Empresa>>(empresas, HttpStatus.OK);
	}
	
	@DeleteMapping("/empresas/{id}")
	public ResponseEntity<?> removerEmpresa(@PathVariable("id") Long id){
		empresaService.remover(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/empresas")
	public ResponseEntity<Empresa> atualizarEmpresa(@RequestBody Empresa empresa){
		
		Empresa empresaNova = empresaService.atualizar(empresa);	
		return new ResponseEntity<Empresa>(empresaNova, HttpStatus.OK);
	}
	
	@GetMapping("/empresas/buscar")
	public ResponseEntity<Empresa> getEmpresaPorNome(@RequestParam("nome") String nome, @RequestParam("cnpj") String cnpj){
		Empresa empresa = empresaService.buscarPorNomeECnpj(nome, cnpj);
		return new ResponseEntity<>(empresa, HttpStatus.OK);	
	}
}
