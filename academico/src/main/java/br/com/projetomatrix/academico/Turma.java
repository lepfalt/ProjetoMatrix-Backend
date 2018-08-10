package br.com.projetomatrix.academico;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Turma {

	private String codigo;
	private Integer anoLetivo;
	private Integer semestre;
	private Date dataAbertura;
	private Date dataEncerramento;
	private Horario horarios; //Só tem um professor responsavel
	private Disciplina disciplina;
	private Professor professor;
	private List<Aluno> alunos;
	
	public Turma()
	{
		alunos = new ArrayList<>();
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Integer getAnoLetivo() {
		return anoLetivo;
	}
	public void setAnoLetivo(Integer anoLetivo) {
		this.anoLetivo = anoLetivo;
	}
	public Integer getSemestre() {
		return semestre;
	}
	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}
	public Date getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public Date getDataEncerramento() {
		return dataEncerramento;
	}
	public void setDataEncerramento(Date dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}
	public Horario getHorarios() {
		return horarios;
	}
	public void setHorarios(Horario horarios) {
		this.horarios = horarios;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
}
