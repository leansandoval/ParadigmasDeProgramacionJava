package edu.unlam.paradigmas.patrones.ej02;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ModoAsedioTests {

	private static Tank tanque;

	/*
	 * Diferencia entre @Before y @BeforeClass: es cómo y cuándo se ejecutan los
	 * métodos.
	 * 
	 * @Before se utiliza para marcar un método que debe ejecutarse antes de cada
	 * método de prueba (es decir, antes de cada test). Este método se utiliza
	 * comúnmente para realizar la configuración necesaria antes de ejecutar cada
	 * test, como inicializar objetos, configurar variables, etc. Cada vez que se
	 * ejecuta un test, el método anotado con @Before se ejecutará primero.
	 * 
	 * @BeforeClass, por otro lado, se utiliza para marcar un método que debe
	 * ejecutarse solo una vez antes de todos los métodos de prueba en una clase.
	 * Este método se ejecuta antes de cualquier test en la clase y se utiliza
	 * generalmente para realizar la configuración inicial que es común a todos los
	 * tests en la clase. Al igual que @Before, se utiliza para inicializar objetos,
	 * configurar variables, etc., pero a diferencia de @Before, solo se ejecuta una
	 * vez.
	 * 
	 * En resumen:
	 * 
	 * @Before se ejecuta antes de cada test dentro de una clase.
	 * 
	 * @BeforeClass se ejecuta una vez antes de todos los tests en una clase.
	 */

	@BeforeClass
	public static void setearEstadoDeTanque() {
		tanque = new Tank();
		TankState estadoTanque = new TankModeSiegeState();
		tanque.setEstado(estadoTanque);
	}

	@Test
	public void tanqueAtaca() {
		Assert.assertEquals("El tanque ataca en modo asedio", tanque.atacar());
	}

	@Test
	public void tanqueSeMueve() {
		Assert.assertEquals("El tanque no se puede mover en modo asedio", tanque.moverse());
	}

}
