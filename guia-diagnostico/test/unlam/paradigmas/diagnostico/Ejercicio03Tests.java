package unlam.paradigmas.diagnostico;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class Ejercicio03Tests {

	@Test
	public void matrizNoCuadrada() {

		// Arrange
		int[][] matrizEntrada = { { 8, 2, -3, 4 }, { 5, -6, -6, 20 }, { 21, 1, -5, 0 } };
		int[][] matrizEsperada = { { 15, 1, -3, 21 }, { 28, -4, 0, 18 }, { 27, 11, -10, 15 } };
		// Act
		int[][] matrizObtenida = Ejercicio03.resolver(matrizEntrada);
		// Assert
		Assert.assertTrue(Arrays.deepEquals(matrizEsperada, matrizObtenida));

	}

	@Test
	public void matrizCuadrada() {

		// Arrange
		int[][] matrizEntrada = { { 8, 2, -3 }, { 5, -6, -6 }, { 21, 1, -5 } };
		int[][] matrizEsperada = { { 15, 1, -7 }, { 28, -4, -20 }, { 27, 11, -10 } };
		// Act
		int[][] matrizObtenida = Ejercicio03.resolver(matrizEntrada);
		// Assert
		Assert.assertTrue(Arrays.deepEquals(matrizEsperada, matrizObtenida));
	}

}
