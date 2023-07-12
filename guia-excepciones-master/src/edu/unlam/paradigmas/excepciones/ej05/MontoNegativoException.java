package edu.unlam.paradigmas.excepciones.ej05;

public class MontoNegativoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public MontoNegativoException(String mensaje) {
		super(mensaje);
	}

}
