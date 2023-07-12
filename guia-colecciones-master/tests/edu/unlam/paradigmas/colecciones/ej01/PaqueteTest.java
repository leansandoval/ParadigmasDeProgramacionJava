package edu.unlam.paradigmas.colecciones.ej01;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import edu.unlam.paradigmas.colecciones.genericas.GenericasList;

public class PaqueteTest {

	@Test
	public void mismoNumeroDeSeguimiento() {
		List<Paquete> listaPaquetes = new ArrayList<>();
		listaPaquetes.add(new Paquete(123, "Martin Coronado 5555", "Calle Falsa 123", 45.5));
		Paquete resultadoObtenido = GenericasList.buscarElementoEnListaPorAtributo(listaPaquetes,
				paquete -> paquete.getNumeroSeguimiento() == 123);
		Paquete resultadoEsperado = listaPaquetes.get(0);
		Assert.assertEquals(resultadoEsperado, resultadoObtenido);
	}

}
