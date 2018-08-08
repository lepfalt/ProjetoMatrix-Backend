package br.com.projetomatrix.academico;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.projetomatrix.academico.curso.*;

public class Testes {

	public static void main(String[] args) {
SistemaAcademicoService sas = new SistemaAcademicoService();
		
		Coordenador carlos = new Coordenador();
	
		Curso cienciaDaComputacao = new Curso("Ciencia da Computacao", 280, "blublublu", "Paulo winterle", carlos);
		cienciaDaComputacao.setDescricao("Ciencia da Computacao");
		sas.cadastrarCurso(cienciaDaComputacao);
		
		Disciplina algebra = new Disciplina("Algebraa", cienciaDaComputacao);
		List<Disciplina> disicplinasCiencia = new ArrayList<>();
		disicplinasCiencia.add(algebra);
		
		Professor priscilla = new Professor("Priscilla Abreu", "Rua sla", "2222-2222", Titulo.GRADUACAO);
		List<Professor> professores = new ArrayList<Professor>();
		professores.add(priscilla);
		sas.cadastrarProfessor(priscilla);
		
		List<Disciplina> preRequisitos = new ArrayList<>();
		preRequisitos.add(algebra);
		sas.cadastrarDisciplina(algebra);
		
		Disciplina algoritmos = new Disciplina("Algoritmos", cienciaDaComputacao);
		
		sas.cadastrarDisciplina(algoritmos);
		Horario horario = new Horario("Segunda", "17:12", "18:12");
		Turma turmaAlgoritmos = new Turma(algoritmos, priscilla, 2018, 2, "12/12/12", "13/13/13", horario);
		sas.cadastrarTurma(turmaAlgoritmos);
		
		
		Aluno eu = new Aluno("Leticia Pfaltzgraff", "Rua blablabla", "2693-0512", cienciaDaComputacao);
		sas.cadastrarAluno(eu);
		sas.adicionarAlunoNaTurma(eu, turmaAlgoritmos);
		
		
		for(Turma turma : eu.getTurmas())
		{
			System.out.println(turma.getDisciplina().getDescricao());
		}
		//System.out.println(sas.buscarTurmasDoAluno(eu.getMatricula()));
		
		Date data = new Date(0);
		Avaliacao av1 = new Avaliacao(turmaAlgoritmos, eu, data, "AV1", Modo.PRESENCIAL, priscilla, BigDecimal.valueOf(9.8));
		Avaliacao av2 = new Avaliacao(turmaAlgoritmos, eu, data, "AV2", Modo.PRESENCIAL, priscilla, BigDecimal.valueOf(5.6));
		Avaliacao av3 = new Avaliacao(turmaAlgoritmos, eu, data, "AV3", Modo.PRESENCIAL, priscilla, BigDecimal.valueOf(6.9));
		
		sas.cadastrarAvaliacao(av1);
		sas.cadastrarAvaliacao(av2);
		sas.cadastrarAvaliacao(av3); 
		
		/*System.out.println(av1.getNota());
		for(Avaliacao avVez : eu.getAvaliacoes())
		{
			System.out.println(avVez.getNota() + "\n");
		}*/
		
		
		// Media está zerando
		BigDecimal media = new BigDecimal(0);
		media = sas.calcularMediaDoAlunoPorTurma(eu.getMatricula(), turmaAlgoritmos);
		
		System.out.println(media);
		
		System.out.println(sas.buscarBoletimDoAlunoPorDisciplina(eu.getMatricula(), algoritmos));
		
		System.out.println(sas.buscarHistorico(eu.getMatricula()));
		
	}
}
