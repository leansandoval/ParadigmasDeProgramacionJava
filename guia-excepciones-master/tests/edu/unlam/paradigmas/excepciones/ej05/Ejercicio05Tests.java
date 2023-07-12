package edu.unlam.paradigmas.excepciones.ej05;

import org.junit.Assert;
import org.junit.Test;

public class Ejercicio05Tests {

	@Test(expected = SaldoInsuficienteException.class)
	public void saldoInsuficiente() {
		CuentaBancaria cuenta = new CuentaBancaria("Leandro", 150);
		cuenta.retirar(200);
		Assert.fail("No debería llegar a este punto");
	}

	@Test(expected = MontoNegativoException.class)
	public void retirarSaldoNegativo() {
		CuentaBancaria cuenta = new CuentaBancaria("Leandro", 150);
		cuenta.retirar(-10);
		Assert.fail("No debería llegar a este punto");
	}

	@Test(expected = MontoNegativoException.class)
	public void depositarSaldoNegativo() {
		CuentaBancaria cuenta = new CuentaBancaria("Leandro", 150);
		cuenta.depositar(-10);
		Assert.fail("No debería llegar a este punto");
	}

	@Test(expected = SaldoNegativoException.class)
	public void saldoNegativo() {
		new CuentaBancaria("Leandro", -150);
		Assert.fail("No debería llegar a este punto");
	}
}
