package parcial.cocina;

import java.time.LocalDate;

public class Mesero extends Empleado {

	public Mesero(int dni, LocalDate fechaIngreso) {
		super(dni, fechaIngreso);
	}

	@Override
	public void realizarTarea() {
		entregarPlato();
		devolverPlato();
		super.realizarTarea();
	}

	private void entregarPlato() {
		System.out.println("Mesero: Entregando plato");
	}

	private void devolverPlato() {
		System.out.println("Mesero: Devolviendo plato");
	}
}
