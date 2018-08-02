package br.com.cariocadev.ProjetoMatrix;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculadoraSalario {

	public BigDecimal getSalarioLiquido(BigDecimal salarioBruto, BigDecimal percentualImpostoINSS) {
		
		if(validar(salarioBruto))
		{
			percentualImpostoINSS = percentualImpostoINSS.divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
			
			return salarioBruto.subtract(salarioBruto.multiply(percentualImpostoINSS));
		}
		
		throw new IllegalArgumentException();
	}

	public BigDecimal getValorINSS(BigDecimal salarioBruto) {
		
		if(validar(salarioBruto))
		{
			if(salarioBruto.compareTo(BigDecimal.valueOf(1693.72)) <= 0)
			{
				return salarioBruto.multiply(BigDecimal.valueOf(0.08)).setScale(2, RoundingMode.HALF_UP);
			}
			else if(salarioBruto.compareTo(BigDecimal.valueOf(1693.72)) > 0 &&
					salarioBruto.compareTo(BigDecimal.valueOf(2822.90)) <= 0)
			{
				return salarioBruto.multiply(BigDecimal.valueOf(0.09)).setScale(2, RoundingMode.HALF_UP);
			}
			else if(salarioBruto.compareTo(BigDecimal.valueOf(2822.90)) > 0)
			{
				return salarioBruto.multiply(BigDecimal.valueOf(0.11)).setScale(2, RoundingMode.HALF_UP);
			}
		}
		
			throw new IllegalArgumentException();
	}

	public BigDecimal getValorPlanoDeSaude(Integer idade) {
		// TODO Auto-generated method stub
		
		if(idade >= 0 && idade <= 9)
			return BigDecimal.valueOf(75.00).setScale(2, RoundingMode.HALF_UP);
		if(idade >= 10 && idade <= 19)
			return BigDecimal.valueOf(112.50).setScale(2, RoundingMode.HALF_UP);
		if(idade >= 20 && idade <= 29)
			return BigDecimal.valueOf(168.75).setScale(2, RoundingMode.HALF_UP);
		if(idade >= 30 && idade <= 39)
			return BigDecimal.valueOf(253.13).setScale(2, RoundingMode.HALF_UP);
		if(idade >= 40 && idade <= 49)
			return BigDecimal.valueOf(379.69).setScale(2, RoundingMode.HALF_UP);
		if(idade >= 50 && idade <= 59)
			return BigDecimal.valueOf(569.54).setScale(2, RoundingMode.HALF_UP);
		if(idade >= 60)
			return BigDecimal.valueOf(854.30).setScale(2, RoundingMode.HALF_UP);
		
		throw new IllegalArgumentException();
	}
	
	public Boolean validar(BigDecimal valor)
	{
		return (valor != null && valor.compareTo(BigDecimal.valueOf(0)) >= 0);
	}
}