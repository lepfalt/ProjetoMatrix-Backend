package com.br.matrix.lancamentos.lancamentos.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.matrix.lancamentos.lancamentos.models.Lancamento;
import com.br.matrix.lancamentos.lancamentos.models.LancamentoDTO;
import com.br.matrix.lancamentos.lancamentos.repositories.LancamentoRepository;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private EmpresaService empresaService;
	
	public Lancamento cadastrar(LancamentoDTO lancamentoDTO)
	{
		Lancamento lancamento = new Lancamento();
		BeanUtils.copyProperties(lancamentoDTO, lancamento);
		lancamento.setCategoria(categoriaService.buscarPorId(lancamentoDTO.getCategoriaId()));
		lancamento.setEmpresa(empresaService.buscarPorId(lancamentoDTO.getEmpresaId()));
		
		return lancamentoRepository.save(lancamento);
	}
	
	public Lancamento atualizar(LancamentoDTO lancamentoDTO)
	{
		Lancamento lancamento = new Lancamento();
		BeanUtils.copyProperties(lancamentoDTO, lancamento);
		lancamento.setCategoria(categoriaService.buscarPorId(lancamentoDTO.getCategoriaId()));
		lancamento.setEmpresa(empresaService.buscarPorId(lancamentoDTO.getEmpresaId()));
		
		return lancamentoRepository.save(lancamento);
	}
	
	public List<Lancamento> listar()
	{
		return lancamentoRepository.findAll();
	}
	
	public void remover(Long id)
	{
		lancamentoRepository.deleteById(id);
	}
	
	public Lancamento buscarPorId(Long id)
	{
		Optional<Lancamento> lancamentoOptional = lancamentoRepository.findById(id);
		if(!lancamentoOptional.isPresent())
			throw new IllegalArgumentException("id não encontrado no banco");
		
		return lancamentoOptional.get();
	}
	
	public List<Lancamento> buscarPorVencimento(LocalDate dataInicio, LocalDate dataFim)
	{
		return lancamentoRepository.findByVencimentoBetween(dataInicio, dataFim);
	}
}
