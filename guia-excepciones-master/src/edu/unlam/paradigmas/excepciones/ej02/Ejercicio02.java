package edu.unlam.paradigmas.excepciones.ej02;

public class Ejercicio02 {

	public static double raizCuadrada(double numero) throws RaizCuadradaException {
		if (numero < 0)
			throw new RaizCuadradaException("Numero invalido");
		return Math.sqrt(numero);
	}
}
