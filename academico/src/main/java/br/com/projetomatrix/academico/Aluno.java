package br.com.projetomatrix.academico;

import java.util.List;

import br.com.projetomatrix.academico.curso.Avaliacao;

public class Aluno extends Pessoa{

	private Curso curso;
	private List<Avaliacao> avaliacoes;

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
}
