package edu.unlam.paradigmas.excepciones.ej08;

public class Ejercicio08 {
	public static double division(double dividendo, double divisor) {
		if (divisor == 0)
			throw new ArithmeticException("No se puede dividir por cero");
		return dividendo / divisor;
	}
}
