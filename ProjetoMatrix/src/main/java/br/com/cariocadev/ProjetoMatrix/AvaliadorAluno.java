package br.com.cariocadev.ProjetoMatrix;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AvaliadorAluno {

	public BigDecimal getMaiorNota(BigDecimal[] notas) {
		
		if(notas != null)
		{
			int posicaoMaiorNota = 0;
			for(int x=1; x<notas.length;x++)
			{
				if(notas[x].compareTo(notas[posicaoMaiorNota]) == 1)
					posicaoMaiorNota = x;
			}
			
			return notas[posicaoMaiorNota];
		}
		
		throw new IllegalArgumentException();
		
	}

	public BigDecimal getMedia(BigDecimal nota1, BigDecimal nota2, BigDecimal nota3) {
		
		if(validar(nota1) && validar(nota2) && validar(nota3))
		{
			BigDecimal media = new BigDecimal("0");
			media = (nota3.add(nota2.add(nota1))).divide(BigDecimal.valueOf(3.0), 2, RoundingMode.HALF_UP);
			
			return media;
		}
		
		throw new IllegalArgumentException();
	}

	public String getStatus(BigDecimal nota1, BigDecimal nota2, BigDecimal nota3) {
		
		BigDecimal media = getMedia(nota1, nota2, nota3);
		
		if(media != null)
		{
			if(media.compareTo(BigDecimal.valueOf(6.0)) >= 0)
				return "APROVADO";
			else if(media.compareTo(BigDecimal.valueOf(4.0)) >= 0)
				return "PROVA_FINAL";
			else
				return "REPROVADO";
		}
		
		throw new IllegalArgumentException();
	}
	
	public Boolean validar(BigDecimal nota)
	{
		return (nota != null && nota.compareTo(BigDecimal.valueOf(0)) >= 0 &&
				nota.compareTo(BigDecimal.valueOf(10)) <= 0);
		
	}
}
