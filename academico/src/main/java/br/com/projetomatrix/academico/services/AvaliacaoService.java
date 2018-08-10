package br.com.projetomatrix.academico.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.ObjectUtils;

import br.com.projetomatrix.academico.Aluno;
import br.com.projetomatrix.academico.Avaliacao;
import br.com.projetomatrix.academico.Turma;

public class AvaliacaoService {

	Map<String, Avaliacao> hashAvaliacoes = new HashMap<>();
	
	public Avaliacao cadastrar(Avaliacao avaliacao)
	{
		if(avaliacao == null || hashAvaliacoes.containsKey(avaliacao.getCodigo()))
			throw new IllegalArgumentException("Avaliacao invalida");
		
		avaliacao.setCodigo(gerarCodigo(avaliacao));
		
		hashAvaliacoes.put(avaliacao.getCodigo(), avaliacao);
		
		return avaliacao;
	}
	
	public Avaliacao recuperar(String codigo)
	{
		if(codigo.equals(null) || codigo.toString().isEmpty())
			throw new IllegalArgumentException("codigo invalido.");
		
		return hashAvaliacoes.get(codigo);
	}
	
	public Avaliacao atualizar(Avaliacao avaliacaoAtualizada)
	{
		if(avaliacaoAtualizada == null || !hashAvaliacoes.containsKey(avaliacaoAtualizada.getCodigo()))
			throw new IllegalArgumentException("Dado invalido.");
		
		hashAvaliacoes.put(avaliacaoAtualizada.getCodigo(), avaliacaoAtualizada);
		
		return avaliacaoAtualizada;
		
	}
	
	public void remover(Avaliacao avaliacao)
	{
		if(avaliacao == null || !hashAvaliacoes.containsKey(avaliacao.getCodigo()))
			throw new IllegalArgumentException("Avaliacao não encontrada");
		
		hashAvaliacoes.remove(avaliacao.getCodigo());
	}
	
	public String gerarCodigo(Avaliacao avaliacao)
	{
		StringBuffer codigo = new StringBuffer();
		
		codigo
			.append("A")
			.append(LocalDateTime.now().getDayOfWeek().getValue())
			.append(hashAvaliacoes.size()+1);
		
		return codigo.toString();
	}
	
	public ArrayList<Avaliacao> buscarAvaliacoesAlunoNaTurma(Aluno aluno, Turma turma)
	{
		if(ObjectUtils.isEmpty(aluno) || ObjectUtils.isEmpty(turma))
			throw new IllegalArgumentException("Argumento passado não pode ser nulo.");
		
		ArrayList<Avaliacao> avaliacoesAluno = new ArrayList<>();
		
		for(Avaliacao avaliacaoDaVez : hashAvaliacoes.values())
		{
			if(avaliacaoDaVez.getAluno().getMatricula().equals(aluno.getMatricula()) &&
					avaliacaoDaVez.getTurma().getCodigo().equals(turma.getCodigo()))
				avaliacoesAluno.add(avaliacaoDaVez);
		}
		
		return avaliacoesAluno;
	}
	
	public ArrayList<Avaliacao> buscarTodasAvaliacoesAluno(Aluno aluno)
	{
		if(ObjectUtils.isEmpty(aluno))
			throw new IllegalArgumentException("Argumento passado não pode ser nulo.");
		
		ArrayList<Avaliacao> avaliacoesAluno = new ArrayList<>();
		
		for(Avaliacao avaliacaoDaVez : hashAvaliacoes.values())
		{
			if(avaliacaoDaVez.getAluno().getMatricula().equals(aluno.getMatricula()))
				avaliacoesAluno.add(avaliacaoDaVez);
		}
		
		return avaliacoesAluno;
	}
}
