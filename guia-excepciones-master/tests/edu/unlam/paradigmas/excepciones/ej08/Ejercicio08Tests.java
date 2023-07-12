package edu.unlam.paradigmas.excepciones.ej08;

import org.junit.Assert;
import org.junit.Test;

public class Ejercicio08Tests {

	/*
	 * La palabra reservada assert en Java se utiliza para verificar ciertas
	 * condiciones durante la ejecución del código. Su sintaxis es la siguiente:
	 * assert condition; Donde condition es una expresión booleana que se evalúa
	 * como verdadera o falsa. Si la condición se evalúa como verdadera, entonces el
	 * programa continúa su ejecución normal. Sin embargo, si la condición se evalúa
	 * como falsa, entonces se lanza una excepción de tipo AssertionError, lo que
	 * detiene la ejecución del programa.
	 */

	@Test(expected = AssertionError.class)
	public void divisorDistintoDeCero() {
		double dividendo = 10;
		double divisor = 0;
		assert divisor != 0 : "El divisor no puede ser cero";
		Ejercicio08.division(dividendo, divisor);
		Assert.fail("No deberia llegar a este punto");
	}

	@Test
	public void resultadoCero() {
		double dividendo = 0;
		double divisor = 2;
		double resultado = Ejercicio08.division(dividendo, divisor);
		assert resultado == 0 : "La division no da como resultado cero";
	}

}
