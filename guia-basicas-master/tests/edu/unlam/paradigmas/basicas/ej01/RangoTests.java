package edu.unlam.paradigmas.basicas.ej01;

import org.junit.Assert;
import org.junit.Test;

public class RangoTests {

	@Test
	public void hayInterseccion() {
		Rango rango1 = Rango.abierto(1, 2);
		Rango rango2 = Rango.abierto(1.5, 3);
		Assert.assertTrue(rango1.intersecta(rango2));
	}

	@Test
	public void noHayInterseccion() {
		Rango rango1 = Rango.abierto(1, 2);
		Rango rango2 = Rango.abierto(2, 3);
		Assert.assertFalse(rango1.intersecta(rango2));
	}

	@Test
	public void numeroAdentroDelRango() {
		Rango rango = Rango.abierto(1, 2);
		Assert.assertTrue(rango.numeroDentroDeRango(1.5));
	}

	@Test
	public void numeroAfueraDelRango() {
		Rango rango = Rango.abierto(1, 2);
		Assert.assertFalse(rango.numeroDentroDeRango(1));
	}

	@Test
	public void rangoAdentroDeOtro() {
		Rango rangoExterior = Rango.abierto(1, 5);
		Rango rangoInterior = Rango.cerrado(4, 4.5);
		Assert.assertTrue(rangoInterior.rangoDentroDeRango(rangoExterior));
	}

	@Test
	public void rangoFueraDeOtro() {
		Rango rangoExterior = Rango.abierto(1, 4.25);
		Rango rangoInterior = Rango.cerrado(4, 4.5);
		Assert.assertFalse(rangoInterior.rangoDentroDeRango(rangoExterior));
	}

}
