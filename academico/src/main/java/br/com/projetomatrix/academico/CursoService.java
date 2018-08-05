package br.com.projetomatrix.academico;

import java.util.HashMap;
import java.util.Map;

public class CursoService {

	private Long sequencial = new Long(0);
	
	Map<String, Curso> hashCursos = new HashMap<>();
	
	public Curso cadastrarCurso(Curso curso)
	{
		if(curso != null && hashCursos.containsKey(curso.getCodigo()) == false)
		{
			gerarCodigoCurso(curso);
			hashCursos.put(curso.getCodigo(), curso);
		}
		
		return curso;
	}
	
	public void removerCurso(String codigoCurso)
	{
		if(codigoCurso == null || codigoCurso.length() == 0)
			throw new IllegalArgumentException();
		
		hashCursos.remove(codigoCurso);
	}
	
	public Curso atualizarCurso(Curso cursoAtualizado)
	{
		if(cursoAtualizado == null || cursoAtualizado.getCodigo() == null ||
			cursoAtualizado.getCodigo().length() == 0)
			throw new IllegalArgumentException();
		
		removerCurso(cursoAtualizado.getCodigo());
		
		cadastrarCurso(cursoAtualizado);
		
		return cursoAtualizado;
	}
	
	public Curso recuperarCurso(String codigo)
	{
		if(codigo == null || codigo.length() == 0)
			throw new IllegalArgumentException();
		
		return hashCursos.get(codigo);
	}
	
	public void gerarCodigoCurso(Curso curso)
	{
		String iniciais = new String();
		
		int i = 1;
		while(curso.getDescricao().length() >= i)
		{
			if(curso.getDescricao().charAt(i-1) == ' ')
				iniciais += curso.getDescricao().charAt(i);
			i++;
		}
		
		sequencial.sum(sequencial, 1);
		
		String codigo = iniciais.toUpperCase() + sequencial.intValue();
		
		curso.setCodigo(codigo);
	}
}
