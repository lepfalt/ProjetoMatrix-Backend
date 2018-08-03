package br.com.projetomatrix.academico;

public class Disciplina {

	private String descricao;
	private long codigo;
	private Disciplina[] preRequisitos;
	private Curso curso;
	private Professor[] professores;
	
	// DESCRICAO
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	// CODIGO
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	
	// PRE-REQUISITOS
	public Disciplina[] getPreRequisitos() {
		return preRequisitos;
	}
	public void setPreRequisitos(Disciplina[] preRequisitos) {
		this.preRequisitos = preRequisitos;
	}
	
	// CURSO
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	// PROFESSORES
	public Professor[] getProfessores() {
		return professores;
	}
	public void setProfessores(Professor[] professores) {
		this.professores = professores;
	}
}
