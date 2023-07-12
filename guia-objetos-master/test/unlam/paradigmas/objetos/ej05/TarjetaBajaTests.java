package unlam.paradigmas.objetos.ej05;

import org.junit.Assert;
import org.junit.Test;

public class TarjetaBajaTests {

	@Test
	public void probandoCargaSaldo() {
		TarjetaBaja tarjeta = new TarjetaBaja(300);
		tarjeta.cargar(400);
		double saldoObtenido = tarjeta.obtenerSaldo();
		double saldoEsperado = 700;
		Assert.assertEquals(saldoObtenido, saldoEsperado, 0.00000001);
	}

	@Test
	public void probandoCantViajes() {
		TarjetaBaja tarjeta = new TarjetaBaja(1000);

		int i;

		for (i = 0; i < 5; i++) // 5 veces
			tarjeta.pagarViajeEnColectivo();

		for (i = 0; i < 3; i++) // 3 veces
			tarjeta.pagarViajeEnSubte();

		int cantidadObtenida = tarjeta.contarViajes();
		int cantidadEsperada = 8;

		Assert.assertEquals(cantidadObtenida, cantidadEsperada);
	}
}
