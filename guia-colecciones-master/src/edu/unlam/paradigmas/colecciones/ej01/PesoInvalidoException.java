package edu.unlam.paradigmas.colecciones.ej01;

public class PesoInvalidoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PesoInvalidoException(String mensaje) {
		super(mensaje);
	}

}
