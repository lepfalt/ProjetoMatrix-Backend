package br.com.projetomatrix.academico;

public class Professor extends Usuario{

	private String titulo;
	private Disciplina[] disciplinas; // Tem que lecionar alguma disciplina
	
	Professor(String nome, String endereco, String telefone, String titulo)
	{
		setNome(nome);
		setStatusAtual(Status.ATIVO);
		setEndereco(endereco);
		setTelefone(telefone);
		setTitulo(titulo);
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Disciplina[] getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(Disciplina[] disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	
}
