package unlam.paradigmas.diagnostico;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class Ejercicio05Tests {

	@Test
	public void matrizRegular() {

		int[][] matrizEntrada = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int[][] matrizObtenida = Ejercicio05.resolver(matrizEntrada);

		int[][] matrizEsperada = { { 13 }, { 9, 14 }, { 5, 10, 15 }, { 1, 6, 11, 16 }, { 2, 7, 12 }, { 3, 8 }, { 4 } };
	
		Assert.assertTrue(Arrays.deepEquals(matrizEsperada, matrizObtenida));
	}

}
