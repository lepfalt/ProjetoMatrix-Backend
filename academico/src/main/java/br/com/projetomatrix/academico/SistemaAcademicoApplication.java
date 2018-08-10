package br.com.projetomatrix.academico;

import java.math.BigDecimal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.projetomatrix.academico.Avaliacao.Modo;
import br.com.projetomatrix.academico.services.SistemaAcademicoService;

@SpringBootApplication
public class SistemaAcademicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaAcademicoApplication.class, args);
		
		carregarDadosIniciais();
	}
	
	public static void carregarDadosIniciais()
	{
		Curso ciencia = new Curso();
		Aluno eu = new Aluno();
		eu.setNome("Letícia Pfaltzgraff");
		eu.setCurso(ciencia);
		eu.setEndereco("Rua bla bla bla");
		eu.setTelefone("2693-0512");
		
		SistemaAcademicoService sas = new SistemaAcademicoService();
		
		Disciplina disciplina = new Disciplina();
		disciplina.setCurso(ciencia);
		sas.cadastrar(disciplina);
		Turma turmaAlgoritmos = new Turma();
		turmaAlgoritmos.setAnoLetivo(2018);
		turmaAlgoritmos.setDisciplina(disciplina);
		sas.cadastrar(turmaAlgoritmos);
		//turmaAlgoritmos.setDataAbertura(Date.parse("2018/12/12"));
		//turmaAlgoritmos.setDataEncerramento(Date.parse("18/13/13"));
		
		System.out.println(turmaAlgoritmos.getCodigo());
		
		
		
		sas.cadastrar(eu);
		
		Professor hugo = new Professor();
		hugo.setNome("Hugo Bex");
		hugo.setTitulo(Titulo.DOUTORADO);
		hugo.setEndereco("slals");
		sas.cadastrar(hugo);
		sas.cadastrarProfessorEmTurma(hugo, turmaAlgoritmos);
		//turmaAlgoritmos.setProfessor(hugo);
		
		System.out.println(hugo.getMatricula());
		for(Turma turmaDaVez : sas.buscarTurmasDoProfessor(hugo))
		{
			System.out.println(turmaDaVez.getCodigo() + ", ");
		}
		
		sas.matricularAlunoEmTurma(eu, turmaAlgoritmos);
		
		Avaliacao av1 = new Avaliacao();
		av1.setAluno(eu);
		av1.setTurma(turmaAlgoritmos);
		av1.setDescricao("Av1 de Algortimos");
		av1.setModo(Modo.PRESENCIAL);
		av1.setNota(BigDecimal.valueOf(9.2));
		
		Avaliacao av2 = new Avaliacao();
		av2.setAluno(eu);
		av2.setTurma(turmaAlgoritmos);
		av2.setDescricao("Av2 de Algortimos");
		av2.setModo(Modo.PRESENCIAL);
		av2.setNota(BigDecimal.valueOf(4.6));
		
		Avaliacao av3 = new Avaliacao();
		av3.setAluno(eu);
		av3.setTurma(turmaAlgoritmos);
		av3.setDescricao("Av3 de Algortimos");
		av3.setModo(Modo.PRESENCIAL);
		av3.setNota(BigDecimal.valueOf(0.0));
		
		
		sas.cadastrar(av1);
		sas.cadastrar(av2);
		sas.cadastrar(av3);
		
		System.out.println(av1.getCodigo());
		System.out.println(av2.getCodigo());
		System.out.println(av3.getCodigo());
		
		System.out.println(sas.calcularMediaDoAluno(eu, turmaAlgoritmos));
		System.out.println(sas.buscarStatusAcademicoDoAluno(eu, turmaAlgoritmos));
		
		for(Turma turmaDaVez : sas.buscarTurmasDoAluno(eu))
		{
			System.out.println(turmaDaVez.getCodigo() + ", ");
		}
		
		Boletim boletim = sas.gerarBoletimDoAluno(eu, turmaAlgoritmos);
		System.out.println(boletim.getAluno().getNome());
		System.out.println(boletim.getTurma().getCodigo());
		int i=1;
		for(Avaliacao avaliacaoDaVez : boletim.getAvaliacoes())
		{
			System.out.println("Av" + i + " = " + avaliacaoDaVez.getNota());
			i++;
		}
		
		Historico historico = sas.gerarHistoricoDoAluno(eu);
		
		System.out.println(historico.getAluno().getNome());
		for(Boletim boletimDaVez : historico.getBoletins())
		{
			i=1;
			System.out.println(boletimDaVez.getTurma().getCodigo());
			for(Avaliacao avaliacaoDaVez : boletimDaVez.getAvaliacoes())
			{
				System.out.println("Av" + i + " = " + avaliacaoDaVez.getNota());
				i++;
			}
		}
		
	}
}