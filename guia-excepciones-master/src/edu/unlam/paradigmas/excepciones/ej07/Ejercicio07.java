package edu.unlam.paradigmas.excepciones.ej07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Ejercicio07 {
	
	final static public String NOMBRE_PRIMER_ARCHIVO = "PrimerArchivo";
	final static public String EXTENSION_TXT = ".txt";

	/*
	 * La principal diferencia entre usar un bloque try y try-with-resources es que
	 * try-with-resources automáticamente cierra los recursos abiertos en el bloque
	 * de código, mientras que en un bloque try normal tienes que cerrar manualmente
	 * los recursos después de usarlos. La lista de recursos declarados entre
	 * paréntesis en el encabezado del try se cierra automáticamente al finalizar el
	 * bloque try, ya sea que se produzcan excepciones o no. Esto elimina la
	 * necesidad de cerrar manualmente los recursos en un bloque finally.
	 * 
	 * Además de simplificar el código, try-with-resources puede ayudar a prevenir
	 * errores comunes al manipular recursos, como no cerrar un recurso después de
	 * usarlo o cerrar el recurso en el orden incorrecto.
	 */

	public static void main(String[] args) {
		
		try (Scanner scanner1 = new Scanner(new File(NOMBRE_PRIMER_ARCHIVO + EXTENSION_TXT));
				Scanner scanner2 = new Scanner(new File(scanner1.nextLine() + EXTENSION_TXT))) {
			scanner1.useLocale(Locale.ENGLISH);
			scanner2.useLocale(Locale.ENGLISH);
			while (scanner2.hasNextLine())
				System.out.println(scanner2.nextLine());
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
