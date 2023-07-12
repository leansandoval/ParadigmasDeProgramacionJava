package unlam.paradigmas.objetos.ej06;

import org.junit.Test;
import org.junit.Assert;

public class CerraduraTests {

	@Test
	public void cerraduraAbierta() {
		Cerradura cerradura = new Cerradura(41548235, 3);
		cerradura.abrir(41548235);
		boolean resultadoObtenido = cerradura.estaAbierta();
		Assert.assertTrue(resultadoObtenido);
	}

	@Test
	public void cerraduraCerrada() {
		Cerradura cerradura = new Cerradura(41548235, 3);
		cerradura.abrir(41548235);
		cerradura.cerrar();
		boolean resultadoObtenido = cerradura.estaCerrada();
		Assert.assertTrue(resultadoObtenido);
	}

	@Test
	public void cerraduraBloqueada() {
		Cerradura cerradura = new Cerradura(41548235, 3);
		for (int i = 0; i < 3; i++)
			cerradura.abrir(41000000);
		boolean resultadoObtenido = cerradura.fueBloqueada();
		Assert.assertTrue(resultadoObtenido);
	}

	@Test
	public void probandoAperturasExitosas() {
		Cerradura cerradura = new Cerradura(41548235, 3);
		for (int i = 0; i < 3; i++) {
			cerradura.abrir(41548235);
			cerradura.cerrar();
		}
		int resultadoObtenido = cerradura.contarAperturasExitosas();
		int resultadoEsperado = 3;
		Assert.assertEquals(resultadoObtenido, resultadoEsperado);
	}

	@Test
	public void probandoAperturasFallidas() {
		Cerradura cerradura = new Cerradura(41548235, 3);
		
		for (int i = 0; i < 2; i++)
			cerradura.abrir(41000000);
		
		cerradura.abrir(41548235);
		cerradura.cerrar();
		
		for (int i = 0; i < 2; i++)
			cerradura.abrir(41000000);
		
		int resultadoObtenido = cerradura.contarAperturasFallidas();
		int resultadoEsperado = 4;
		Assert.assertEquals(resultadoObtenido, resultadoEsperado);
	}
}
