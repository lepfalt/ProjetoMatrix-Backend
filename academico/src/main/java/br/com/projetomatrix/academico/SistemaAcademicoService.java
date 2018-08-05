package br.com.projetomatrix.academico;

import br.com.projetomatrix.academico.curso.Avaliacao;
import br.com.projetomatrix.academico.curso.Disciplina;
import br.com.projetomatrix.academico.curso.Horario;
import br.com.projetomatrix.academico.curso.Turma;

public class SistemaAcademicoService {
	
	private AlunoService alunoService = new AlunoService();
	private TurmaService turmaService = new TurmaService();
	private ProfessorService professorService = new ProfessorService();
	private CursoService cursoService = new CursoService();
	private CoordenadorService coordenadorService = new CoordenadorService();
	private DisciplinaService disciplinaService = new DisciplinaService();
	private HorarioService horarioService = new HorarioService();
	private AvaliacaoService avaliacaoService = new AvaliacaoService();
	
	// SERVICO DA AVALIACAO
	public Avaliacao cadastrarAvaliacao(Avaliacao avaliacao)
	{
		return avaliacaoService.cadastrarAvaliacao(avaliacao);
	}
	public void removerAvaliacao(String codigoAvaliacao)
	{
		avaliacaoService.removerAvaliacao(codigoAvaliacao);
	}
	public Avaliacao atualizarAvaliacao(Avaliacao avaliacaoAtualizada)
	{
		return avaliacaoService.atualizarAvaliacao(avaliacaoAtualizada);
	}
	public Avaliacao recuperarAvaliacao(String codigo)
	{
		return avaliacaoService.recuperarAvaliacao(codigo);
	}
	public void gerarCodigoAvaliacao(Avaliacao avaliacao)
	{
		avaliacaoService.gerarCodigoAvaliacao(avaliacao);
	}
	
	// SERVICO DE HORARIO
	public Horario cadastrarHorario(Horario horario)
	{
		return horarioService.cadastrarHorario(horario);
	}
	public void removerHorario(String codigoHorario)
	{
		horarioService.removerHorario(codigoHorario);
	}
	public Horario atualizarHorario(Horario horarioAtualizado)
	{
		return horarioService.atualizarHorario(horarioAtualizado);
	}
	public Horario recuperarHorario(String codigo)
	{
		return horarioService.recuperarHorario(codigo);
	}
	public void gerarCodigoHorario(Horario horario)
	{
		horarioService.gerarCodigoHorario(horario);
	}
	
	// SERVICO DA DISCIPLINA
	public Disciplina cadastrarDisciplina(Disciplina disciplina)
	{
		return disciplinaService.cadastrarDisciplina(disciplina);
	}
	public void removerDisciplina(String codigoDisicplina)
	{
		disciplinaService.removerDisciplina(codigoDisicplina);
	}
	public Disciplina atualizarDisciplina(Disciplina disciplinaAtualizada)
	{
		return disciplinaService.atualizarDisciplina(disciplinaAtualizada);
	}
	public Disciplina recuperarDisciplina(String codigo)
	{
		return disciplinaService.recuperarDisciplina(codigo);
	}
	public void gerarCodigoDisciplina(Disciplina disciplina)
	{
		disciplinaService.gerarCodigoDisciplina(disciplina);
	}
	
	// SERVICO DO COORDENADOR
	public Coordenador cadastrarCoordenador(Coordenador coordenador)
	{
		return coordenadorService.cadastrarCoordenador(coordenador);
	}
	public void removerCoordenador(String matricula)
	{
		coordenadorService.removerCoordenador(matricula);
	}
	public Coordenador atualizarCoordenador(Coordenador coordenadorAtualizado)
	{
		return coordenadorService.atualizarCoordenador(coordenadorAtualizado);
	}
	public Coordenador recuperarCoordenador(String matricula)
	{
		return coordenadorService.recuperarCoordenador(matricula);
	}
	public void gerarMatriculaCoordenador(Coordenador coordenador)
	{
		coordenadorService.gerarMatricula(coordenador);
	}
	
	// SERVICO DO CURSO
	public Curso cadastrarCurso(Curso curso)
	{
		return cursoService.cadastrarCurso(curso);
	}
	public void removerCurso(String codigoCurso)
	{
		cursoService.removerCurso(codigoCurso);
	}
	public Curso atualizarCurso(Curso cursoAtualizado)
	{
		return cursoService.atualizarCurso(cursoAtualizado);
	}
	public Curso recuperarCurso(String codigo)
	{		
		return cursoService.recuperarCurso(codigo);
	}
	public void gerarCodigoCurso(Curso curso)
	{
		cursoService.gerarCodigoCurso(curso);
	}
	
	// SERVICO DO PROFESSOR
	public Professor cadastrarProfessor(Professor professor)
	{
		return professorService.cadastrarProfessor(professor);
	}
	public void removerProfessor(String matricula)
	{
		professorService.removerProfessor(matricula);
	}
	public Professor atualizarProfessor(Professor professorAtualizado)
	{
		return professorService.atualizarProfessor(professorAtualizado);
	}
	public Professor recuperarProfessor(String matricula)
	{
		return professorService.recuperarProfessor(matricula);
	}
	public void gerarMatriculaProfessor(Professor professor)
	{
		professorService.gerarMatricula(professor);
	}
	
	// SERVICO DA TURMA
	public Turma cadastrarTurma(Turma turma)
	{
		return turmaService.cadastrarTurma(turma);
	}
	public void removerTurma(String codigo)
	{
		turmaService.removerTurma(codigo);
	}
	public Turma atualizarTurma(Turma turmaAtualizada)
	{
		return turmaService.atualizarTurma(turmaAtualizada);
	}
	public Turma recuperarTurma(String codigoTurma)
	{
		return turmaService.recuperarTurma(codigoTurma);
	}
	public void gerarCodigoTurma(Turma turma)
	{
		turmaService.gerarCodigoTurma(turma);
	}
	
	// SERVICO DO ALUNO
	public Aluno cadastrarAluno(Aluno aluno)
	{
		return alunoService.cadastrarAluno(aluno);
	}
	public void removerAluno(String matricula)
	{
		alunoService.removerAluno(matricula);
	}
	public Aluno atualizarAluno(Aluno alunoAtualizado)
	{	
		return alunoService.atualizarAluno(alunoAtualizado);
	}
	public Aluno recuperarAluno(String matricula)
	{
		return alunoService.recuperarAluno(matricula);
	}
	public void gerarMatriculaAluno(Aluno aluno)
	{	
		alunoService.gerarMatricula(aluno);
	}
}