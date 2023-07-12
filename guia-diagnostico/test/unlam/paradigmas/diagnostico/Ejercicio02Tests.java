package unlam.paradigmas.diagnostico;

import org.junit.Assert;
import org.junit.Test;

public class Ejercicio02Tests {

	@Test
	public void matrizSinCeros() {

		// Arrange
		boolean esperado = false;
		int[][] m = { { 1, 2, 3 }, { 4, 5, 6 } };
		// Act
		boolean obtenido = Ejercicio02.resolver(m);
		// Assert
		Assert.assertEquals(esperado, obtenido);
	}

	@Test
	public void matrizConUnCero() {

		// Arrange
		boolean esperado = true;
		int[][] m = { { 0, 2, 3 }, { 4, 5, 6 } };
		// Act
		boolean obtenido = Ejercicio02.resolver(m);
		// Assert
		Assert.assertEquals(esperado, obtenido);
	}

}
