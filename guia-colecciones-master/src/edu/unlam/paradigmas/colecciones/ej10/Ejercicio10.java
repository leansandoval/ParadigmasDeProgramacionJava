package edu.unlam.paradigmas.colecciones.ej10;

import java.util.Scanner;

public class Ejercicio10 {

	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		Terminal terminal = new Terminal();
		String comando = null;

		do {
			System.out.print("Ingrese un comando ('" + Terminal.DESHACER_ULTIMA_OPERACION + "' para deshacer, '"
					+ Terminal.FINALIZAR_TERMINAL + "' para terminar): ");
			comando = scanner.nextLine();

			if (terminal.ingresoComandoParaDeshacer(comando))
				terminal.desapilarUltimoComando();
			else if (!terminal.ingresoComandoParaSalir(comando))
				terminal.almacernarComando(comando);

		} while (!terminal.ingresoComandoParaSalir(comando));
		
		System.out.println("Se cierra la terminal");
		scanner.close();
	}

}
