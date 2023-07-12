package edu.unlam.paradigmas.colecciones.ej02;

public class NumeroDeVentaInvalidoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NumeroDeVentaInvalidoException(String mensaje) {
		super(mensaje);
	}
}
