package unlam.paradigmas.diagnostico;

public class Ejercicio03 {

	public static int[][] resolver(int[][] m) {

		if (m.length == 0)
			return null;

		int i;

		int[][] matrizNueva = new int[m.length][]; // Defino tamaño de filas
		for (i = 0; i < m.length; i++)
			matrizNueva[i] = new int[m[i].length]; // Defino tamaño de columnas

		for (i = 0; i < m.length; i++)
			for (int j = 0; j < m[i].length; j++)
				matrizNueva[i][j] = sumarAdyacentes(m, i, j);

		return matrizNueva;
	}

	public static int sumarAdyacentes(int[][] m, int fil, int col) {

		int res;

		if (fil == 0) {

			res = (col == 0) ? m[fil + 1][col] + m[fil][col] + m[fil][col + 1] : // Caso m[0][0]
					(col == m[fil].length - 1) ? m[fil][col - 1] + m[fil][col] + m[fil + 1][col] : // Caso m[0][col]
							m[fil][col - 1] + m[fil + 1][col] + m[fil][col] + m[fil][col + 1]; // Caso m[0][j]
		} else {
			if (fil == m.length - 1) {

				res = (col == 0) ? m[fil - 1][col] + m[fil][col] + m[fil][col + 1] // Caso m[fil][0]
						: (col == m[fil].length - 1) ? m[fil - 1][col] + m[fil][col] + m[fil][col - 1] // Caso
																										// m[fil][col]
								: m[fil - 1][col] + m[fil][col] + m[fil][col + 1] + m[fil][col - 1]; // Caso m[fil][j]

			} else {

				res = (col == 0 && fil != 0 && fil != m.length - 1)
						? m[fil][col] + m[fil - 1][col] + m[fil + 1][col] + m[fil][col + 1] // Caso m[i][0]
						: (col == m[fil].length - 1) ? m[fil][col] + m[fil - 1][col] + m[fil + 1][col] + m[fil][col - 1] // Caso
																															// m[i][col]
								: m[fil][col] + m[fil - 1][col] + m[fil + 1][col] + m[fil][col - 1] + m[fil][col + 1]; // Caso
																														// normal
			}
		}

		return res;
	}

}