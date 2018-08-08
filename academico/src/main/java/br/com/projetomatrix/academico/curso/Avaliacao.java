package br.com.projetomatrix.academico.curso;

import java.math.BigDecimal;
import java.util.Date;

import br.com.projetomatrix.academico.*;

public class Avaliacao {

	private Turma turma;
	private Aluno aluno;
	private String codigo;
	private Date data;
	private String descricao;
	private Modo modo;
	private Professor responsavel;
	private BigDecimal nota;
	
	public Avaliacao()
	{	
		
	}
	
	public Avaliacao(Turma turma, Aluno aluno, Date data, String descricao, Modo modo,
			Professor responsavel, BigDecimal nota) {
		
		setTurma(turma);
		setAluno(aluno);
		setCodigo("");
		setData(data);
		setDescricao(descricao);
		setModo(modo);
		setResponsavel(responsavel);
		setNota(nota);
		
		aluno.getAvaliacoes().add(this);
	}

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
	public BigDecimal getNota() {
		return nota;
	}
	public void setNota(BigDecimal nota) {
		this.nota = nota;
	}
}
