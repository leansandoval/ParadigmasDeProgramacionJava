package unlam.paradigmas.diagnostico;

public class Ejercicio05 {

	public static int[][] resolver(int[][] m) {

		int[][] matrizNueva = new int[2 * m.length - 1][];

		int colPasandoMitad = matrizNueva.length / 2;

		for (int c = 0; c < matrizNueva.length; c++)
			matrizNueva[c] = new int[c <= matrizNueva.length / 2 ? c + 1 : colPasandoMitad--];

		// https://es.stackoverflow.com/questions/407618/c%C3%B3mo-puedo-recorrer-una-matriz-de-forma-diagonal-en-java

		for (int diagonal = 1 - m.length,
				filMatrizNueva = matrizNueva.length - 1; diagonal <= m.length - 1; diagonal += 1, filMatrizNueva--)
			for (int i = Math.max(0, diagonal), j = -Math.min(0, diagonal), colMatrizNueva = 0; i < m.length
					&& j < m.length; i += 1, j += 1, colMatrizNueva++)
				matrizNueva[filMatrizNueva][colMatrizNueva] = m[i][j];

		return matrizNueva;
	}
}
