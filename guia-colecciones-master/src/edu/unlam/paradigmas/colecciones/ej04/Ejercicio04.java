package edu.unlam.paradigmas.colecciones.ej04;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Ejercicio04 {

	public static void main(String[] args) {

		Libro[] libros = { new Libro("El Principito", "Antoine de Saint-Exupery"),
				new Libro("Cien anios de soledad", "Gabriel Garcia Marquez"), new Libro("La Odisea", "Homero"),
				new Libro("La Iliada", "Homero"), new Libro("El Codigo Da Vinci", "Dan Brown"),
				new Libro("La Divina Comedia", "Dante Alighieri"), new Libro("Los Miserables", "Victor Hugo"),
				new Libro("Don Quijote de la Mancha", "Miguel de Cervantes"),
				new Libro("El Perfume", "Patrick Suskind"), new Libro("El Hobbit", "J.R.R. Tolkien"),
				new Libro("El Senior de los Anillos", "J.R.R. Tolkien") };

		Set<Libro> librosUnicos = new TreeSet<Libro>(Arrays.asList(libros));

		System.out.println("Titulos unicos de libros en la tienda\n");
		for (Libro libro : librosUnicos) {
			System.out.println(libro);
		}

	}

}
