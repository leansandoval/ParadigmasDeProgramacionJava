package edu.unlam.paradigmas.colecciones.ej07;

import java.util.LinkedList;
import java.util.Queue;

import edu.unlam.paradigmas.colecciones.ej02.Fecha;

public class Ejercicio07 {

	private static Queue<Tarea> colaTareas = new LinkedList<>();
	
	public static void almacenarTareas(Tarea[] tareas) {
		for (Tarea tarea : tareas) {
			colaTareas.add(tarea);
		}
	}
	
	public static void procesarTareas() {
		while (!colaTareas.isEmpty()) {
			System.out.println("Procesando tarea: " + colaTareas.poll()); 
		}
	}

	public static void main(String[] args) {

		Tarea[] tareas = { new Tarea("Lavar los platos", new Fecha(22, 10, 2023)),
				new Tarea("Cocinar para el almuerzo", new Fecha(03, 07, 2023)),
				new Tarea("Planchar la ropa", new Fecha(14, 05, 2022)),
				new Tarea("Realizar tramite en el banco", new Fecha(20, 9, 2023)),
				new Tarea("Comprar barbijos", new Fecha(2, 12, 2020)) };
		
		almacenarTareas(tareas);
		
		procesarTareas();
	}

}
