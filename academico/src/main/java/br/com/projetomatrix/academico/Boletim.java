package br.com.projetomatrix.academico;

import java.util.List;

public class Boletim {

	private Aluno aluno;
	private Turma turma;
	private List<Avaliacao> avaliacoes;
	
	public Boletim(Aluno aluno, Turma turma, List<Avaliacao> avaliacoes) {
		super();
		this.aluno = aluno;
		this.turma = turma;
		this.avaliacoes = avaliacoes;
	}
	
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
