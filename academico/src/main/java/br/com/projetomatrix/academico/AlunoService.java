package br.com.projetomatrix.academico;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class AlunoService {

private Long sequencial = new Long(0);
	
	Map<String, Aluno> hashAlunos = new HashMap<>();
	
	public Aluno cadastrarAluno(Aluno aluno)
	{
		if(aluno != null && hashAlunos.containsKey(aluno.getMatricula()) == false)
		{
			gerarMatricula(aluno);
			
			hashAlunos.put(aluno.getMatricula(), aluno);
		}
		
		return aluno;
	}
	
	public void removerAluno(String matricula)
	{
		if(matricula == null || matricula.length() == 0)
			throw new IllegalArgumentException();
		
		hashAlunos.remove(matricula);
	}
	
	public Aluno atualizarAluno(Aluno alunoAtualizado)
	{
		if(alunoAtualizado == null || alunoAtualizado.getMatricula() == null ||
			alunoAtualizado.getMatricula().length() == 0)
			throw new IllegalArgumentException();
		
		removerAluno(alunoAtualizado.getMatricula());
		
		cadastrarAluno(alunoAtualizado);
		
		return alunoAtualizado;
	}
	
	public Aluno recuperarAluno(String matricula)
	{
		if(matricula == null || matricula.length() == 0)
			throw new IllegalArgumentException();
		
		return hashAlunos.get(matricula);
	}
	
	public void gerarMatricula(Aluno aluno)
	{
		String ano = Integer.toString(LocalDateTime.now().getYear());
		
		int mes = LocalDateTime.now().getMonthValue();
		String semestre = mes <= 6 ? "1" : "2";
		
		//sequencial.sum(sequencial, 1);
		
		String matricula = ano + semestre + sequencial++;
		
		aluno.setMatricula(matricula);
	}
}
