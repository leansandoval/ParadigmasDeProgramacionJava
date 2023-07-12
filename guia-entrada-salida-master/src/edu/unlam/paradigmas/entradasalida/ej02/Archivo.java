package edu.unlam.paradigmas.entradasalida.ej02;

import edu.unlam.paradigmas.entradasalida.constantes.*;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.IOException;

public class Archivo {

	final static int CANT_MINIMA = 10000;
	final static int CANT_MAXIMA = 20000;
	
	final static int ELEM_MAXIMO = 12000;

	final static String SEPARADOR = "+----------+-------+";

	private String nombreArchivo;

	public Archivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public void crearArchivo() {

		try {

			File archivo = new File(Constante.DIRECCION_ARCHIVOS_IN + this.nombreArchivo + Constante.EXTENSION_IN);

			if (!archivo.exists())
				archivo.createNewFile();

			FileWriter fileWriter = new FileWriter(archivo);
			PrintWriter printWriter = new PrintWriter(fileWriter);

			Random random = new Random();

			// Entre 10000 y 20000
			int cantNumeros = random.nextInt(CANT_MAXIMA - CANT_MINIMA + 1) + CANT_MINIMA;

			// Entre 0 y 12000
			for (int i = 0; i < cantNumeros; i++)
				printWriter.print(random.nextInt(ELEM_MAXIMO) + "\n");

			printWriter.close();
			fileWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public int[] leerArchivo() {

		Scanner scanner = null;
		int[] datos = null;
		RandomAccessFile randomAccessFile = null;

		try {

			File archivo = new File(Constante.DIRECCION_ARCHIVOS_IN + this.nombreArchivo + Constante.EXTENSION_IN);
			scanner = new Scanner(archivo);
			scanner.useLocale(Locale.ENGLISH);

			int cantReg = 0;
			randomAccessFile = new RandomAccessFile(archivo, "r");

			while (randomAccessFile.readLine() != null)
				cantReg++;

			datos = new int[cantReg];

			for (int i = 0; i < datos.length; i++)
				datos[i] = scanner.nextInt();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			scanner.close();
			try {
				randomAccessFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return datos;
	}

	public void grabarArchivo(int[] datos) {

		FileWriter fileWriter = null;
		PrintWriter printWriter = null;

		try {

			fileWriter = new FileWriter(
					Constante.DIRECCION_ARCHIVOS_OUT + this.nombreArchivo + Constante.EXTENSION_OUT);
			printWriter = new PrintWriter(fileWriter);

			String[] datosString = { "Máximo", "Mínimo", "Promedio" };
			
			for (int i = 0; i < datosString.length; i++) {
				printWriter.print(SEPARADOR + '\n');
				printWriter.print("| " + String.format("%-9s", datosString[i]) + "|" + String.format("%6d", datos[i]) + " |\n");
			}
			printWriter.print(SEPARADOR + '\n');

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fileWriter != null)
				try {
					fileWriter.close();
					// System.out.println("Se grabo bien");
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}
}
