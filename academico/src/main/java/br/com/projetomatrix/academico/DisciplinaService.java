package br.com.projetomatrix.academico;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.projetomatrix.academico.curso.Disciplina;

public class DisciplinaService {

	private Long sequencial = new Long(0);
	
	Map<String, Disciplina> hashDisciplinas = new HashMap<>();
	
	public Disciplina cadastrarDisciplina(Disciplina disciplina)
	{
		if(disciplina != null && hashDisciplinas.containsKey(disciplina.getCodigo()) == false)
		{
			gerarCodigoDisciplina(disciplina);
			
			hashDisciplinas.put(disciplina.getCodigo(), disciplina);
		}
		
		return disciplina;
	}
	
	public void removerDisciplina(String codigoDisicplina)
	{
		if(codigoDisicplina == null || codigoDisicplina.length() == 0)
			throw new IllegalArgumentException();
		
		hashDisciplinas.remove(codigoDisicplina);
	}
	
	public Disciplina atualizarDisciplina(Disciplina disciplinaAtualizada)
	{
		if(disciplinaAtualizada == null || disciplinaAtualizada.getCodigo() == null ||
			disciplinaAtualizada.getCodigo().length() == 0)
			throw new IllegalArgumentException();
		
		removerDisciplina(disciplinaAtualizada.getCodigo());
		
		cadastrarDisciplina(disciplinaAtualizada);
		
		return disciplinaAtualizada;
	}
	
	public Disciplina recuperarDisciplina(String codigo)
	{
		if(codigo == null || codigo.length() == 0)
			throw new IllegalArgumentException();
		
		return hashDisciplinas.get(codigo);
	}
	
	public void gerarCodigoDisciplina(Disciplina disciplina)
	{
		if(disciplina != null)
		{
			//String iniciais = new String((disciplina.getDescricao()).substring(0, 2));
			
			/*for(int i=1;i<= disciplina.getDescricao().length(); i++)
			{
				if(disciplina.getDescricao().substring(i-1, 1).equals(" "))
					iniciais += disciplina.getDescricao().substring(i, 1);
			} */
			
			sequencial.sum(sequencial, 1);
			
			String codigo = new String();
					
			codigo = "D" + Integer.toString(sequencial.intValue()); //melhorar
			
			disciplina.setCodigo(codigo);
		}
	}
	
	public void adicionarPreRequisitoNaDisciplina(Disciplina disciplina, Disciplina preRequisito)
	{
		disciplina.getPreRequisitos().add(preRequisito);
	}
	
	public void adicionarProfessorNaDisciplina(Disciplina disciplina, Professor professor)
	{
		disciplina.getProfessores().add(professor);
	}
}
