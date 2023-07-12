package unlam.paradigmas.objetos.ej02;

import org.junit.Assert;
import org.junit.Test;

public class PuntoTests {
	
	public final static double TOLERANCIA = 0.00000001;

	@Test
	public void seEncuentraEnElOrigen() {
		Punto punto = new Punto(0, 0);
		Assert.assertTrue(punto.esElOrigen());
	}

	@Test
	public void seEncuentraEnElEjeX() {
		Punto punto = new Punto(0, 100);
		Assert.assertTrue(punto.estaSobreEjeX());
	}

	@Test
	public void seEncuentraEnElEjeY() {
		Punto punto = new Punto(100, 0);
		Assert.assertTrue(punto.estaSobreEjeY());
	}

	@Test
	public void usandoDistanciaAlOrigen() {
		Punto punto = new Punto(2, 4);
		double distanciaObtenida = punto.distanciaAlOrigen();
		double distanciaEsperada = 4.472135955;
		
		/*
		 * El mensaje de error indica que el método assertEquals(double, double) está
		 * obsoleto (deprecated) y, por lo tanto, se recomienda no utilizarlo en el
		 * código fuente.
		 * 
		 * La razón por la que este método está obsoleto es que en algunas situaciones
		 * puede haber problemas con la precisión numérica al comparar valores de punto
		 * flotante (double) utilizando una comparación directa.
		 * 
		 * En su lugar, se recomienda utilizar el método assertEquals(double expected,
		 * double actual, double delta) que acepta un tercer argumento delta que indica
		 * la cantidad de diferencia permitida entre los dos valores dobles. Esto
		 * permite una comparación más precisa y controlada de los valores de punto
		 * flotante.
		 */
		
		Assert.assertEquals(distanciaEsperada, distanciaObtenida, TOLERANCIA);
	}

	@Test
	public void usandoDistanciaAOtroPunto()
	{
		Punto puntoOrigen = new Punto(1, 2);
		Punto puntoDestino = new Punto(5, 3);
		double distanciaObtenida = puntoOrigen.distanciaAOtroPunto(puntoDestino);
		double distanciaEsperada = 4.123105626;
		Assert.assertEquals(distanciaObtenida, distanciaEsperada, TOLERANCIA);
	}

	@Test
	public void cambiandoCoordenadaY() {
		Punto primerPunto = new Punto(1, 100);
		Punto segundoPunto = new Punto(1, 250);
		primerPunto.cambiarY(50);
		segundoPunto.cambiarY(50);
		double moduloPrimerPunto = primerPunto.distanciaAlOrigen();
		double moduloSegundoPunto = segundoPunto.distanciaAlOrigen();
		Assert.assertEquals(moduloPrimerPunto, moduloSegundoPunto, TOLERANCIA);
	}
	
	@Test
	public void cambiandoCoordenadaX() {
		Punto primerPunto = new Punto(1, 100);
		Punto segundoPunto = new Punto(1, 100);
		primerPunto.cambiarX(50);
		segundoPunto.cambiarX(50);
		double moduloPrimerPunto = primerPunto.distanciaAlOrigen();
		double moduloSegundoPunto = segundoPunto.distanciaAlOrigen();
		Assert.assertEquals(moduloPrimerPunto, moduloSegundoPunto, TOLERANCIA);
	}
}
