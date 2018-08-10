package br.com.projetomatrix.academico.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.ObjectUtils;

import br.com.projetomatrix.academico.Aluno;
import br.com.projetomatrix.academico.Avaliacao;
import br.com.projetomatrix.academico.Boletim;
import br.com.projetomatrix.academico.Coordenador;
import br.com.projetomatrix.academico.Curso;
import br.com.projetomatrix.academico.Disciplina;
import br.com.projetomatrix.academico.Historico;
import br.com.projetomatrix.academico.Horario;
import br.com.projetomatrix.academico.Professor;
import br.com.projetomatrix.academico.Status;
import br.com.projetomatrix.academico.StatusAcademico;
import br.com.projetomatrix.academico.Turma;

public class SistemaAcademicoService {

	private AlunoService alunoService = new AlunoService();
	private ProfessorService professorService = new ProfessorService();
	private CoordenadorService coordenadorService = new CoordenadorService();
	private CursoService cursoService = new CursoService();
	private DisciplinaService disciplinaService = new DisciplinaService();
	private HorarioService horarioService = new HorarioService();
	private AvaliacaoService avaliacaoService = new AvaliacaoService();
	private TurmaService turmaService = new TurmaService();
	
	
	public BigDecimal calcularMediaDoAluno(Aluno aluno, Turma turma) //OK
	{
		List<Avaliacao> avaliacoes = new ArrayList<>();
		for(Avaliacao avaliacaoDaVez : avaliacaoService.hashAvaliacoes.values())
		{
			if(avaliacaoDaVez.getTurma().getCodigo().equals(turma.getCodigo()) && avaliacaoDaVez.getAluno().getMatricula().equals(aluno.getMatricula()))
				avaliacoes.add(avaliacaoDaVez);
		}
		
		return alunoService.calcularMediaDoAluno(avaliacoes);
	}
	public StatusAcademico buscarStatusAcademicoDoAluno(Aluno aluno, Turma turma) //OK
	{
		if(!alunoService.verificarMatriculaAluno(aluno) || ObjectUtils.isEmpty(turma))
			throw new IllegalArgumentException();
		
		if(avaliacaoService.buscarAvaliacoesAlunoNaTurma(aluno, turma).size() == 3)
		{
			if(calcularMediaDoAluno(aluno, turma).compareTo(BigDecimal.valueOf(6)) >= 0)
				return StatusAcademico.APROVADO;
			else if(calcularMediaDoAluno(aluno, turma).compareTo(BigDecimal.valueOf(4)) >= 0)
				return StatusAcademico.PROVA_FINAL;
			else
				return StatusAcademico.REPROVADO;
		}
		else
		{
			return StatusAcademico.REPROVADO;
		}
	}
	public Boletim gerarBoletimDoAluno(Aluno aluno, Turma turma) //OK
	{
		ArrayList<Avaliacao> avaliacoesAluno = avaliacaoService.buscarAvaliacoesAlunoNaTurma(aluno, turma);
		Boletim boletimAluno = new Boletim(aluno, turma, avaliacoesAluno);
		
		return boletimAluno;
	}
	public Historico gerarHistoricoDoAluno(Aluno aluno) //OK
	{
		if(ObjectUtils.isEmpty(aluno))
			throw new IllegalArgumentException("O argumento passado não pode ser nulo.");
		
		List<Boletim> boletins = new ArrayList<>();
		List<Turma> turmasAluno = turmaService.buscarTurmasDoAluno(aluno);
		for(Turma turmaDaVez : turmasAluno)
		{
			Boletim boletimDaVez = new Boletim(aluno, turmaDaVez, avaliacaoService.buscarAvaliacoesAlunoNaTurma(aluno, turmaDaVez));
			boletins.add(boletimDaVez);
		}
		
		Historico historico = new Historico(aluno, boletins);
		return historico;
	}
	public Boletim buscarBoletimPorDisciplina(Aluno aluno, Disciplina disciplina) //OK
	{
		if(ObjectUtils.isEmpty(aluno) || ObjectUtils.isEmpty(disciplina))
			throw new IllegalArgumentException("O argumento passado não pode ser nulo.");
		
		Turma turmaDeBusca = new Turma();
		List<Turma> turmasAluno = turmaService.buscarTurmasDoAluno(aluno);
		for(Turma turmaDaVez : turmasAluno)
		{
			if(turmaDaVez.getDisciplina().getCodigo().equals(disciplina.getCodigo()))
				turmaDeBusca = turmaDaVez;
		}
		
		Boletim boletim = gerarBoletimDoAluno(aluno, turmaDeBusca);
		
		return boletim;
	}
	
	public void matricularAlunoEmTurma(Aluno aluno, Turma turma)
	{		
		if(ObjectUtils.isEmpty(aluno) || aluno.getStatus() == Status.INATIVO || turma.getAlunos().contains(aluno))
			throw new IllegalArgumentException();
		
		List<Aluno> alunosTurma = turmaService.retornarTodosAlunosTurma(turma);
		alunosTurma.add(aluno);
		turma.setAlunos(alunosTurma);
		turmaService.atualizar(turma);
	}
	public void cadastrarProfessorEmTurma(Professor professor, Turma turma)
	{
		if(professor == null || turma == null)
			throw new IllegalArgumentException("Argumento passado não pode ser nulo.");
		if(!ObjectUtils.isEmpty(turma.getProfessor()))
			throw new IllegalArgumentException();
		
		turma.setProfessor(professor);
		
	}
	
