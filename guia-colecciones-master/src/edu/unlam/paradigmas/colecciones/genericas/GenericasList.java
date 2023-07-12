package edu.unlam.paradigmas.colecciones.genericas;

import java.util.List;
import java.util.function.Predicate;

public class GenericasList {

	public static <T> T buscarElementoEnListaPorAtributo(List<T> lista, Predicate<T> predicado) {
		if (lista.isEmpty())
			return null;
		T elementoEncontrado = null;
		for (T elemento : lista) {
			if (predicado.test(elemento)) {
				elementoEncontrado = elemento;
				break;
			}
		}
		return elementoEncontrado;
	}

	public static <T> void mostrarListaSegunCriterio(List<T> lista, Predicate<T> criterio) {
		if (lista.size() == 0)
			System.out.println("La lista se encuentra vacia");
		boolean hayCriterio = false;
		System.out.println("======= LISTA =======");
		for (T elemento : lista) {
			if (criterio.test(elemento)) {
				System.out.println(elemento);
				hayCriterio = true;
			}
		}
		System.out.println("=====================");
		if (hayCriterio == false)
			System.out.println("No hay elemento en la lista que satisfaga el critero");
	}

}
