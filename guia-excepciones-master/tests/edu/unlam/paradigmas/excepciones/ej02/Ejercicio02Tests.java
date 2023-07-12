package edu.unlam.paradigmas.excepciones.ej02;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class Ejercicio02Tests {
	
	public final static double TOLERANCIA = 0.000000001;

	@Test
	public void numeroPositivo() throws RaizCuadradaException {
		double resultadoObtenido = Ejercicio02.raizCuadrada(2);
		double resultadoEsperado = 1.4142135623730951;
		assertEquals(resultadoObtenido, resultadoEsperado, TOLERANCIA);
	}
	
	@Test(expected = RaizCuadradaException.class)
	public void numeroNegativo() throws RaizCuadradaException {
		Ejercicio02.raizCuadrada(-5);
		Assert.fail("No debería llegar a este punto");
	}

}
