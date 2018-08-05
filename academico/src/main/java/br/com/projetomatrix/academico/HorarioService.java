package br.com.projetomatrix.academico;

import java.util.HashMap;
import java.util.Map;

import br.com.projetomatrix.academico.curso.Horario;

public class HorarioService {

	private char sequencial = 64;
	
	Map<String, Horario> hashHorarios = new HashMap<>();
	
	public Horario cadastrarHorario(Horario horario)
	{
		if(horario != null && hashHorarios.containsKey(horario.getCodigo()) == false)
		{
			gerarCodigoHorario(horario);
			
			hashHorarios.put(horario.getCodigo(), horario);
		}
		
		return horario;
	}
	
	public void removerHorario(String codigoHorario)
	{
		if(codigoHorario == null || codigoHorario.length() == 0)
			throw new IllegalArgumentException();
		
		hashHorarios.remove(codigoHorario);
	}
	
	public Horario atualizarHorario(Horario horarioAtualizado)
	{
		if(horarioAtualizado == null || horarioAtualizado.getCodigo() == null ||
			horarioAtualizado.getCodigo().length() == 0)
			throw new IllegalArgumentException();
		
		removerHorario(horarioAtualizado.getCodigo());
		
		cadastrarHorario(horarioAtualizado);
		
		return horarioAtualizado;
	}
	
	public Horario recuperarHorario(String codigo)
	{
		if(codigo == null || codigo.length() == 0)
			throw new IllegalArgumentException();
		
		return hashHorarios.get(codigo);
	}
	
	public void gerarCodigoHorario(Horario horario)
	{
		String dia = horario.getDiaSemana();
		String horaInicio = horario.getHoraInicio();
		String horaFim = horario.getHoraFim();
		
		sequencial = ++sequencial <= 90 ? sequencial : 65;
		
		String codigo = dia + horaInicio + horaFim + sequencial;
		
		horario.setCodigo(codigo);
	}
}
