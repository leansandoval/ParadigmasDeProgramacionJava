package edu.unlam.paradigmas.colecciones.ej01;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import edu.unlam.paradigmas.colecciones.genericas.GenericasList;

public class Main {

	public static Scanner scanner = new Scanner(System.in);
	
	/*
	 * Cada objeto Scanner que se utilice para leer desde System.in accederá al mismo
	 * flujo de entrada estándar. Es decir, los objetos Scanner leerán los datos de
	 * entrada en el orden en que se introducen por la entrada estándar, sin
	 * importar cuál de ellos se use para realizar la lectura.
	 */

	public static int mostrarMenuPaquetes() {

		int opcion;

		do {
			System.out.println("======= MENU PAQUETES =======");
			System.out.println("1 - Agregar un nuevo paquete");
			System.out.println("2 - Buscar un paquete por numero de seguimiento");
			System.out.println("3 - Mostrar la lista de paquetes que superan un peso determinado");
			System.out.println("0 - Salir");
			System.out.print("Ingrese una opcion: ");
			opcion = scanner.nextInt();
			System.out.println("============================");
		} while (opcion < 0 || opcion > 3);

		return opcion;
	}
	
	public static boolean agregarPaqueteALista(List<Paquete> listaPaquetes) {

		System.out.print("Ingrese el numero de seguimiento: ");
		int numeroDeSeguimiento = scanner.nextInt();

		scanner.nextLine(); // Limpiar el buffer de entrada

		System.out.print("Ingrese la direccion de origen: ");
		String direccionOrigen = scanner.nextLine();

		System.out.print("Ingrese la direccion de destino: ");
		String direccionDestino = scanner.nextLine();

		System.out.print("Ingrese el peso: ");
		double peso = scanner.nextDouble();

		try {
			Paquete paquete = new Paquete(numeroDeSeguimiento, direccionOrigen, direccionDestino, peso);
			listaPaquetes.add(paquete);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public static void main(String[] args) {

		List<Paquete> listaPaquetes = new LinkedList<Paquete>();

		int opcion = mostrarMenuPaquetes();

		while (opcion != 0) {

			switch (opcion) {
			case 1: {
				System.out.println(agregarPaqueteALista(listaPaquetes) ? "El paquete se agrego a la lista"
						: "Hubo un error al agregar el paquete");
				break;
			}
			case 2: {
				
				System.out.print("Ingrese el numero de seguimiento a buscar en la lista: ");
				
				int numeroDeSeguimiento = scanner.nextInt();
				if (numeroDeSeguimiento < 0)
					throw new NumeroDeSeguimientoInvalidoException("El numero de seguimiento es invalido");
				
				Paquete paqueteEncontrado = GenericasList.buscarElementoEnListaPorAtributo(listaPaquetes, paquete -> paquete.getNumeroSeguimiento() == numeroDeSeguimiento);
				
				System.out.println("El paquete con numero de seguimiento " + numeroDeSeguimiento
						+ (paqueteEncontrado != null ? " es el siguiente:\n" + paqueteEncontrado : " no se encuentra en la lista"));
				
				break;
			}
			case 3: {
				System.out.print("Ingrese el peso por el cual desea buscar: ");
				double pesoDeterminado = scanner.nextDouble();
				GenericasList.mostrarListaSegunCriterio(listaPaquetes, paquete -> paquete.getPeso() > pesoDeterminado);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + opcion);
			}

			opcion = mostrarMenuPaquetes();
		}
		System.out.println("Fin del programa");
		scanner.close();
	}
	
}
