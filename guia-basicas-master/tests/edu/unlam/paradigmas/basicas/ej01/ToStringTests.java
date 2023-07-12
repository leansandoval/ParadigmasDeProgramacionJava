package edu.unlam.paradigmas.basicas.ej01;

import org.junit.Assert;
import org.junit.Test;

public class ToStringTests {

	@Test
	public void formatoCerrado() {
		Rango rangoCerrado = Rango.cerrado(1, 2);
		Assert.assertEquals("[1.0, 2.0]", rangoCerrado.toString());
	}

	@Test
	public void formatoAbierto() {
		Rango rangoCerrado = Rango.abierto(1, 2);
		Assert.assertEquals("(1.0, 2.0)", rangoCerrado.toString());
	}

	@Test
	public void formatoAbiertoIzquierda() {
		Rango rangoCerrado = Rango.abiertoIzquierda(1, 2);
		Assert.assertEquals("(1.0, 2.0]", rangoCerrado.toString());
	}

	@Test
	public void formatoAbiertoDerecha() {
		Rango rangoCerrado = Rango.abiertoDerecha(1, 2);
		Assert.assertEquals("[1.0, 2.0)", rangoCerrado.toString());
	}
}
