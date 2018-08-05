package br.com.projetomatrix.academico;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import br.com.projetomatrix.academico.curso.Avaliacao;
import br.com.projetomatrix.academico.curso.Modo;

public class AvaliacaoService {

	private Long sequencial = new Long(0);
	
	Map<String, Avaliacao> hashAvaliacoes = new HashMap<>();
	
	public Avaliacao cadastrarAvaliacao(Avaliacao avaliacao)
	{
		if(avaliacao != null && hashAvaliacoes.containsKey(avaliacao.getCodigo()) == false)
		{
			gerarCodigoAvaliacao(avaliacao);
			
			hashAvaliacoes.put(avaliacao.getCodigo(), avaliacao);
		}
			
		return avaliacao;
	}
	
	public void removerAvaliacao(String codigoAvaliacao)
	{
		if(codigoAvaliacao == null || codigoAvaliacao.length() == 0)
			throw new IllegalArgumentException();
		
		hashAvaliacoes.remove(codigoAvaliacao);
	}
	
	public Avaliacao atualizarAvaliacao(Avaliacao avaliacaoAtualizada)
	{
		if(avaliacaoAtualizada == null || avaliacaoAtualizada.getCodigo() == null ||
			avaliacaoAtualizada.getCodigo().length() == 0)
			throw new IllegalArgumentException();
		
		removerAvaliacao(avaliacaoAtualizada.getCodigo());
		
		cadastrarAvaliacao(avaliacaoAtualizada);
		
		return avaliacaoAtualizada;
	}
	
	public Avaliacao recuperarAvaliacao(String codigo)
	{
		if(codigo == null || codigo.length() == 0)
			throw new IllegalArgumentException();
		
		return hashAvaliacoes.get(codigo);
	}
	
	public void gerarCodigoAvaliacao(Avaliacao avaliacao)
	{
		String dia = Integer.toString(LocalDateTime.now().getDayOfWeek().getValue());
		
		String modo = avaliacao.getModo() == Modo.PRESENCIAL ? "P" : "O";
		
		sequencial.sum(sequencial, 1);
		
		String codigo = "A" + modo + dia + sequencial.intValue();
		
		avaliacao.setCodigo(codigo);
	}
}
