package br.com.projetomatrix.academico.curso;

public class Horario {

	private String codigo;
	private String diaSemana;
	private String horaInicio;
	private String horaFim;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDiaSemana() {
		return diaSemana;
	}
	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getHoraFim() {
		return horaFim;
	}
	public void setHoraFim(String horaFim) {
		this.horaFim = horaFim;
	}
}
