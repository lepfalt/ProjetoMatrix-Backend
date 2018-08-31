package com.br.matrix.receita.lancamentos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.matrix.receita.lancamentos.models.Empresa;
import com.br.matrix.receita.lancamentos.repositories.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	public Empresa salvar(Empresa empresa) {
		return empresaRepository.save(empresa);
	}

	public List<Empresa> listar() {
		return empresaRepository.findAll();
	}

	public void remover(Long id) {
		empresaRepository.deleteById(id);
	}

	public Empresa atualizar(Empresa empresa) {	
		return empresaRepository.save(empresa);
	}

	public Empresa buscarPorNomeECnpj(String nome, String cnpj) {
		return empresaRepository.findByNomeAndCnpj(nome, cnpj).get();
	}
}
