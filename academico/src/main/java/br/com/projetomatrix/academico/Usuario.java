package br.com.projetomatrix.academico;

public class Usuario {

	private String nome;
	private String endereco;
	private String telefone;
	private long matricula;
	private Status statusAtual;
	
	// NOME
	public String getNome()
	{
		return this.nome;
	}
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
	
	// ENDERECO
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	// TELEFONE
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	// MATRICULA
	public long getMatricula() {
		return matricula;
	}
	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}

	

	// STATUS ATUAL
	public Status getStatusAtual() {
		return statusAtual;
	}
	public void setStatusAtual(Status statusAtual) {
		this.statusAtual = statusAtual;
	}
}
