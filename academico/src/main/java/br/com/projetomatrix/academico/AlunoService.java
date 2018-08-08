package br.com.projetomatrix.academico;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.projetomatrix.academico.curso.*;

public class AlunoService {

	private Long sequencial = new Long(0);
	
	private Map<String, Aluno> hashAlunos = new HashMap<>();
	
	public Aluno cadastrarAluno(Aluno aluno)
	{	
		if(aluno == null || hashAlunos.containsKey(aluno.getMatricula()))
			return aluno;
	
		gerarMatricula(aluno);
		
		aluno.setStatus(Status.ATIVO);
			
		hashAlunos.put(aluno.getMatricula(), aluno);
		
		return aluno;
	}
	
	public void removerAluno(String matricula)
	{
		if(matricula == null || matricula.length() == 0)
			throw new IllegalArgumentException();
		
		recuperarAluno(matricula).setStatus(Status.INATIVO);
		
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
		
		String matricula = ano + semestre + sequencial++;
		
		aluno.setMatricula(matricula);
	}
	
	public BigDecimal calcularMediaDoAlunoPorTurma(String matricula, Turma turma) 
	{
		
		if(matricula == null || matricula.length() == 0)
			throw new IllegalArgumentException();
		
		Aluno aluno = recuperarAluno(matricula);
		List<Avaliacao> avaliacoes = aluno.getAvaliacoes();

		BigDecimal somaNotas = BigDecimal.ZERO;

		for(Avaliacao avaliacaoDaVez : avaliacoes)
		{	
			if(avaliacaoDaVez.getTurma().getCodigo().equals(turma.getCodigo()))
				somaNotas = somaNotas.add(avaliacaoDaVez.getNota());
		}

		return somaNotas.divide(BigDecimal.valueOf(3.0), 2, RoundingMode.HALF_UP);
	}

	public StatusAcademico buscarStatusAcademicoDoAlunoPorTurma(String matricula, Turma turma) 
	{
		
		if(matricula == null || matricula.length() == 0)
			throw new IllegalArgumentException();
		
		Boletim boletim = retornarBoletimPorTurma(matricula, turma);
		
		if(boletim.getAvaliacoes().size() == 3)
		{
			if (calcularMediaDoAlunoPorTurma(matricula, turma).compareTo(BigDecimal.valueOf(6)) >= 0)
				return StatusAcademico.APROVADO;
			else if (calcularMediaDoAlunoPorTurma(matricula, turma).compareTo(BigDecimal.valueOf(4)) >= 0)
				return StatusAcademico.PROVA_FINAL;
			else
				return StatusAcademico.REPROVADO;
		}
		else
		{
			return StatusAcademico.REPROVADO;
		}
	}
	
	public String buscarTurmasDoAluno(String matricula)
	{
		String turmasAluno = new String();
		
		Aluno aluno = recuperarAluno(matricula);
		
		List<Turma> turma = aluno.getTurmas();
		
		for(Turma turmaDaVez : turma)
		{
			turmasAluno +=  turmaDaVez.getDisciplina().getDescricao() + ", ";
		}
		
		return turmasAluno;
	}
	
	public String buscarBoletimDoAlunoPorDisciplina(String matricula, Disciplina disciplina)
	{
		String notasBoletim = new String();
		
		Boletim boletim = retornarBoletimPorTurma(matricula, retornarTurmaDaDisciplina(matricula, disciplina));
		
		int av = 1;
		for(Avaliacao avaliacaoDaVez : boletim.getAvaliacoes())
		{
			notasBoletim += "Avaliacao " + av + " de " + avaliacaoDaVez.getTurma().getDisciplina().getDescricao() + " = " + avaliacaoDaVez.getNota() + ".\n";
			av++;
		}
		
		return notasBoletim;
	}
	
	public Boletim retornarBoletimPorTurma(String matricula, Turma turma)
	{
		Aluno aluno = recuperarAluno(matricula);
		Boletim boletim = new Boletim(aluno, turma);
		
		List<Avaliacao> avaliacoes = aluno.getAvaliacoes();
		
		for(Avaliacao avaliacaoDaVez : avaliacoes)
		{
			if(avaliacaoDaVez.getTurma().getCodigo() == turma.getCodigo())
				boletim.adicionarAvaliacaoNoBoletim(avaliacaoDaVez);
		}
		
		return boletim;
	}
	
	public Turma retornarTurmaDaDisciplina(String matricula, Disciplina disciplina)
	{
		Aluno aluno = recuperarAluno(matricula);
		Turma turma = new Turma();
		for(Turma turmaDaVez : aluno.getTurmas())
		{
			if(turmaDaVez.getDisciplina().getCodigo() == disciplina.getCodigo())
				turma = turmaDaVez;
		}
		
		return turma;
	}
	
	public String buscarHistorico(String matricula)
	{	
		String exibirHistorico = new String();
		
		Historico historico = retornarHistoricoDoAluno(matricula);
		
		for(Boletim boletimDaVez : historico.getBoletins())
		{
			exibirHistorico += "Media da disciplina " + boletimDaVez.getTurma().getDisciplina().getDescricao() + " = " + calcularMediaDoAlunoPorTurma(matricula, boletimDaVez.getTurma()) + ".\n";
		}
		
		return exibirHistorico;
	}
	
	public Historico retornarHistoricoDoAluno(String matricula)
	{
		Historico historico = new Historico();
		Aluno aluno = recuperarAluno(matricula);
		
		for(Turma turmaDaVez : aluno.getTurmas())
			historico.adicionarBoletimNoHistorico(retornarBoletimPorTurma(matricula, turmaDaVez));
		
		return historico;
	}
}