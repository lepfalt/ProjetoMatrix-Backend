package br.com.projetomatrix.academico.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.ObjectUtils;

import br.com.projetomatrix.academico.Aluno;
import br.com.projetomatrix.academico.Professor;
import br.com.projetomatrix.academico.Turma;

public class TurmaService {

	Map<String, Turma> hashTurmas = new HashMap<>();
	
	public Turma cadastrar(Turma turma)
	{
		if(ObjectUtils.isEmpty(turma) || hashTurmas.containsKey(turma.getCodigo()))
			return turma;
		
		turma.setCodigo(gerarCodigo(turma));
		
		hashTurmas.put(turma.getCodigo(), turma);
		
		return turma;
	}
	
	public Turma recuperar(String codigo)
	{
		if(codigo.equals(null) || codigo.toString().isEmpty())
			throw new IllegalArgumentException("Matricula inválida");
		
		return hashTurmas.get(codigo);
	}
	
	public Turma atualizar(Turma turmaAtualizado)
	{
		if(turmaAtualizado == null || !hashTurmas.containsKey(turmaAtualizado.getCodigo()))
			throw new IllegalArgumentException("Turma inválida");
		
		hashTurmas.put(turmaAtualizado.getCodigo(), turmaAtualizado);
		
		return turmaAtualizado;
	}
	
	public void remover(Turma turma)
	{
		if(turma == null || !hashTurmas.containsKey(turma.getCodigo()))
			throw new IllegalArgumentException("Turma não pode ser removida.");
		
		hashTurmas.remove(turma.getCodigo());
	}
	
	public String gerarCodigo(Turma turma)
	{
		String codigo = new String();
		
		codigo = "T" + LocalDateTime.now().getDayOfWeek().getValue() + hashTurmas.size()+1;
				
		return codigo;
	}
	
	public List<Turma> buscarTurmasDoProfessor(Professor professor)
	{
		if(ObjectUtils.isEmpty(professor))
			throw new IllegalArgumentException("Argumento passado é nulo");
		
		ArrayList<Turma> turmas = new ArrayList<>(hashTurmas.values());
		ArrayList<Turma> turmasProfessor = new ArrayList<>();
		for(Turma turmaDaVez : turmas)
		{
			if(turmaDaVez.getProfessor().getMatricula().equals(professor.getMatricula()))
				turmasProfessor.add(turmaDaVez);
		}
		
		return turmasProfessor;
	}
	
	public List<Turma> buscarTurmasDoAluno(Aluno aluno)
	{
		if(ObjectUtils.isEmpty(aluno))
			throw new IllegalArgumentException("Argumento passado é nulo");
		
		ArrayList<Turma> turmas = new ArrayList<>(hashTurmas.values());
		ArrayList<Turma> turmasAluno = new ArrayList<>();
		
		for(Turma turmaDaVez : turmas)
		{
			if(turmaDaVez.getAlunos().contains(aluno))
				turmasAluno.add(turmaDaVez);
		}
		
		return turmasAluno;
	}
	
	public List<Turma> recuperarTodasAsTurmas()
	{
		return new ArrayList<>(hashTurmas.values());
	}
	
	public List<Aluno> retornarTodosAlunosTurma(Turma turma)
	{
		List<Turma> todasAsTurmas = new ArrayList<>(hashTurmas.values());
		String turmaExiste = new String();
		for(Turma turmaDaVez : todasAsTurmas)
		{
			if(turmaDaVez.getCodigo().equals(turma.getCodigo()))
				turmaExiste = turmaDaVez.getCodigo();
		}
		
		return hashTurmas.get(turmaExiste).getAlunos();
	}
}
