package br.com.projetomatrix.academico;

import java.util.ArrayList;
import java.util.List;

import br.com.projetomatrix.academico.curso.*;

public class Aluno extends Pessoa{

	private Curso curso;
	private List<Avaliacao> avaliacoes;
	private List<Turma> turmas;

	public Aluno() 
	{
		avaliacoes = new ArrayList<>();
		turmas = new ArrayList<>(); 
	}

	public Aluno(String nome, String endereco, String telefone, Curso curso) {
		super(nome, endereco, telefone);
		
		setCurso(curso);
		avaliacoes = new ArrayList<>();
		turmas = new ArrayList<>();
	}

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}
	
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
}
