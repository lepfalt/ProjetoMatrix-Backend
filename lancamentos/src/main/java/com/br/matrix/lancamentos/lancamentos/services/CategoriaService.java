package com.br.matrix.lancamentos.lancamentos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.matrix.lancamentos.lancamentos.models.Categoria;
import com.br.matrix.lancamentos.lancamentos.repositories.CategoriaRepository;

@Service 
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria cadastar(Categoria categoria)
	{
		return categoriaRepository.save(categoria);
	}
	
	public Categoria atualizar(Categoria categoria)
	{
		return categoriaRepository.save(categoria);
	}
	
	public List<Categoria> listar()
	{
		return categoriaRepository.findAll();
	}
	
	public void remover(Long id)
	{
		categoriaRepository.deleteById(id);
	}
	
	public Categoria buscarPorId(Long id)
	{
		Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);
		if(!categoriaOptional.isPresent())
			throw new IllegalArgumentException("id não encontrado no banco");
		
		return categoriaOptional.get();
	}
}
