package edu.unlam.paradigmas.colecciones.ej01;

public class DireccionInvalidaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DireccionInvalidaException(String mensaje) {
		super(mensaje);
	}
}
