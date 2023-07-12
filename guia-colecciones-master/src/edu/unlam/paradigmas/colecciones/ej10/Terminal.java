package edu.unlam.paradigmas.colecciones.ej10;

import java.util.Stack;

public class Terminal {

	public final static String FINALIZAR_TERMINAL = "exit";
	public final static String DESHACER_ULTIMA_OPERACION = "undo";

	private Stack<String> pilaDeComandos;

	public Terminal() {
		pilaDeComandos = new Stack<>();
	}

	public void almacernarComando(String comando) {
		pilaDeComandos.push(comando);
		System.out.println("Comando agregado: " + comando);
	}

	public void desapilarUltimoComando() {
		System.out.println(!pilaDeComandos.isEmpty() ? "Deshaciendo ultima operacion : " + pilaDeComandos.pop()
				: "No hay comand os para deshacer");
	}
	
	public boolean ingresoComandoParaDeshacer(String comando) {
		return comando.toLowerCase().equals(DESHACER_ULTIMA_OPERACION);
	}
	
	public boolean ingresoComandoParaSalir(String comando) {
		return comando.toLowerCase().equals(FINALIZAR_TERMINAL);
	}
	
}
