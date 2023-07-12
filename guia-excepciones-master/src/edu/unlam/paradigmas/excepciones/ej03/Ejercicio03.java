package edu.unlam.paradigmas.excepciones.ej03;

public class Ejercicio03 {

	public static double division(int dividendo, int divisor) {
		if (divisor == 0)
			throw new DivisionPorCeroException("No se puede dividir por cero");
		return (double) dividendo / divisor;
	}
}
