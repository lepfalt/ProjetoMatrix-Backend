package br.com.projetomatrix.academico.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import br.com.projetomatrix.academico.Aluno;
import br.com.projetomatrix.academico.Avaliacao;
import br.com.projetomatrix.academico.Turma;

public class AlunoService {

	private Map<String, Aluno> hashAlunos = new HashMap<>();
	private TurmaService turmaService = new TurmaService();
	private AvaliacaoService avaliacaoService = new AvaliacaoService();
	
	public Aluno cadastrar(Aluno aluno)
	{
		if(aluno == null || hashAlunos.containsKey(aluno.getMatricula()))
			return aluno;
		
		aluno.setMatricula(gerarMatricula(aluno));
		
		hashAlunos.put(aluno.getMatricula(), aluno);
		
		return aluno;
	}
	
	public Aluno recuperar(String matricula)
	{
		if(matricula.equals(null) || matricula.toString().isEmpty())
			throw new IllegalArgumentException("Matricula inválida");
		
		return hashAlunos.get(matricula);
	}
	
	public Aluno atualizar(Aluno alunoAtualizado)
	{
		if(alunoAtualizado == null || !hashAlunos.containsKey(alunoAtualizado.getMatricula()))
			throw new IllegalArgumentException("Aluno inválido");
		
		hashAlunos.put(alunoAtualizado.getMatricula(), alunoAtualizado);
		
		return alunoAtualizado;
	}
	
	public void remover(Aluno aluno)
	{
		if(aluno == null || !hashAlunos.containsKey(aluno.getMatricula()))
			throw new IllegalArgumentException("Aluno não pode ser removido.");
		
		hashAlunos.remove(aluno.getMatricula());
	}
	
	public String gerarMatricula(Aluno aluno)
	{
		StringBuffer matricula = new StringBuffer();
		
		String mes = LocalDateTime.now().getMonthValue() <= 6 ? "1": "2";
		
		matricula
			.append(LocalDateTime.now().getYear())
			.append(mes)
			.append(hashAlunos.size()+1);
		
		return matricula.toString();
	}
	
	public Boolean verificarMatriculaAluno(Aluno aluno) 
	{
		return !ObjectUtils.isEmpty(aluno) &&
				!StringUtils.isEmpty(aluno.getMatricula()) &&
				hashAlunos.containsKey(aluno.getMatricula());
	}
	
	public List<Turma> recuperarTurmasAluno(Aluno aluno)
	{
		if(ObjectUtils.isEmpty(aluno))
			throw new IllegalArgumentException("O argumento passao não pode ser nulo.");
		
		return turmaService.buscarTurmasDoAluno(aluno); 
	}
	public List<Avaliacao> recuperarAvaliacoesAluno(Aluno aluno)
	{
		return new ArrayList<>(avaliacaoService.buscarTodasAvaliacoesAluno(aluno));
	}
	
	public BigDecimal calcularMediaDoAluno(List<Avaliacao> avaliacoes)
	{
		if(ObjectUtils.isEmpty(avaliacoes))
			throw new IllegalArgumentException();
		
		BigDecimal somaDasNotas = BigDecimal.ZERO;
		for(Avaliacao avaliacaoDaVez : avaliacoes)
		{
			somaDasNotas = somaDasNotas.add(avaliacaoDaVez.getNota());
		}
		
		return somaDasNotas.divide(BigDecimal.valueOf(3), 2, RoundingMode.HALF_UP);
	}
	/*public StatusAcademico buscarStatusAcademicoDoAluno(Aluno aluno, Turma turma)
	{
		if(!verificarMatriculaAluno(aluno) || ObjectUtils.isEmpty(turma))
			throw new IllegalArgumentException();
		
		if(avaliacaoService.buscarAvaliacoesAlunoNaTurma(aluno, turma).size() == 3)
		{
			if(calcularMediaDoAluno(avaliacaoService.buscarAvaliacoesAlunoNaTurma(aluno, turma)).compareTo(BigDecimal.valueOf(6)) >= 0)
				return StatusAcademico.APROVADO;
			else if(calcularMediaDoAluno(avaliacaoService.buscarAvaliacoesAlunoNaTurma(aluno, turma)).compareTo(BigDecimal.valueOf(4)) >= 0)
				return StatusAcademico.PROVA_FINAL;
			else
				return StatusAcademico.REPROVADO;
		}
		else
		{
			return StatusAcademico.REPROVADO;
		}
	}*/
}
