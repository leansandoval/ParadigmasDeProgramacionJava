package edu.unlam.paradigmas.excepciones.ej05;

public class SaldoInsuficienteException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public SaldoInsuficienteException(String mensaje) {
		super(mensaje);
	}

}
