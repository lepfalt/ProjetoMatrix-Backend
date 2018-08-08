package br.com.projetomatrix.academico;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.projetomatrix.academico.curso.*;

public class ProfessorService {

	private Long sequencial = new Long(0);
	
	Map<String, Professor> hashProfessores = new HashMap<>();
	
	public Professor cadastrarProfessor(Professor professor)
	{
		if(professor != null && hashProfessores.containsKey(professor.getMatricula()) == false)
		{
			gerarMatricula(professor);
			
			professor.setStatus(Status.ATIVO);
			
			hashProfessores.put(professor.getMatricula(), professor);
		}
		
		return professor;
	}
	
	public void removerProfessor(String matricula)
	{
		if(matricula == null || matricula.length() == 0)
			throw new IllegalArgumentException();
		
		recuperarProfessor(matricula).setStatus(Status.INATIVO);
		
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
		
		String matricula = "P" + ano + semestre + sequencial++;
		
		professor.setMatricula(matricula);
	}
	
	public String buscarTurmasDoProfessor(String matricula)
	{
		String turmasProfessor = new String();
		
		Professor professor = recuperarProfessor(matricula);
		List<Turma> turmas = professor.getTurmas();
		
		for(Turma turmaDaVez : turmas)
		{
			turmasProfessor += turmaDaVez.getDisciplina().getDescricao() + ", ";
		}
		
		return turmasProfessor;
	}
	
	public void adicionarTurmaParaProfessor(Professor professor, Turma turma)
	{
		professor.getTurmas().add(turma);
	}
}
