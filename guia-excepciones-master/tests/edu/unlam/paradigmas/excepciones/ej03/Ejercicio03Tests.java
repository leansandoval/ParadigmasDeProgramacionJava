package edu.unlam.paradigmas.excepciones.ej03;

import org.junit.Assert;
import org.junit.Test;

public class Ejercicio03Tests {

	public final static double TOLERANCIA = 0.000000001;

	@Test(expected = DivisionPorCeroException.class)
	public void divisorCeroConExpected() {
		Ejercicio03.division(125, 0);
		Assert.fail("No debería llegar a este punto");
	}

	@Test
	public void divisorCeroConTryCatch() {
		try {
			Ejercicio03.division(125, 0);
			Assert.fail("No debería llegar a este punto");
		} catch (DivisionPorCeroException e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
	}

	@Test
	public void divisorDistintoDeCero() {
		double resultadoObtenido = Ejercicio03.division(9, 2);
		double resultadoEsperado = 4.5;
		Assert.assertEquals(resultadoObtenido, resultadoEsperado, TOLERANCIA);
	}

}
