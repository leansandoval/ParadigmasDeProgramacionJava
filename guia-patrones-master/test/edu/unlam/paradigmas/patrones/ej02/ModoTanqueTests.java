package edu.unlam.paradigmas.patrones.ej02;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ModoTanqueTests {
	
	private static Tank tanque;

	@BeforeClass
	public static void setearEstadoDeTanque() {
		tanque = new Tank();
		TankState estadoTanque = new TankModeTankState();
		tanque.setEstado(estadoTanque);
	}

	@Test
	public void tanqueAtaca() {
		Assert.assertEquals("El tanque ataca en modo tanque", tanque.atacar());
	}

	@Test
	public void tanqueSeMueve() {
		Assert.assertEquals("El tanque se mueve en modo tanque", tanque.moverse());
	}
	
}
