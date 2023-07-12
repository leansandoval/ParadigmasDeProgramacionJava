package parcial.campus;

public class CalificacionPendiente implements EstadoCalificacion {

	@Override
	public void revisar() {
		System.out.println("La calificacion se encuentra en estado pendiente.");
	}

	@Override
	public void aprobar() {
		System.out.println("Todavia no se determino la condicion final de la calificacion.");

	}

	@Override
	public void reprobar() {
		System.out.println("Todavia no se determino la condicion final de la calificacion.");
	}

}
