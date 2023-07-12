package edu.unlam.paradigmas.entradasalida.ej01;

import java.util.Arrays;

public class Resolucion {

	public void resolver(String nombreArchivo) {

		Archivo archivo = new Archivo(nombreArchivo); // Leo los datos del archivo
		int[] datosLectura = archivo.leerArchivo(); // Y los guardo en un vector de enteros

		Arrays.sort(datosLectura); // Ordeno el vector

		int cantDupEliminados = eliminarDuplicados(datosLectura); // Elimino los duplicados

		int[] datosEscritura = new int[cantDupEliminados]; // Creo un nuevo vector con los elementos sin duplicados

		for (int i = 0; i < datosEscritura.length; i++)
			datosEscritura[i] = datosLectura[i];

		archivo.guardarArchivo(datosEscritura); // Guardo en un nuevo archivo el vector
	}

	public int eliminarDuplicados(int[] vector) {

		int finVector = vector.length;

		for (int i = 0; i < finVector; i++, finVector--)
			if (vector[i] == vector[i + 1])
				desplazarElementos(vector, i + 1, finVector);

		return vector.length - finVector;
	}

	public void desplazarElementos(int[] vector, int limInf, int limSup) {
		for (int i = limInf; i < limSup - 1; i++)
			vector[i] = vector[i + 1];
	}

}
