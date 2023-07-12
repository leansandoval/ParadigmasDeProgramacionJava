package unlam.paradigmas.objetos.ej01;

import org.junit.Assert;
import org.junit.Test;

public class NotaTests {

	@Test
	public void notaAprobada() {
		Nota notaAprobada = new Nota(10);
		Assert.assertTrue(notaAprobada.aprobado());
	}

	@Test
	public void notaDesaprobada() {
		Nota notaDesaprobada = new Nota(3);
		Assert.assertTrue(notaDesaprobada.desaprobado());
	}

	@Test
	public void notaUsandoRecuperar() {
		Nota nota = new Nota(3);
		nota.recuperar(8);
		int notaObtenida = nota.obtenerValor();
		int notaEsperada = 8;
		Assert.assertEquals(notaEsperada, notaObtenida);
	}
	
	@Test
	public void notaUsandoObtenerNota() {
		Nota nota = new Nota(7);
		int notaObtenida = nota.obtenerValor();
		int notaEsperada = 7;
		Assert.assertEquals(notaEsperada, notaObtenida);
	}
}
