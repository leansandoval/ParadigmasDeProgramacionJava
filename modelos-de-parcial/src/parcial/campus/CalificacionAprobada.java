package parcial.campus;

public class CalificacionAprobada implements EstadoCalificacion {

	@Override
	public void revisar() {
		System.out.println(
				"La calificacion fue determinada con su condicion final. No se encuentra en estado de pendiente.");
	}

	@Override
	public void aprobar() {
		System.out.println("La calificacion se encuentra en estado de aprobada.");
	}

	@Override
	public void reprobar() {
		System.out.println("La calificacion no se encuentra en estado de desaprobada.");
	}
}
