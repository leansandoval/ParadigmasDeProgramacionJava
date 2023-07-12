package edu.unlam.paradigmas.excepciones.ej03;

/* Las excepciones que heredan de RuntimeException no necesitan ser declaradas en la 
 * firma del método, por lo que no se necesita usar la palabra clave throws en la firma 
 * del método para indicar que la excepción puede ser lanzada.*/

public class DivisionPorCeroException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DivisionPorCeroException(String mensaje) {
		super(mensaje);
	}
}
