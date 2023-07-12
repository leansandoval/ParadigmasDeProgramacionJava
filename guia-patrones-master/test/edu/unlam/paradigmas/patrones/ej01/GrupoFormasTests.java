package edu.unlam.paradigmas.patrones.ej01;

import org.junit.Assert;
import org.junit.Test;

public class GrupoFormasTests {
	
	public final static double PODER_CUBRITIVO_DE_POMO = 100;
	
	public static int obtenerCantidadDePomos(GrupoFormas grupoForma) {
		return (int) Math.ceil(grupoForma.getArea() / PODER_CUBRITIVO_DE_POMO);
	}

	@Test
	public void cantidadDePomos1() {

		GrupoFormas grupoColor = new GrupoFormas();
		grupoColor.agregarFormaGeometrica(new Rectangulo(5, 10));
		grupoColor.agregarFormaGeometrica(new Circulo(7));
		
		int resultadoObtenido = obtenerCantidadDePomos(grupoColor);
		int resultadoEsperado = 3;
		
		Assert.assertEquals(resultadoObtenido, resultadoEsperado);
	}
	
	@Test
	public void cantidadDePomos2() {

		GrupoFormas grupoColor = new GrupoFormas();
		grupoColor.agregarFormaGeometrica(new Rectangulo(8, 3));
		grupoColor.agregarFormaGeometrica(new Circulo(4));
		
		int resultadoObtenido = obtenerCantidadDePomos(grupoColor);
		int resultadoEsperado = 1;
		
		Assert.assertEquals(resultadoObtenido, resultadoEsperado);
	}

}
