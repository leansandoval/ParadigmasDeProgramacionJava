package edu.unlam.paradigmas.basicas.ej01;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ComparableTests {

	@Test
	public void rangosIgualesConMismaLlave() {
		Rango rango = Rango.cerrado(1, 2);
		Assert.assertTrue(rango.compareTo(Rango.cerrado(1, 2)) == 0);
	}

	@Test
	public void rangosIgulesConDistintaLlave() {
		Rango rango = Rango.abiertoDerecha(1, 2);
		Assert.assertTrue(rango.compareTo(Rango.abiertoIzquierda(1, 2)) != 0);
	}

	@Test
	public void primerRangoMenorQueElSegundo() {
		Rango rango = Rango.cerrado(1, 2);
		Assert.assertTrue(rango.compareTo(Rango.cerrado(3, 4)) < 0);
	}

	@Test
	public void primerRangoMayorQueElSegundo() {
		Rango rango = Rango.cerrado(1, 2);
		Assert.assertTrue(rango.compareTo(Rango.cerrado(-1, 1)) > 0);
	}

	@Test
	public void ordenamientoDeRangos() {

		Rango[] rangosDesordenados = { Rango.abierto(0, 2), Rango.cerrado(0, 2), Rango.abierto(4, 22),
				Rango.abiertoIzquierda(-1, 5), Rango.abiertoIzquierda(0, 2), Rango.abiertoDerecha(0, 2) };

		Rango[] rangosOrdenados = { Rango.abiertoIzquierda(-1, 5), Rango.cerrado(0, 2), Rango.abiertoDerecha(0, 2),
				Rango.abiertoIzquierda(0, 2), Rango.abierto(0, 2), Rango.abierto(4, 22) };

		Arrays.sort(rangosDesordenados);

		Assert.assertArrayEquals(rangosDesordenados, rangosOrdenados);

	}

}
