package br.com.projetomatrix.academico.curso;

import java.util.ArrayList;
import java.util.List;

import br.com.projetomatrix.academico.*;

public class Turma {

	private Disciplina disciplina;
	private Professor professor;
	private List<Aluno> alunos;
	private String codigo;
	private Integer anoLetivo;
	private Integer semestre;
	private String dataAbertura;
	private String dataEncerramento;
	private Horario horarios;
	
	public Turma()
	{
		alunos = new ArrayList<>();
	}
	
	public Turma(Disciplina disciplina, Professor professor, Integer anoLetivo,
			Integer semestre, String dataAbertura, String dataEncerramento, Horario horarios) {
		
		setCodigo(" ");
		setDisciplina(disciplina);
		setAnoLetivo(anoLetivo);
		setSemestre(semestre);
		setDataAbertura(dataAbertura);
		setDataEncerramento(dataEncerramento);
		setHorarios(horarios);
		setProfessor(professor);
		professor.getTurmas().add(this);
		alunos = new ArrayList<>();
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
	public String getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(String dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public String getDataEncerramento() {
		return dataEncerramento;
	}
	public void setDataEncerramento(String dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}
	public Horario getHorarios() {
		return horarios;
	}
	public void setHorarios(Horario horarios) {
		this.horarios = horarios;
	}
	
	/*public void adicionarAluno(Aluno aluno)
	{
		aluno.adicionarTurma(this);
		alunos.add(aluno);
	}*/
}
