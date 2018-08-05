package br.com.projetomatrix.academico.curso;

import java.util.List;

import br.com.projetomatrix.academico.Aluno;

public class Historico {

	private Aluno aluno;
	private List<Boletim> boletins;

	public List<Boletim> getBoletins() {
		return boletins;
	}

	public void setBoletins(List<Boletim> boletins) {
		this.boletins = boletins;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
}
