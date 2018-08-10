package br.com.projetomatrix.academico.services;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import br.com.projetomatrix.academico.Coordenador;

public class CoordenadorService {

	Map<String, Coordenador> hashCoordenadores = new HashMap<>();
	
	public Coordenador cadastrar(Coordenador coordenador)
	{
		if(coordenador == null || hashCoordenadores.containsKey(coordenador.getMatricula()))
			return coordenador;
		
		coordenador.setMatricula(gerarMatricula(coordenador));
		
		hashCoordenadores.put(coordenador.getMatricula(), coordenador);
		
		return coordenador;
	}
	
	public Coordenador recuperar(String matricula)
	{
		if(matricula.equals(null) || matricula.toString().isEmpty())
			throw new IllegalArgumentException("Matricula inválida");
		
		return hashCoordenadores.get(matricula);
	}
	
	public Coordenador atualizar(Coordenador coordenadorAtualizado)
	{
		if(coordenadorAtualizado == null || !hashCoordenadores.containsKey(coordenadorAtualizado.getMatricula()))
			throw new IllegalArgumentException("Professor inválido");
		
		hashCoordenadores.put(coordenadorAtualizado.getMatricula(), coordenadorAtualizado);
		
		return coordenadorAtualizado;
	}
	
	public void remover(Coordenador coordenador)
	{
		if(coordenador == null || !hashCoordenadores.containsKey(coordenador.getMatricula()))
			throw new IllegalArgumentException("Aluno não pode ser removido.");
		
		hashCoordenadores.remove(coordenador.getMatricula());
	}
	
	public String gerarMatricula(Coordenador coordenador)
	{
		StringBuffer matricula = new StringBuffer();
		
		String mes = LocalDateTime.now().getMonthValue() <= 6 ? "1": "2";
		
		matricula
			.append("C")
			.append(LocalDateTime.now().getYear())
			.append(mes)
			.append(hashCoordenadores.size()+1);
		
		return matricula.toString();
	}
}
