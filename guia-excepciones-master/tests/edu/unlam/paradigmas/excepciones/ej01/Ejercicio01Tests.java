package edu.unlam.paradigmas.excepciones.ej01;

import org.junit.Assert;
import org.junit.Test;

public class Ejercicio01Tests {

	public final static double TOLERANCIA = 0.000000001;

	/*
	 * El atributo expected de la anotación @Test indica que se espera una excepción
	 * ArithmeticException cuando se llama al método dividir con un divisor igual a
	 * cero. Si el método dividir lanza una excepción ArithmeticException, el método
	 * de prueba pasará. Si el método dividir no lanza una excepción
	 * ArithmeticException o si lanza una excepción de otro tipo, el método de
	 * prueba fallará.
	 */

	@Test(expected = ArithmeticException.class)
	public void divisorCeroConExpected() {
		Ejercicio01.division(2, 0);
		Assert.fail("No debería llegar a este punto");
	}
	
	@Test
	public void divisorCeroConTryCatch() {
		try {
			Ejercicio01.division(125, 0);
			Assert.fail("No debería llegar a este punto");
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void divisorDistintoDeCero() {
		double resultadoObtenido = Ejercicio01.division(9, 2);
		double resultadoEsperado = 4.5;
		Assert.assertEquals(resultadoObtenido, resultadoEsperado, TOLERANCIA);
	}

}
