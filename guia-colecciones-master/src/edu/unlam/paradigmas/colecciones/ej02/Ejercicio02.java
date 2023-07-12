package edu.unlam.paradigmas.colecciones.ej02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.unlam.paradigmas.colecciones.genericas.GenericasList;

public class Ejercicio02 {

	public static Scanner scanner = new Scanner(System.in);

	public static int mostrarMenuVentas() {
		int opcion;

		do {
			System.out.println("======= MENU VENTAS =======");
			System.out.println("1 - Agregar una nueva venta al registro");
			System.out.println("2 - Buscar una venta por numero de venta");
			System.out.println("3 - Mostrar la lista de ventas realizadas en un dia determinado");
			System.out.println("0 - Salir");
			System.out.print("Ingrese una opcion: ");
			opcion = scanner.nextInt();
			System.out.println("============================");
		} while (opcion < 0 || opcion > 3);

		return opcion;
	}

	public static boolean agregarVentaALista(List<Venta> listaVentas) {
		
		System.out.print("Ingrese el numero de venta: ");
		int numeroDeVenta = scanner.nextInt();

		scanner.nextLine();

		System.out.print("Ingrese la fecha de venta (con formato dd/mm/aaaa): ");
		String fechaVenta = scanner.nextLine();

		// System.out.print("Ingrese la hora de venta (con formato hh:mm:ss): ");
		// String horaVenta = scanner.nextLine();

		System.out.print("Ingrese el nombre del cliente: ");
		String nombreCliente = scanner.nextLine();

		System.out.print("Ingrese el monto de la venta: ");
		double monto = scanner.nextDouble();

		try {
			// Venta venta = new Venta(numeroDeVenta, Fecha.getFechaActual(),
			// Hora.getHoraLocal(), nombreCliente, monto);
			Venta venta = new Venta(numeroDeVenta, Fecha.parseFecha(fechaVenta), Hora.getHoraLocal(), nombreCliente,
					monto);
			listaVentas.add(venta);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void main(String[] args) {

		List<Venta> listaVentas = new ArrayList<Venta>();

		int opcion = mostrarMenuVentas();
		scanner.nextLine();

		while (opcion != 0) {

			switch (opcion) {
			case 1: {
				System.out.println(agregarVentaALista(listaVentas) ? "La venta se agrego al registro"
						: "Hubo un error al agregar la venta");
				break;
			}
			case 2: {

				System.out.print("Ingrese el numero de venta a buscar: ");

				int numeroDeVenta = scanner.nextInt();
				if (numeroDeVenta < 0)
					throw new NumeroDeVentaInvalidoException("El numero de venta no puede ser negativo");

				Venta ventaEncontrada = GenericasList.buscarElementoEnListaPorAtributo(listaVentas,
						venta -> venta.getNumero() == numeroDeVenta);

				System.out.println("La venta con numero " + numeroDeVenta
						+ (ventaEncontrada != null ? " es la siguiente:\n" + ventaEncontrada
								: " no se encuentra en el registro"));

				break;
			}
			case 3: {

				System.out.print("Ingrese la fecha de la venta por la cual desea buscar (con formato dd/mm/aaaa): ");
				String fechaABuscar = scanner.nextLine();
				GenericasList.mostrarListaSegunCriterio(listaVentas,
						venta -> venta.getFecha().equals(Fecha.parseFecha(fechaABuscar)));

				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + opcion);
			}
			opcion = mostrarMenuVentas();
			scanner.nextLine();
		}

		System.out.println("Fin del programa");
		scanner.close();
	}
}
