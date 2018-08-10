package br.com.projetomatrix.academico;

import java.time.LocalTime;

public class Horario {

	private String codigo;
	private Integer diaDaSemana;
	private LocalTime horaInicio;
	private LocalTime horaFim;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Integer getDiaDaSemana() {
		return diaDaSemana;
	}
	public void setDiaDaSemana(Integer diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}
	public LocalTime getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}
	public LocalTime getHoraFim() {
		return horaFim;
	}
	public void setHoraFim(LocalTime horaFim) {
		this.horaFim = horaFim;
	}
}