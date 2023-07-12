package edu.unlam.paradigmas.entradasalida.ej01;

public class Main {

	final static String NOMBRE_ARCHIVO_EJEMPLO_1 = "Ejercicio1-Ejemplo1";
	final static String NOMBRE_ARCHIVO_EJEMPLO_2 = "Ejercicio1-Ejemplo2";

	public static void main(String[] args) {

		 /*Archivo archivo = new Archivo(NOMBRE_ARCHIVO_EJEMPLO_01);
		 archivo.crearArchivo();*/

		Resolucion resolucion = new Resolucion();
		resolucion.resolver(NOMBRE_ARCHIVO_EJEMPLO_1);
		resolucion.resolver(NOMBRE_ARCHIVO_EJEMPLO_2);
	}

}
