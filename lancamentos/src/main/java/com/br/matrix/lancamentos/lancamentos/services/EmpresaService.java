package com.br.matrix.lancamentos.lancamentos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.matrix.lancamentos.lancamentos.models.Empresa;
import com.br.matrix.lancamentos.lancamentos.repositories.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	public Empresa cadastrar(Empresa empresa)
	{
		return empresaRepository.save(empresa);
	}
	
	public Empresa atualizar(Empresa empresa)
	{
		return empresaRepository.save(empresa);
	}
	
	public List<Empresa> listar()
	{
		return empresaRepository.findAll();
	}
	
	public void remover(Long id)
	{
		empresaRepository.deleteById(id);
	}
	
	public Empresa buscarPorId(Long id)
	{
		Optional<Empresa> empresaOptional = empresaRepository.findById(id);
		if(!empresaOptional.isPresent())
			throw new IllegalArgumentException("id não encontrado no banco");
		
		return empresaOptional.get();
	}
}
