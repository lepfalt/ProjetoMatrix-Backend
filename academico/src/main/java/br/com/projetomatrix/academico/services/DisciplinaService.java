package br.com.projetomatrix.academico.services;

import java.util.HashMap;
import java.util.Map;

import br.com.projetomatrix.academico.Disciplina;

public class DisciplinaService {

	Map<String, Disciplina> hashDisciplinas = new HashMap<>();
	
	public Disciplina cadastrar(Disciplina disciplina)
	{
		if(disciplina == null || hashDisciplinas.containsKey(disciplina.getCodigo()))
			throw new IllegalArgumentException("Avaliacao invalida");
		
		disciplina.setCodigo(gerarCodigo(disciplina));
		
		hashDisciplinas.put(disciplina.getCodigo(), disciplina);
		
		return disciplina;
	}
	
	public Disciplina recuperar(String codigo)
	{
		if(codigo.equals(null) || codigo.toString().isEmpty())
			throw new IllegalArgumentException("codigo invalido.");
		
		return hashDisciplinas.get(codigo);
	}
	
	public Disciplina atualizar(Disciplina disciplinaAtualizada)
	{
		if(disciplinaAtualizada == null || !hashDisciplinas.containsKey(disciplinaAtualizada.getCodigo()))
			throw new IllegalArgumentException("Dado invalido.");
		
		hashDisciplinas.put(disciplinaAtualizada.getCodigo(), disciplinaAtualizada);
		
		return disciplinaAtualizada;
		
	}
	
	public void remover(Disciplina disciplina)
	{
		if(disciplina == null || !hashDisciplinas.containsKey(disciplina.getCodigo()))
			throw new IllegalArgumentException("Avaliacao não encontrada");
		
		hashDisciplinas.remove(disciplina.getCodigo());
	}
	
	public String gerarCodigo(Disciplina disciplina)
	{
		StringBuffer codigo = new StringBuffer();
		
		codigo
			.append("D")
			//.append(disciplina.getDescricao().substring(0, 3))
			.append(hashDisciplinas.size()+1);
		
		return codigo.toString();
	}
}
