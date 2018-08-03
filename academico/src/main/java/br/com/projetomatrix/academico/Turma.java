package br.com.projetomatrix.academico;

import java.util.Date;

public class Turma {

	private long codigo;
	private long anoLetivo;
	private long semestre;
	private Date dataAbertura;
	private Date dataEncerramento;
	private Horario horarioDeAula;
	private Disciplina disciplinaLecionada;
	private Professor responsavel;
	private Aluno[] alunos;
	
	// CODIGO
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	
	// ANO LETIVO
	public long getAnoLetivo() {
		return anoLetivo;
	}
	public void setAnoLetivo(long anoLetivo) {
		this.anoLetivo = anoLetivo;
	}
	
	// SEMESTRE
	public long getSemestre() {
		return semestre;
	}
	public void setSemestre(long semestre) {
		this.semestre = semestre;
	}
	
	// DATA DE ABERTURA
	public Date getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	
	// DATA DE ENCERRAMENTO
	public Date getDataEncerramento() {
		return dataEncerramento;
	}
	public void setDataEncerramento(Date dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}
	
	// HORARIO DE AULA
	public Horario getHorarioDeAula() {
		return horarioDeAula;
	}
	public void setHorarioDeAula(Horario horarioDeAula) {
		this.horarioDeAula = horarioDeAula;
	}
	
	// DISCIPLINA LECIONADA
	public Disciplina getDisciplinaLecionada() {
		return disciplinaLecionada;
	}
	public void setDisciplinaLecionada(Disciplina disciplinaLecionada) {
		this.disciplinaLecionada = disciplinaLecionada;
	}
	
	// RESPONSAVEL
	public Professor getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(Professor responsavel) {
		this.responsavel = responsavel;
	}
	
	// ALUNOS
	public Aluno[] getAlunos() {
		return alunos;
	}
	public void setAlunos(Aluno[] alunos) {
		this.alunos = alunos;
	}
}
