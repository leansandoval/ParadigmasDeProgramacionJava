package edu.unlam.paradigmas.colecciones.ej05;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio05 {

	public static Scanner scanner = new Scanner(System.in);

	public static int menuVentas() {
		int opcion;
		do {
			System.out.println("======= MENU VENTAS =======");
			System.out.println("1 - Agregar/Modificar una venta");
			System.out.println("2 - Mostrar ventas segun mes");
			System.out.println("0 - Salir");
			System.out.print("Ingrese una opcion: ");
			opcion = scanner.nextInt();
			System.out.println("===========================");
		} while (opcion < 0 || opcion > 2);
		return opcion;
	}

	public static boolean agregarOModificarVentaEnMapa(Map<Integer, Double> mapaVentasMensuales) {

		System.out.print("Ingrese el mes de la venta realizada: ");
		int mes = scanner.nextInt();

		System.out.print("Ingrese el monto de la venta del mes " + mes + " : ");
		double monto = scanner.nextDouble();

		if (mes < 1 || mes > 12 || monto < 0)
			return false;

		mapaVentasMensuales.put(mes,
				mapaVentasMensuales.containsKey(mes) ? mapaVentasMensuales.get(mes) + monto : monto);

		return true;
	}

	public static void mostrarMontoDeVentasSegunMes(Map<Integer, Double> mapaVentasMensuales, int mes) {
		System.out.println(
				mapaVentasMensuales.containsKey(mes) ? "Ventas del mes " + mes + " : " + mapaVentasMensuales.get(mes)
						: "El mes ingresado no se encuentra en el mapa");
	}

	public static void main(String[] args) {

		Map<Integer, Double> mapaVentasMensuales = new HashMap<Integer, Double>();

		int opcion = menuVentas();

		while (opcion != 0) {
			switch (opcion) {
			case 1: {
				System.out.println(
						agregarOModificarVentaEnMapa(mapaVentasMensuales) ? "La venta se agrego/modifico con exito"
								: "Hubo un error al agregar la venta");
				break;
			}
			case 2: {
				System.out.print("Ingrese el mes que desea ver el monto de ventas: ");
				int mes = scanner.nextInt();
				mostrarMontoDeVentasSegunMes(mapaVentasMensuales, mes);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + opcion);
			}

			opcion = menuVentas();
		}
		System.out.println("Fin del programa");
		scanner.close();
	}

}
