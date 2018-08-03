package br.com.projetomatrix.academico;

public class Aluno extends Usuario {

	private Curso curso;
	private Avaliacao[] avaliacoes;
	
	Aluno(String nome, String endereco, String telefone, Curso curso)
	{
		setNome(nome);
		setEndereco(endereco);
		setTelefone(telefone);
		setCurso(curso);
		setStatusAtual(Status.ATIVO);
	}

	// CURSO
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	// AVALIACOES
	public Avaliacao[] getAvaliacoes() {
		return avaliacoes;
	}
	public void setAvaliacoes(Avaliacao[] avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	
}
