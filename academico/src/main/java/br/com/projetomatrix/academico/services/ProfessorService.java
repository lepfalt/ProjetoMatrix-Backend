package br.com.projetomatrix.academico.services;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.ObjectUtils;

import br.com.projetomatrix.academico.Professor;
import br.com.projetomatrix.academico.Turma;

public class ProfessorService {

	Map<String, Professor> hashProfessores = new HashMap<>();
	TurmaService turmaService = new TurmaService();
	
	public List<Turma> recuperarTurmasProfessor(Professor professor)
	{
		if(ObjectUtils.isEmpty(professor))
			throw new IllegalArgumentException("O argumento passao não pode ser nulo.");
		
		return turmaService.buscarTurmasDoProfessor(professor); 
	}
	
	public Professor cadastrar(Professor professor)
	{
		if(professor == null || hashProfessores.containsKey(professor.getMatricula()))
			return professor;
		
		professor.setMatricula(gerarMatricula(professor));
		
		hashProfessores.put(professor.getMatricula(), professor);
		
		return professor;
	}
	
	public Professor recuperar(String matricula)
	{
		if(matricula.equals(null) || matricula.toString().isEmpty())
			throw new IllegalArgumentException("Matricula inválida");
		
		return hashProfessores.get(matricula);
	}
	
	public Professor atualizar(Professor professorAtualizado)
	{
		if(professorAtualizado == null || !hashProfessores.containsKey(professorAtualizado.getMatricula()))
			throw new IllegalArgumentException("Professor inválido");
		
		hashProfessores.put(professorAtualizado.getMatricula(), professorAtualizado);
		
		return professorAtualizado;
	}
	
	public void remover(Professor professor)
	{
		if(professor == null || !hashProfessores.containsKey(professor.getMatricula()))
			throw new IllegalArgumentException("Aluno não pode ser removido.");
		
		hashProfessores.remove(professor.getMatricula());
	}
	
	public String gerarMatricula(Professor professor)
	{
		StringBuffer matricula = new StringBuffer();
		
		String mes = LocalDateTime.now().getMonthValue() <= 6 ? "1": "2";
		
		matricula
			.append("P")
			.append(LocalDateTime.now().getYear())
			.append(mes)
			.append(hashProfessores.size()+1);
		
		return matricula.toString();
	}
}
