package edu.unlam.paradigmas.herencia.ej01;

import java.math.BigDecimal;

public class CuentaDeAhorro extends Cuenta {

	private BigDecimal saldoReservado;

	public CuentaDeAhorro() {
		super();
		this.saldoReservado = BigDecimal.ZERO;
	}

	public boolean reservarSaldo(BigDecimal saldoAReservar) {
		if (!extraer(saldoAReservar))
			return false;
		this.saldoReservado = this.saldoReservado.add(saldoAReservar);
		registrarTransaccion("Reserva", saldoAReservar);
		return true;
	}

	public void reintegrarSaldoReservado() {
		depositar(saldoReservado);
		registrarTransaccion("Reintegro", saldoReservado);
		this.saldoReservado = BigDecimal.ZERO;
	}

	public BigDecimal consultarSaldoReservado() {
		return this.saldoReservado;
	}

}
