package edu.unlam.paradigmas.entradasalida.ej02;

public class Main {

	final static String NOMBRE_ARCHIVO_EJEMPLO_1 = "Ejercicio2-Ejemplo1";

	public static void main(String[] args) {

		/*Archivo archivo = new Archivo(NOMBRE_ARCHIVO);
		archivo.crearArchivo();*/

		Resolucion resolucion = new Resolucion();
		resolucion.resolver(NOMBRE_ARCHIVO_EJEMPLO_1);
	}

}
