package br.com.projetomatrix.academico;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import br.com.projetomatrix.academico.curso.*;

public class TurmaService {
	
	private Long sequencial = new Long(0);

	Map<String, Turma> hashTurmas = new HashMap<>();
	
	public Turma cadastrarTurma(Turma turma)
	{
		if(turma != null && hashTurmas.containsKey(turma.getCodigo()) == false)	
		{
			gerarCodigoTurma(turma);
			
			hashTurmas.put(turma.getCodigo(), turma);
		}
		
		return turma;
	}
	
	public void removerTurma(String codigoTurma)
	{
		if(codigoTurma == null || codigoTurma.length() == 0)
			throw new IllegalArgumentException();
		
		hashTurmas.remove(codigoTurma);
	}
	
	public Turma atualizarTurma(Turma turmaAtualizada)
	{
		if(turmaAtualizada == null || turmaAtualizada.getCodigo() == null ||
			turmaAtualizada.getCodigo().length() == 0)
			throw new IllegalArgumentException();
		
		removerTurma(turmaAtualizada.getCodigo());
		
		cadastrarTurma(turmaAtualizada);
		
		return turmaAtualizada;
	}
	
	public Turma recuperarTurma(String codigo)
	{
		if(codigo == null || codigo.length() == 0)
			throw new IllegalArgumentException();
		
		return hashTurmas.get(codigo);
	}
	
	public void gerarCodigoTurma(Turma turma)
	{
		String dia = Integer.toString(LocalDateTime.now().getDayOfWeek().getValue());
		
		sequencial.sum(sequencial, 1);
		
		String codigo = "T" + dia + sequencial.intValue();
		
		turma.setCodigo(codigo);
	}
}
