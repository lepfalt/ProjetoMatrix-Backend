package br.com.projetomatrix.academico;

public class Curso {

	private Disciplina[] disciplinasCurso;
	private String descricao;
	private long codigo;
	private long cargaHoraria;
	private String ementa;
	private String bibliografia;
	private Coordenador coordenador;
	
	// DISCIPLINAS
	public Disciplina[] getDisciplinasCurso() {
		return disciplinasCurso;
	}
	public void setDisciplinasCurso(Disciplina[] disciplinasCurso) {
		this.disciplinasCurso = disciplinasCurso;
	}
	
	// DESCRICAO
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	// CODIGO
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	
	// CARGA HORARIA
	public long getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(long cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	// EMENTA
	public String getEmenta() {
		return ementa;
	}
	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}
	
	// BIBLIOGRAFIA
	public String getBibliografia() {
		return bibliografia;
	}
	public void setBibliografia(String bibliografia) {
		this.bibliografia = bibliografia;
	}
	
	// COORDENADOR
	public Coordenador getCoordenador() {
		return coordenador;
	}
	public void setCoordenador(Coordenador coordenador) {
		this.coordenador = coordenador;
	}
}
