package br.com.cariocadev.ProjetoMatrix;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AvaliadorAluno {

	public BigDecimal getMaiorNota(BigDecimal[] notas) {
		if(notas != null)
		{
			int ma = 0;
			for(int x=1; x<notas.length;x++)
			{
				if(notas[x].compareTo(notas[ma]) == 1)
					ma = x;
			}
			return notas[ma];
		}
		
		throw new IllegalArgumentException();
		
	}

	public BigDecimal getMedia(BigDecimal nota1, BigDecimal nota2, BigDecimal nota3) {
		
		if(validar(nota1) && validar(nota2) && validar(nota3))
		{
			BigDecimal media = new BigDecimal("0.0");
			nota2 = nota1.add(nota2);
			nota3 = nota2.add(nota3);
			media = nota3.divide(new BigDecimal("3.0"), 2, RoundingMode.HALF_EVEN);
			return media;
		}
		
		return null;
	}

	public String getStatus(BigDecimal nota1, BigDecimal nota2, BigDecimal nota3) {
		
		BigDecimal media = getMedia(nota1, nota2, nota3);
		if(media != null)
		{
			if(media.compareTo(new BigDecimal("6.0")) == 1 ||media.compareTo(new BigDecimal("6.0")) == 0)
				return "APROVADO";
			else if(media.compareTo(new BigDecimal("4.0")) == 1 || media.compareTo(new BigDecimal("4.0")) == 0)
				return "PROVA_FINAL";
			else
				return "REPROVADO";
		}
		
		throw new IllegalArgumentException();
	}
	
	public Boolean validar(BigDecimal nota)
	{
		if(nota == null || nota.compareTo(new BigDecimal("0.0")) == -1 || nota.compareTo(new BigDecimal("10.0")) == 1)
		{
			throw new IllegalArgumentException();
		}
		
		return true;
		
	}
}
