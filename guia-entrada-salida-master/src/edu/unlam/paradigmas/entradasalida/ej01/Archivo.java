package edu.unlam.paradigmas.entradasalida.ej01;

import edu.unlam.paradigmas.entradasalida.constantes.Constante;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class Archivo {

	private String nombreArchivo;

	public Archivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public int[] leerArchivo() {

		Scanner scanner = null;
		int[] datos = null;

		try {
			
			File archivo = new File(Constante.DIRECCION_ARCHIVOS_IN + this.nombreArchivo + Constante.EXTENSION_IN);
			scanner = new Scanner(archivo);
			scanner.useLocale(Locale.ENGLISH);

			int cantidadDeElementos = scanner.nextInt();
			datos = new int[cantidadDeElementos];

			for (int i = 0; i < cantidadDeElementos; i++)
				datos[i] = scanner.nextInt();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}

		return datos;
	}

	public void guardarArchivo(int[] datos) {

		FileWriter fileWriter = null;
		PrintWriter printWriter = null;

		try {

			fileWriter = new FileWriter(Constante.DIRECCION_ARCHIVOS_OUT + this.nombreArchivo + Constante.EXTENSION_OUT);
			printWriter = new PrintWriter(fileWriter);

			printWriter.print(datos.length + "\n");

			for (int i = 0; i < datos.length; i++)
				printWriter.print(datos[i] + "\n");

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			if (fileWriter != null)
				try {
					fileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

}
