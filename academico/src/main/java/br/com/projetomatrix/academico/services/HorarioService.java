package br.com.projetomatrix.academico.services;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import br.com.projetomatrix.academico.Horario;

public class HorarioService {

	Map<String, Horario> hashHorarios = new HashMap<>();
	
	public Horario cadastrar(Horario horario)
	{
		if(horario == null || hashHorarios.containsKey(horario.getCodigo()))
			throw new IllegalArgumentException("Avaliacao invalida");
		
		horario.setCodigo(gerarCodigo(horario));
		
		hashHorarios.put(horario.getCodigo(), horario);
		
		return horario;
	}
	
	public Horario recuperar(String codigo)
	{
		if(codigo.equals(null) || codigo.toString().isEmpty())
			throw new IllegalArgumentException("codigo invalido.");
		
		return hashHorarios.get(codigo);
	}
	
	public Horario atualizar(Horario horarioAtualizado)
	{
		if(horarioAtualizado == null || !hashHorarios.containsKey(horarioAtualizado.getCodigo()))
			throw new IllegalArgumentException("Dado invalido.");
		
		hashHorarios.put(horarioAtualizado.getCodigo(), horarioAtualizado);
		
		return horarioAtualizado;
		
	}
	
	public void remover(Horario horario)
	{
		if(horario == null || !hashHorarios.containsKey(horario.getCodigo()))
			throw new IllegalArgumentException("Avaliacao não encontrada");
		
		hashHorarios.remove(horario.getCodigo());
	}
	
	public String gerarCodigo(Horario horario)
	{
		StringBuffer codigo = new StringBuffer();
		
		codigo
			.append("H")
			.append(LocalDateTime.now().getDayOfWeek().getValue())
			.append(LocalDateTime.now().getHour())
			.append(hashHorarios.size()+1);
		
		return codigo.toString();
	}
}
