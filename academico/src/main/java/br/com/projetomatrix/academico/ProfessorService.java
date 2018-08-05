package br.com.projetomatrix.academico;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ProfessorService {

	private Long sequencial = new Long(0);
	
	Map<String, Professor> hashProfessores = new HashMap<>();
	
	public Professor cadastrarProfessor(Professor professor)
	{
		if(professor != null && hashProfessores.containsKey(professor.getMatricula()) == false)
		{
			gerarMatricula(professor);
			
			hashProfessores.put(professor.getMatricula(), professor);
		}
		
		return professor;
	}
	
	public void removerProfessor(String matricula)
	{
		if(matricula == null || matricula.length() == 0)
			throw new IllegalArgumentException();
		
		hashProfessores.remove(matricula);
	}
	
	public Professor atualizarProfessor(Professor professorAtualizado)
	{
		if(professorAtualizado == null || professorAtualizado.getMatricula() == null ||
			professorAtualizado.getMatricula().length() == 0)
			throw new IllegalArgumentException();
		
		removerProfessor(professorAtualizado.getMatricula());
		
		cadastrarProfessor(professorAtualizado);
		
		return professorAtualizado;
	}
	
	public Professor recuperarProfessor(String matricula)
	{
		if(matricula == null || matricula.length() == 0)
			throw new IllegalArgumentException();
		
		return hashProfessores.get(matricula);
	}
	
	public void gerarMatricula(Professor professor)
	{
		// ano . semestre . sequencial
		String ano = Integer.toString(LocalDateTime.now().getYear());
		
		Integer mes = LocalDateTime.now().getMonthValue();
		String semestre = mes <= 6 ? "1" : "2";
		
		sequencial.sum(sequencial, 1);
		
		String matricula = ano + semestre + "P" + sequencial.intValue();
		
		professor.setMatricula(matricula);
	}
}
