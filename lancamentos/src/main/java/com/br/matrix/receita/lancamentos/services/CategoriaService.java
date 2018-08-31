package com.br.matrix.receita.lancamentos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.matrix.receita.lancamentos.models.Categoria;
import com.br.matrix.receita.lancamentos.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria salvar(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	public List<Categoria> listar() {
		return categoriaRepository.findAll();
	}

	public void remover(Long id) {
		categoriaRepository.deleteById(id);
	}

	public Categoria atualizar(Categoria categoria) {	
		return categoriaRepository.save(categoria);
	}

	public Categoria buscarPorDescricao(String descricao) {
		return categoriaRepository.findByDescricao(descricao).get();
	}
	
	public Categoria buscarPorId(Long id) {
		return categoriaRepository.findById(id).get();
	}
}
