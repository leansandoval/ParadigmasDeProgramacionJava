package edu.unlam.paradigmas.herencia.ej01;

import java.math.BigDecimal;

public class CuentaCorriente extends Cuenta {

	private final BigDecimal saldoDescubierto;

	public CuentaCorriente(BigDecimal saldoDescubierto) {
		super();
		if (saldoDescubierto.compareTo(BigDecimal.ZERO) < 0)
			throw new IllegalArgumentException("El saldo descubierto no puede ser negativo");
		this.saldoDescubierto = saldoDescubierto;
	}

	@Override
	public boolean extraer(BigDecimal montoAExtraer) {
		BigDecimal saldoTotal = this.saldo.add(this.saldoDescubierto);
		return puedoExtraer(saldoTotal, montoAExtraer)
				? super.extraer(montoAExtraer.compareTo(this.saldo) > 0 ? consultarSaldo() : montoAExtraer)
				: false;
	}

	public BigDecimal getSaldoDescubierto() {
		return this.saldoDescubierto;
	}

}