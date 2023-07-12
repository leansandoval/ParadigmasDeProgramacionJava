package edu.unlam.paradigmas.herencia.ej01;

public class FechaInvalidaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FechaInvalidaException(String mensaje) {
		super(mensaje);
	}
}
