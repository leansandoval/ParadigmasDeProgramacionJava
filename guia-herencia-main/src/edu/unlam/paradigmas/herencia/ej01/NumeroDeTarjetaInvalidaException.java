package edu.unlam.paradigmas.herencia.ej01;

public class NumeroDeTarjetaInvalidaException extends Exception {

	private static final long serialVersionUID = 1L;

	public NumeroDeTarjetaInvalidaException(String mensaje) {
		super(mensaje);
	}
	
}
