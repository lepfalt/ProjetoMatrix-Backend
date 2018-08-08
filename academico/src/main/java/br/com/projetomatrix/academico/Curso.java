package br.com.projetomatrix.academico;

import java.util.ArrayList;
import java.util.List;

import br.com.projetomatrix.academico.curso.Disciplina;

public class Curso {

	private String descricao;
	private String codigo;
	private Integer cargaHoraria;
	private String ementa;
	private String bibliografia;
	private Coordenador coordenador;
	private List<Disciplina> disciplinas;
	
	public Curso()
	{
		disciplinas = new ArrayList<>();
	}
	
	public Curso(String descricao, Integer cargaHoraria, String ementa, String bibliografia,
			Coordenador coordenador) {
		
		setCodigo("");
		setDescricao(descricao);
		setCargaHoraria(cargaHoraria);
		setEmenta(ementa);
		setBibliografia(bibliografia);
		setCoordenador(coordenador);
		disciplinas = new ArrayList<>();
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public Integer getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	public String getEmenta() {
		return ementa;
	}
	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}
	
	public String getBibliografia() {
		return bibliografia;
	}
	public void setBibliografia(String bibliografia) {
		this.bibliografia = bibliografia;
	}
	
	public Coordenador getCoordenador() {
		return coordenador;
	}
	public void setCoordenador(Coordenador coordenador) {
		this.coordenador = coordenador;
	}
	
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
}
