package br.com.projetomatrix.academico.curso;

import java.util.List;

import br.com.projetomatrix.academico.Aluno;

public class Boletim {

	private Aluno aluno;
	private Turma turma;
	private List<Avaliacao> avaliacoes;
	
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}
	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}
}
