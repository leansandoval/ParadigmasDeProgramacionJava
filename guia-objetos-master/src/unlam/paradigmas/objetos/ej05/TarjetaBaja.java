package unlam.paradigmas.objetos.ej05;

/*Ejercicio 05: Implementar la clase TarjetaBaja a partir de la interfaz proporcionada.

Realizar todas las pruebas que considere convenientes. Se pueden agregar métodos privados.*/

public class TarjetaBaja {

	private double saldo;
	private int cantViajesSubte;
	private int cantViajesColectivo;

	public TarjetaBaja(double saldoInicial) {
		if (saldoInicial > 0) {
			this.saldo = saldoInicial;
			this.cantViajesColectivo = this.cantViajesSubte = 0;
		} else
			throw new IllegalArgumentException("El saldo no puede ser negativo");
	}

	public double obtenerSaldo() {
		return this.saldo;
	}

	public void cargar(double monto) {
		if(monto > 0)
			this.saldo += monto;
		else
			throw new IllegalArgumentException("La carga debe ser sobre un monto positivo");
	}

	public void pagarViajeEnColectivo() {
		if (this.saldo > 39.59) {
			this.saldo -= 39.59;
			this.cantViajesColectivo++;
		} else
			throw new IllegalArgumentException("Saldo insuficiente");
	}

	public void pagarViajeEnSubte() {
		if (this.saldo > 34.50) {
			this.saldo -= 34.50;
			this.cantViajesSubte++;
		} else
			throw new IllegalArgumentException("Saldo insuficiente");
	}

	public int contarViajes() {
		return this.cantViajesColectivo + this.cantViajesSubte;
	}

	public int contarViajesEnColectivo() {
		return this.cantViajesColectivo;
	}

	public int contarViajesEnSubte() {
		return this.cantViajesSubte;
	}
}
