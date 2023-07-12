package edu.unlam.paradigmas.colecciones.ej06;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio06 {

	public static Scanner scanner = new Scanner(System.in);

	public static final int NOTA_MAX = 10;
	public static final int NOTA_MIN = 2;

	public static boolean agregarOModificarEstudiante(Map<String, List<Integer>> mapaEstudiantes) {

		System.out.print("Ingrese el nombre del estudiante: ");
		String nombre = scanner.nextLine();

		System.out.print("Ingrese la cantidad de notas que desea agregar al estudiante: ");
		int cantidadNotas = scanner.nextInt();

		if (nombre == null || cantidadNotas < 1)
			return false;

		List<Integer> notasAAgregar = new ArrayList<>();

		for (int i = 0; i < cantidadNotas; i++) {
			System.out.print("Ingrese la nota " + (i + 1) + ": ");
			int nota = scanner.nextInt();
			if (nota < NOTA_MIN || nota > NOTA_MAX)
				throw new IllegalArgumentException("La nota debe ser dentro de los limites establecidos");
			notasAAgregar.add(nota);
		}

		if (mapaEstudiantes.containsKey(nombre)) {
			List<Integer> notasExistentes = mapaEstudiantes.get(nombre);
			notasExistentes.addAll(notasAAgregar); // Notas actualizadas
			mapaEstudiantes.put(nombre, notasExistentes);
		} else
			mapaEstudiantes.put(nombre, notasAAgregar);

		return true;
	}

	private static double obtenerPromedioDeEstudiante(Map<String, List<Integer>> mapaEstudiantes, String nombreAlumno) {
		
		List<Integer> notasEstudiante = mapaEstudiantes.get(nombreAlumno);
		
		int sumaNotas = 0;
		for (int i = 0; i < notasEstudiante.size(); i++)
			sumaNotas += notasEstudiante.get(i);
		
		return (double) sumaNotas / notasEstudiante.size();
	}

	public static void mostrarPromedioDeEstudiante(Map<String, List<Integer>> mapaEstudiantes, String nombreAlumno) {
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		System.out.println(mapaEstudiantes.isEmpty() ? "El mapa se encuentra vacio"
				: "El alumno " + nombreAlumno + (!mapaEstudiantes.containsKey(nombreAlumno)
						? " no se encuentra en el mapa"
						: " tiene como promedio "
								+ decimalFormat.format(obtenerPromedioDeEstudiante(mapaEstudiantes, nombreAlumno))));
	}

	public static boolean agregarOModificarPromedio(Map<Double, List<String>> mapaPromedios, double promedio,
			String nuevoEstudiante) {

		List<String> nuevoEstudianteLista = new ArrayList<>();
		nuevoEstudianteLista.add(nuevoEstudiante);
		
		if (mapaPromedios.containsKey(promedio)) {
			List<String> estudiantesExistentes = mapaPromedios.get(promedio);
			estudiantesExistentes.addAll(nuevoEstudianteLista);
			mapaPromedios.put(promedio, estudiantesExistentes);
		} else
			mapaPromedios.put(promedio, nuevoEstudianteLista);

		return true;
	}

	public static Map<Double, List<String>> invertirMapa(Map<String, List<Integer>> mapaEstudiantes) {

		if (mapaEstudiantes.isEmpty())
			return null;

		Map<Double, List<String>> mapaPromedios = new HashMap<>();

		for (String estudiante : mapaEstudiantes.keySet())
			agregarOModificarPromedio(mapaPromedios, obtenerPromedioDeEstudiante(mapaEstudiantes, estudiante),
					estudiante);

		return mapaPromedios;
	}

	public static void mostrarMapaPromedios(Map<Double, List<String>> mapaPromedios) {

		for (Map.Entry<Double, List<String>> entry : mapaPromedios.entrySet()) {
			double promedio = entry.getKey();
			List<String> estudiantes = entry.getValue();
			DecimalFormat decimalFormat = new DecimalFormat("#.##");
			System.out.print(String.format("%-20s", "Promedio : " + decimalFormat.format(promedio))
					+ String.format("%10s", "Estudiantes: "));
			for (int i = 0; i < estudiantes.size(); i++)
				System.out.print(estudiantes.get(i) + (i < estudiantes.size() - 1 ? ", " : "."));
			System.out.println();
		}

	}

	public static int menuEstudiantes() {
		int opcion;
		do {
			System.out.println("============ MENU ESTUDIANTES ============");
			System.out.println("1 - Agregar o modificar un estudiante");
			System.out.println("2 - Mostrar promedio de notas por estudiante");
			System.out.println("3 - Invertir mapa, armando un mapa de promedios de los estudiantes");
			System.out.println("0 - Salir del programa");
			System.out.print("Seleccione una opcion: ");
			opcion = scanner.nextInt();
			System.out.println("====================================");
		} while (opcion < 0 || opcion > 3);
		return opcion;
	}

	public static void main(String[] args) {

		Map<String, List<Integer>> mapaEstudiantes = new HashMap<>();

		int opcion = menuEstudiantes();
		scanner.nextLine();

		while (opcion != 0) {

			switch (opcion) {
			case 1: {
				System.out.println(agregarOModificarEstudiante(mapaEstudiantes) ? "El alumno fue agregado al mapa"
						: "Hubo un error al agregar al alumno");
				break;
			}
			case 2: {
				System.out.print("Ingrese el estudiante por el cual desea saber el promedio: ");
				String estudiante = scanner.nextLine();
				mostrarPromedioDeEstudiante(mapaEstudiantes, estudiante);
				break;
			}
			case 3: {
				Map<Double, List<String>> mapaPromedios = invertirMapa(mapaEstudiantes);
				mostrarMapaPromedios(mapaPromedios);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + opcion);
			}
			opcion = menuEstudiantes();
			scanner.nextLine();
		}
		System.out.println("Fin del programa");
		scanner.close();
	}

}
