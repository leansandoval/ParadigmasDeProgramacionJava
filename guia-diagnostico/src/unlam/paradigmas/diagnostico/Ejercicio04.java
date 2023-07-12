package unlam.paradigmas.diagnostico;

//import javax.naming.spi.Resolver;

public class Ejercicio04 {

	public static int[] resolver(int[][] m) {

		if (m.length == 0)
			return null;

		int[] vectorModa = new int[m.length];
		int valorModa, posibleNuevaModa, ocurrencias, ocurrenciasPosibleNuevaModa;
		
		for(int i = 0; i < m.length; i++)
		{
			ocurrencias = cantOcurrenciasVectorPorDato(m[i], m[i][0]);
			valorModa = m[i][0];
			
			for(int j = 1; j < m[i].length; j++)
			{
				posibleNuevaModa = m[i][j];
				ocurrenciasPosibleNuevaModa = cantOcurrenciasVectorPorDato(m[i], posibleNuevaModa);

				if(ocurrenciasPosibleNuevaModa > ocurrencias)
				{
					valorModa = posibleNuevaModa;
					ocurrencias = ocurrenciasPosibleNuevaModa;
				}
				
				if (ocurrenciasPosibleNuevaModa == ocurrencias && posibleNuevaModa > valorModa)
				{
					valorModa = posibleNuevaModa;
					ocurrencias = ocurrenciasPosibleNuevaModa;
				}
			}
			vectorModa[i] = valorModa;
		}

		return vectorModa;
	}

	public static int cantOcurrenciasVectorPorDato(int[] v, int dato) {

		int ocurrencias = 0;

		for (int i = 0; i < v.length; i++)
			if (dato == v[i])
				ocurrencias++;

		return ocurrencias;
	}

}