	// SERVICO DO ALUNO
	public Aluno cadastrar(Aluno aluno)
	{
		return alunoService.cadastrar(aluno);
	}
	public Aluno recuperarAluno(String matricula)
	{
		return alunoService.recuperar(matricula);
	}
	public Aluno atualizar(Aluno alunoAtualizado)
	{
		return alunoService.atualizar(alunoAtualizado);
	}
	public void remover(Aluno aluno)
	{
		alunoService.remover(aluno);
	}
	public String gerarMatricula(Aluno aluno)
	{
		return alunoService.gerarMatricula(aluno);
	}
	
	
	
	// SERVICOS DO PROFESSOR
	public Professor cadastrar(Professor professor)
	{
		return professorService.cadastrar(professor);
	}
	public Professor recuperarProfessor(String matricula)
	{
		return professorService.recuperar(matricula);
	}
	public Professor atualizar(Professor professorAtualizado)
	{
		return professorService.atualizar(professorAtualizado);
	}
	public void remover(Professor professor)
	{
		professorService.remover(professor);
	}
	public String gerarMatricula(Professor professor)
	{
		return professorService.gerarMatricula(professor);
	}
	
	// SERVICOS DO COORDENADOR
	public Coordenador cadastrar(Coordenador coordenador)
	{
		return coordenadorService.cadastrar(coordenador);
	}
	public Coordenador recuperarCoordenador(String matricula)
	{
		return coordenadorService.recuperar(matricula);
	}
	public Coordenador atualizar(Coordenador coordenadorAtualizado)
	{
		return coordenadorService.atualizar(coordenadorAtualizado);
	}
	public void remover(Coordenador coordenador)
	{
		coordenadorService.remover(coordenador);
	}
	public String gerarMatricula(Coordenador coordenador)
	{
		return coordenadorService.gerarMatricula(coordenador);
	}
	
	// SERVICO DO CURSO
	public Curso cadastrar(Curso curso)
	{
		return cursoService.cadastrar(curso);
	}
	public Curso recuperarCurso(String codigo)
	{
		return cursoService.recuperar(codigo);
	}
	public Curso atualizar(Curso cursoAtualizado)
	{
		return cursoService.atualizar(cursoAtualizado);
	}
	public void remover(Curso curso)
	{
		cursoService.remover(curso);
	}
	public String gerarCodigo(Curso curso)
	{
		return cursoService.gerarCodigo(curso);
	}
	
	// SERVICO DA DISCIPLINA
	public Disciplina cadastrar(Disciplina disciplina)
	{
		return disciplinaService.cadastrar(disciplina);
	}
	public Disciplina recuperarDisicplina(String codigo)
	{
		return disciplinaService.recuperar(codigo);
	}
	public Disciplina atualizar(Disciplina disciplinaAtualizada)
	{
		return disciplinaService.atualizar(disciplinaAtualizada);
	}
	public void remover(Disciplina disciplina)
	{
		disciplinaService.remover(disciplina);
	}
	public String gerarCodigo(Disciplina disciplina)
	{
		return disciplinaService.gerarCodigo(disciplina);
	}
	
	// SERVICO DO HORARIO
	public Horario cadastrar(Horario horario)
	{
		return horarioService.cadastrar(horario);
	}
	public Horario recuperarHorario(String codigo)
	{
		return horarioService.recuperar(codigo);
	}
	public Horario atualizar(Horario horarioAtualizado)
	{
		return horarioService.atualizar(horarioAtualizado);
	}
	public void remover(Horario horario)
	{
		horarioService.remover(horario);
	}
	public String gerarCodigo(Horario horario)
	{
		return horarioService.gerarCodigo(horario);
	}
	
	// SERVICO DA AVALIACAO
	public Avaliacao cadastrar(Avaliacao avaliacao)
	{
		return avaliacaoService.cadastrar(avaliacao);
	}
	public Avaliacao recuperarAvaliacao(String codigo)
	{
		return avaliacaoService.recuperar(codigo);
	}
	public Avaliacao atualizar(Avaliacao avaliacaoAtualizada)
	{
		return avaliacaoService.atualizar(avaliacaoAtualizada);
	}
	public void remover(Avaliacao avaliacao)
	{
		avaliacaoService.remover(avaliacao);
	}
	public String gerarCodigo(Avaliacao avaliacao)
	{
		return avaliacaoService.gerarCodigo(avaliacao);
	}
	
	// SERVICO DA TURMA
	public Turma cadastrar(Turma turma)
	{
		return turmaService.cadastrar(turma);
	}
	public Turma recuperarTurma(String matricula)
	{
		return turmaService.recuperar(matricula);
	}
	public Turma atualizar(Turma turmaAtualizado)
	{
		return turmaService.atualizar(turmaAtualizado);
	}
	public void remover(Turma turma)
	{
		turmaService.remover(turma);
	}
	public String gerarCodigo(Turma turma)
	{
		return turmaService.gerarCodigo(turma);
	}
	public List<Turma> buscarTurmasDoProfessor(Professor professor)
	{
		return turmaService.buscarTurmasDoProfessor(professor);
	}
	public List<Turma> buscarTurmasDoAluno(Aluno aluno)
	{
		return turmaService.buscarTurmasDoAluno(aluno);
	}
}