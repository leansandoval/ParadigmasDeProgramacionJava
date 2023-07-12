package edu.unlam.paradigmas.herencia.ej01;

import java.math.BigDecimal;

public class TarjetaDeDebito {

	private Cuenta cuentaAsociada;

	public TarjetaDeDebito(Cuenta cuentaAsociada) {
		this.cuentaAsociada = cuentaAsociada;
	}

	public boolean comprar(BigDecimal monto) {
		return cuentaAsociada.extraer(monto);
	}
}
