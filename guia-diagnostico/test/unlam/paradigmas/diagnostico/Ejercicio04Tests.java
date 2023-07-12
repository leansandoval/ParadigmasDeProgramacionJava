package unlam.paradigmas.diagnostico;

import org.junit.Test;
import org.junit.Assert;

public class Ejercicio04Tests {

	@Test
	public void matrizNoCuadrada() {

		// Arrange
		int[][] matrizEntrada = { { 1, 2, 3, 4 }, { 5, -6, -6, 20 }, { 1, 1, 10, 10 } };
		int[] vectorEsperado = { 4, -6, 10 };

		// Act
		int[] vectorObtenido = Ejercicio04.resolver(matrizEntrada);

		// Assert
		Assert.assertArrayEquals(vectorEsperado, vectorObtenido);
	}
}
