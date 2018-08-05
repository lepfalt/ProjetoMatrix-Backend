package br.com.projetomatrix.academico;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class CoordenadorService {

	private Long sequencial = new Long(0);
	
	Map<String, Coordenador> hashCoordenadores = new HashMap<>();
	
	public Coordenador cadastrarCoordenador(Coordenador coordenador)
	{
		if(coordenador != null && hashCoordenadores.containsKey(coordenador.getMatricula()) == false)
		{
			gerarMatricula(coordenador);
			
			hashCoordenadores.put(coordenador.getMatricula(), coordenador);
		}
		
		return coordenador;
	}
	
	public void removerCoordenador(String matricula)
	{
		if(matricula == null || matricula.length() == 0)
			throw new IllegalArgumentException();
		
		hashCoordenadores.remove(matricula);
	}
	
	public Coordenador atualizarCoordenador(Coordenador coordenadorAtualizado)
	{
		if(coordenadorAtualizado == null || coordenadorAtualizado.getMatricula() == null ||
				coordenadorAtualizado.getMatricula().length() == 0)
			throw new IllegalArgumentException();
		
		removerCoordenador(coordenadorAtualizado.getMatricula());
		
		cadastrarCoordenador(coordenadorAtualizado);
		
		return coordenadorAtualizado;
	}
	
	public Coordenador recuperarCoordenador(String matricula)
	{
		if(matricula == null || matricula.length() == 0)
			throw new IllegalArgumentException();
		
		return hashCoordenadores.get(matricula);
	}
	
	public void gerarMatricula(Coordenador coordenador)
	{
		// ano . semestre . sequencial
		String ano = Integer.toString(LocalDateTime.now().getYear());
		
		Integer mes = LocalDateTime.now().getMonthValue();
		String semestre = mes <= 6 ? "1" : "2";
		
		sequencial.sum(sequencial, 1);
		
		String matricula = ano + semestre + "C" + sequencial.intValue();
		
		coordenador.setMatricula(matricula);
	}
}
