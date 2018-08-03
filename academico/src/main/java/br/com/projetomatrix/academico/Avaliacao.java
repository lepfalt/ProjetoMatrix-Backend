package br.com.projetomatrix.academico;

import java.util.Date;

public class Avaliacao {

	private long codigo;
	private Date data;
	private String descricao;
	private String modo;
	private Professor responsavel;
	private Turma turma;
	
	// CODIGO
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	
	// DATA
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	// DESCRICAO
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	// MODO
	public String getModo() {
		return modo;
	}
	public void setModo(String modo) {
		this.modo = modo;
	}
	
	// RESPONSAVEL
	public Professor getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(Professor responsavel) {
		this.responsavel = responsavel;
	}
	
	// TURMA
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
}
