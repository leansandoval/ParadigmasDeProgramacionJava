package edu.unlam.paradigmas.herencia.ej01;

import java.math.BigDecimal;

public class Main {

	public static void main(String[] args) throws NumeroDeTarjetaInvalidaException {

		Cuenta cuentaOrigen = new Cuenta();

		cuentaOrigen.depositar(new BigDecimal("10000"));
		System.out.println(cuentaOrigen.consultarSaldo()); // 10000.0

		Cuenta cuentaDestino = new Cuenta();
		System.out.println(cuentaDestino.consultarSaldo()); // 0.0

		cuentaOrigen.transferir(new BigDecimal("550"), cuentaDestino);
		System.out.println(cuentaOrigen.consultarSaldo()); // 9450.0
		System.out.println(cuentaDestino.consultarSaldo()); // 550.0

		cuentaOrigen.mostrarTransacciones();
		cuentaDestino.mostrarTransacciones();

		TarjetaDeCredito tarjetaDeCredito = new TarjetaDeCredito(41548235, cuentaDestino);
		tarjetaDeCredito.comprar(new BigDecimal(200));
		if (tarjetaDeCredito.debitarTotalCompras()) {
			System.out.println("Se pudo debitar las compras con la tarjeta");
			System.out.println("Saldo actual: " + cuentaDestino.consultarSaldo());
		} else
			System.out.println("No es posible debitar ya que no posee saldo suficiente");

	}

}
