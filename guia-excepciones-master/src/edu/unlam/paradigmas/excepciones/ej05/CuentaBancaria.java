package edu.unlam.paradigmas.excepciones.ej05;

public class CuentaBancaria {

	private String titular;
	private double saldo;

	public CuentaBancaria(String titular, double saldoInicial) {
		if (saldoInicial < 0)
			throw new SaldoNegativoException("El saldo a crear la cuenta debe ser positivo");
		if (titular == null)
			throw new NullPointerException("Campo de titular invalido");
		this.titular = titular;
		this.saldo = saldoInicial;
	}

	public void depositar(double monto) {
		if (monto < 0)
			throw new MontoNegativoException("El monto a depositar es negativo");
		this.saldo += monto;
	}

	public void retirar(double monto) {
		if (monto < 0)
			throw new MontoNegativoException("El monto a retirar es negativo");
		if (this.saldo < monto)
			throw new SaldoInsuficienteException("Saldo insuficiente");
		this.saldo -= monto;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public String getTitular() {
		return this.titular;
	}

	@Override
	public String toString() {
		return "Titular: " + this.titular + "\nSaldo: " + this.saldo;
	}
	
	public static void main(String[] args) {

		CuentaBancaria cuenta = null;
		try {
			cuenta = new CuentaBancaria("Juan Perez", 1000);
			//cuenta = new CuentaBancaria("Juan Perez", -1000);
			cuenta.retirar(1500);
			// cuenta.retirar(-1500);
			// cuenta.depositar(-1500);
		} catch (SaldoNegativoException e) {
			System.out.println("Excepcion SaldoNegativoException: " + e.getMessage());
		} catch (SaldoInsuficienteException e) {
			System.out.println("Excepcion SaldoInsuficienteException: " + e.getMessage());
		} catch (MontoNegativoException e) {
			System.out.println("Excepcion MontoNegativoException: " + e.getMessage());
		}

		try {
			System.out.println(cuenta.toString());
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}

}