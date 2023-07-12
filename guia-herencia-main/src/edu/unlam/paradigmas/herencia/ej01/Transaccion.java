package edu.unlam.paradigmas.herencia.ej01;

import java.math.BigDecimal;

public class Transaccion implements Comparable<Transaccion> {

	private static int contadorId = 1;

	private final int id;
	private final String motivo;
	private final BigDecimal monto;
	private final Fecha fecha;

	public Transaccion(String motivo, BigDecimal totalDebitar, Fecha fecha) {
		this.id = generarId();
		this.motivo = motivo;
		this.monto = totalDebitar;
		this.fecha = fecha;
	}

	private static synchronized int generarId() {
		return contadorId++;
	}

	@Override
	public String toString() {
		return "Id: " + this.id + ", Fecha: " + this.fecha + ", Motivo: " + this.motivo + ", Monto: " + this.monto;
	}

	@Override
	public int compareTo(Transaccion otraTransaccion) {
		return Integer.compare(this.id, otraTransaccion.id);
	}

}
