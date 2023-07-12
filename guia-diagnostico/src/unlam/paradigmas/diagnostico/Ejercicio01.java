package unlam.paradigmas.diagnostico;

public class Ejercicio01 {

	public static boolean resolver(int[][] m) {
		
		if (m.length == 0)
			return false;
		
		int sumaDiagonalPrincipal = 0, i;
		
		boolean seEncontro = false;
		
		for (i = 0; i < m.length; i++)
			sumaDiagonalPrincipal += m[i][i];
		
		for (i = 0; i < m.length && !seEncontro; i++)
			for (int j = 0; j < m[i].length && !seEncontro; j++)
				if (m[i][j] == sumaDiagonalPrincipal)
					seEncontro = true;
		
		return seEncontro;
	}
}
