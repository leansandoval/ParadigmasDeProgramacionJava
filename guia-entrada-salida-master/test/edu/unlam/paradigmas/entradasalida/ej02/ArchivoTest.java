package edu.unlam.paradigmas.entradasalida.ej02;

import edu.unlam.paradigmas.entradasalida.constantes.Constante;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;

public class ArchivoTest {

	final static String NOMBRE_ARCHIVO_EJEMPLO_1 = "Ejercicio2-Ejemplo1";

	@Test
	public void testUno() {

		Resolucion resolucion = new Resolucion();
		resolucion.resolver(NOMBRE_ARCHIVO_EJEMPLO_1);

		try {
			byte[] f1 = Files.readAllBytes(
					Paths.get(Constante.DIRECCION_ARCHIVOS_OUT + NOMBRE_ARCHIVO_EJEMPLO_1 + Constante.EXTENSION_OUT));
			byte[] f2 = Files.readAllBytes(
					Paths.get(Constante.DIRECCION_ARCHIVOS_OUT_ESPERADO + NOMBRE_ARCHIVO_EJEMPLO_1 + Constante.EXTENSION_OUT));
			Assert.assertArrayEquals(f1, f2);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

}
