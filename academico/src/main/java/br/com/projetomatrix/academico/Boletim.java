package br.com.projetomatrix.academico;

public class Boletim {

	private Aluno aluno;
	private Turma turma;
	private double[] avaliacao;
	
	// ALUNO
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	// TURMA
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	// AVALIACAO
	public double[] getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(double[] avaliacao) {
		this.avaliacao = avaliacao;
	}
}
