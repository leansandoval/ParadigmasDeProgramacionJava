package unlam.paradigmas.objetos.ej04;

import org.junit.Test;
import org.junit.Assert;

public class CuboTests {

	@Test
	public void probandoAreaCara() {
		Cubo cubo = new Cubo(5);
		double areaObtenida = cubo.obtenerAreaCara();
		double areaEsperada = 25;
		Assert.assertEquals(areaObtenida, areaEsperada, 0.00000001);
	}

	@Test
	public void probandoVolumen() {
		Cubo cubo = new Cubo(5);
		double volumenObtenido = cubo.obtenerVolumen();
		double volumenEsperado = 125;
		Assert.assertEquals(volumenObtenido, volumenEsperado, 0.00000001);
	}

}
