package br.com.projetomatrix.academico.curso;

import java.util.List;

import br.com.projetomatrix.academico.Curso;
import br.com.projetomatrix.academico.Professor;

public class Disciplina {

	private String descricao;
	private String codigo;
	private Curso curso;
	private List<Professor> professores;
	private List<Disciplina> preRequisitos;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public List<Professor> getProfessores() {
		return professores;
	}
	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}
	
	public List<Disciplina> getPreRequisitos() {
		return preRequisitos;
	}
	public void setPreRequisitos(List<Disciplina> preRequisitos) {
		this.preRequisitos = preRequisitos;
	}
	
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
}
