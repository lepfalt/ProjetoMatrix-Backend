package br.com.projetomatrix.academico;

import java.util.ArrayList;
import java.util.List;

import br.com.projetomatrix.academico.curso.*;

public class Professor extends Pessoa{

	public Titulo titulo;
	private List<Turma> turmas;
	
	public Professor()
	{
		turmas = new ArrayList<>();
	}
	
	public Professor(String nome, String endereco, String telefone, Titulo titulo) {
		super(nome, endereco, telefone);
		
		setTitulo(titulo);
		turmas = new ArrayList<>();
	}

	public Titulo getTitulo() {
		return titulo;
	}

	public void setTitulo(Titulo titulo) {
		this.titulo = titulo;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
}
