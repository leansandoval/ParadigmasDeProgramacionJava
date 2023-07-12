package parcial.productos;

public class CantidadInvalidaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CantidadInvalidaException(String mensaje) {
		super(mensaje);
	}
}
