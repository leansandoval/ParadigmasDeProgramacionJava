package edu.unlam.paradigmas.basicas.ej01;

import org.junit.Assert;
import org.junit.Test;

public class EqualsTests {

	@Test
	public void mismoObjeto() {
		Rango rango = Rango.cerrado(1, 2);
		Assert.assertTrue(rango.equals(rango));
	}

	@Test
	public void objetoVacio() {
		Rango rango = Rango.cerrado(1, 2);
		Assert.assertFalse(rango.equals(null));
	}

	@Test
	public void rangosCerrados() {
		Rango rangoCerrado1 = Rango.cerrado(1, 2);
		Rango rangoCerrado2 = Rango.cerrado(1, 2);
		Assert.assertTrue(rangoCerrado1.equals(rangoCerrado2));
	}

	@Test
	public void rangosAbiertos() {
		Rango rangoAbierto1 = Rango.abierto(1, 2);
		Rango rangoAbierto2 = Rango.abierto(1, 2);
		Assert.assertTrue(rangoAbierto1.equals(rangoAbierto2));
	}

	@Test
	public void rangosAbiertosIzquierda() {
		Rango rangoAbiertoIzquierda1 = Rango.abiertoIzquierda(1, 2);
		Rango rangoAbiertoIzquierda2 = Rango.abiertoIzquierda(1, 2);
		Assert.assertTrue(rangoAbiertoIzquierda1.equals(rangoAbiertoIzquierda2));
	}

	@Test
	public void rangosAbiertosDerecha() {
		Rango rangoAbiertoDerecha1 = Rango.abiertoIzquierda(1, 2);
		Rango rangoAbiertoDerecha2 = Rango.abiertoIzquierda(1, 2);
		Assert.assertTrue(rangoAbiertoDerecha1.equals(rangoAbiertoDerecha2));
	}

	@Test
	public void rangoQueAbarcaTodoUnVector() {

		Rango[] rangos = { Rango.abierto(0, 2), Rango.cerrado(0, 2), Rango.abierto(4, 22),
				Rango.abiertoIzquierda(-1, 5), Rango.abiertoIzquierda(0, 2), Rango.abiertoDerecha(0, 2) };

		Rango rangoObtenido = Rango.abarcarRangos(rangos);
		Rango rangoEsperado = Rango.cerrado(-1, 22);

		Assert.assertTrue(rangoObtenido.equals(rangoEsperado));
	}

	@Test
	public void rangoDesplazado() {

		Rango rango = Rango.abiertoDerecha(5.5, 7.25);
		Rango rangoObtenido = rango.desplazarRango(-2);
		Rango rangoEsperado = Rango.abiertoDerecha(3.5, 5.25);

		Assert.assertTrue(rangoObtenido.equals(rangoEsperado));
	}

	@Test
	public void rangoInterseccion() {

		Rango rango1 = Rango.cerrado(1, 5);
		Rango rango2 = Rango.abiertoIzquierda(4, 7);
		Rango rangoObtenido = rango1.obtenerRangoInterseccion(rango2);
		Rango rangoEsperado = Rango.abiertoIzquierda(4, 5);
		Assert.assertTrue(rangoObtenido.equals(rangoEsperado));

	}

	@Test
	public void rangoSinInterseccion() {

		Rango rango1 = Rango.cerrado(1, 5);
		Rango rango2 = Rango.abiertoIzquierda(5, 7);
		Rango rangoObtenido = rango1.obtenerRangoInterseccion(rango2);
		Rango rangoEsperado = Rango.abierto(0, 0);
		Assert.assertTrue(rangoObtenido.equals(rangoEsperado));

	}

	@Test
	public void rangoSuma() {

		Rango rango1 = Rango.cerrado(1, 5);
		Rango rango2 = Rango.abiertoIzquierda(4, 7);
		Rango rangoObtenido = rango1.sumarRangos(rango2);
		Rango rangoEsperado = Rango.cerrado(1, 7);
		Assert.assertTrue(rangoObtenido.equals(rangoEsperado));

	}

}
