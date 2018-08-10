package br.com.projetomatrix.academico;

import java.util.List;

public class Disciplina {

	private String codigo;
	private String descricao;
	private Curso curso;
	private List<Disciplina> preRequisitos;
	private List<Professor> professores;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public List<Disciplina> getPreRequisitos() {
		return preRequisitos;
	}
	public void setPreRequisitos(List<Disciplina> preRequisitos) {
		this.preRequisitos = preRequisitos;
	}
	public List<Professor> getProfessores() {
		return professores;
	}
	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}
}
