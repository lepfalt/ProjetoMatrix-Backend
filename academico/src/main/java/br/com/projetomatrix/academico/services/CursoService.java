package br.com.projetomatrix.academico.services;

import java.util.HashMap;
import java.util.Map;

import br.com.projetomatrix.academico.Curso;

public class CursoService {

	Map<String, Curso> hashCursos = new HashMap<>();
	
	public Curso cadastrar(Curso curso)
	{
		if(curso == null || hashCursos.containsKey(curso.getCodigo()))
			throw new IllegalArgumentException("Avaliacao invalida");
		
		curso.setCodigo(gerarCodigo(curso));
		
		hashCursos.put(curso.getCodigo(), curso);
		
		return curso;
	}
	
	public Curso recuperar(String codigo)
	{
		if(codigo.equals(null) || codigo.toString().isEmpty())
			throw new IllegalArgumentException("codigo invalido.");
		
		return hashCursos.get(codigo);
	}
	
	public Curso atualizar(Curso cursoAtualizado)
	{
		if(cursoAtualizado == null || !hashCursos.containsKey(cursoAtualizado.getCodigo()))
			throw new IllegalArgumentException("Dado invalido.");
		
		hashCursos.put(cursoAtualizado.getCodigo(), cursoAtualizado);
		
		return cursoAtualizado;
		
	}
	
	public void remover(Curso curso)
	{
		if(curso == null || !hashCursos.containsKey(curso.getCodigo()))
			throw new IllegalArgumentException("Avaliacao não encontrada");
		
		hashCursos.remove(curso.getCodigo());
	}
	
	public String gerarCodigo(Curso curso)
	{
		StringBuffer codigo = new StringBuffer();
		
		codigo
			.append("C")
			.append(curso.getDescricao().substring(0, 3))
			.append(hashCursos.size()+1);
		
		return codigo.toString();
	}
}
