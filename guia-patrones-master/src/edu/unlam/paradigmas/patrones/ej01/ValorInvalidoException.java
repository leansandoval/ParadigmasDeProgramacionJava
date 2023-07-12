package edu.unlam.paradigmas.patrones.ej01;

public class ValorInvalidoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ValorInvalidoException(String mensaje) {
		super(mensaje);
	}
}
