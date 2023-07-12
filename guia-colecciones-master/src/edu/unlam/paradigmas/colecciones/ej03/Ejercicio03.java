package edu.unlam.paradigmas.colecciones.ej03;

import java.util.HashSet;
import java.util.Set;

public class Ejercicio03 {

	public static void listadoDePalabrasUnicas(Set<String> palabrasUnicas, String texto) {

		/*
		 * En una expresión regular, el carácter "\W" se refiere a cualquier carácter
		 * que no sea una letra o un número. Por lo tanto, "\W+" significa una o más
		 * ocurrencias consecutivas de cualquier carácter que no sea una letra o un
		 * número.
		 */

		String[] palabrasTexto = texto.split("\\W+");

		for (int i = 0; i < palabrasTexto.length; i++)
			palabrasUnicas.add(palabrasTexto[i].toLowerCase());
		
		/*
		 * Se utiliza toLowerCase para asegurarse de que las palabras en el conjunto
		 * sean únicas independientemente de si están escritas en mayúsculas o
		 * minúsculas
		 */

		System.out.println("Palabras unicas encontradas:");
		for (String palabraUnica : palabrasUnicas)
			System.out.println(palabraUnica);
	}

	public static void main(String[] args) {

		String textoConPalabrasRepetidas = "El gato es un animal muy independiente. A diferencia de los "
				+ "perros, los gatos no necesitan salir a pasear para hacer sus necesidades. Los gatos son muy buenos "
				+ "cazadores, y pueden pasar horas acechando a su presa. Algunos gatos son mas cariniosos que "
				+ "otros, pero en general se dice que los gatos son animales mas reservados que los perros.";

		Set<String> palabrasUnicas = new HashSet<String>();

		listadoDePalabrasUnicas(palabrasUnicas, textoConPalabrasRepetidas);
	}

}
