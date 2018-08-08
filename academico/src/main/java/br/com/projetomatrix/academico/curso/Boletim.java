package br.com.projetomatrix.academico.curso;

import java.util.ArrayList;
import java.util.List;

import br.com.projetomatrix.academico.*;

public class Boletim {

	private Aluno aluno;
	private Turma turma;
	private List<Avaliacao> avaliacoes;
	
	public Boletim()
	{
		avaliacoes = new ArrayList<>();
	}

	public Boletim(Aluno aluno, Turma turma) 
	{
		setAluno(aluno);
		setTurma(turma);
		avaliacoes = new ArrayList<>();
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
	
	public void adicionarAvaliacaoNoBoletim(Avaliacao avaliacao)
	{
		avaliacoes.add(avaliacao);
	}
}
