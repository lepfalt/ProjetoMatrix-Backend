package br.com.projetomatrix.academico.curso;

import java.util.Date;

import br.com.projetomatrix.academico.Aluno;
import br.com.projetomatrix.academico.Professor;

public class Avaliacao {

	private Turma turma;
	private Aluno aluno;
	private String codigo;
	private Date data;
	private String descricao;
	private Modo modo;
	private Professor responsavel;
	private Double nota; //Double
	
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Modo getModo() {
		return modo;
	}
	public void setModo(Modo modo) {
		this.modo = modo;
	}
	public Professor getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(Professor responsavel) {
		this.responsavel = responsavel;
	}
	public Double getNota() {
		return nota;
	}
	public void setNota(Double nota) {
		this.nota = nota;
	}
}
