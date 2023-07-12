package edu.unlam.paradigmas.excepciones.ej05;

public class SaldoNegativoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SaldoNegativoException(String mensaje) {
		super(mensaje);
	}

}
