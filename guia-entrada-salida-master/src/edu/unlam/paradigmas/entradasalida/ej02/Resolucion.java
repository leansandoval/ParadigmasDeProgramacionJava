package edu.unlam.paradigmas.entradasalida.ej02;

import java.util.Arrays;

public class Resolucion {

	public void resolver(String nombreArchivo) {

		Archivo archivo = new Archivo(nombreArchivo);
		int[] datosLectura = archivo.leerArchivo();
		
		int minimo = Arrays.stream(datosLectura).min().getAsInt();
		int maximo = Arrays.stream(datosLectura).max().getAsInt();
		int promedio = Arrays.stream(datosLectura).sum() / datosLectura.length;
		
		int[] datosEscritura = {maximo, minimo, promedio};
		
		archivo.grabarArchivo(datosEscritura);
	}
}
