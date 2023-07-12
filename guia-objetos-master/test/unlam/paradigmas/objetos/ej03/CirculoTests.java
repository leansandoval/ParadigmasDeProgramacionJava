package unlam.paradigmas.objetos.ej03;

import org.junit.Assert;
import org.junit.Test;

public class CirculoTests {

	final double PRECISION = 0.00000001;
	final double RADIO = 4;

	@Test
	public void probandoDiametro() {
		Circulo circulo = new Circulo(RADIO);
		double diametroObtenido = circulo.getDiametro();
		double diametroEsperado = 2 * RADIO;
		Assert.assertEquals(diametroObtenido, diametroEsperado, PRECISION);
	}

	@Test
	public void probandoArea() {
		Circulo circulo = new Circulo(RADIO);
		double areaObtenida = circulo.getArea();
		double areaEsperada = Math.PI * Math.pow(RADIO, 2);
		Assert.assertEquals(areaObtenida, areaEsperada, PRECISION);
	}

	@Test
	public void probandoPerimetro() {
		Circulo circulo = new Circulo(RADIO);
		double perimetroObtenido = circulo.getPerimetro();
		double perimetroEsperado = 2 * RADIO * Math.PI;
		Assert.assertEquals(perimetroObtenido, perimetroEsperado, PRECISION);
	}
}
