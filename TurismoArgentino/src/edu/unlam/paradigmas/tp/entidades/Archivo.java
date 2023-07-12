package edu.unlam.paradigmas.tp.entidades;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

import edu.unlam.paradigmas.tp.enums.TipoDeAtraccion;
import edu.unlam.paradigmas.tp.enums.TipoDePromocion;

public class Archivo {

	public static final String RUTA_ARCHIVOS_ENTRADA = "archivos/in/";
	public static final String RUTA_ARCHIVOS_TESTS_ENTRADA = "archivos/test/in/";
	public static final String RUTA_ARCHIVOS_SALIDA = "archivos/out/";
	public static final String RUTA_ARCHIVOS_TESTS_SALIDA = "archivos/test/out/";

	private String nombre;

	public Archivo(String nombre) {
		this.nombre = nombre;
	}

	public List<Usuario> leerArchivoUsuario(String rutaArchivo) {

		Scanner scanner = null;
		List<Usuario> usuarios = new ArrayList<>();

		try {
			File file = new File(rutaArchivo + this.nombre + ".in");

			scanner = new Scanner(file);
			scanner.useLocale(Locale.ENGLISH);

			scanner.nextLine();

			while (scanner.hasNext())
				usuarios.add(new Usuario(scanner.next(), scanner.nextDouble(), scanner.nextDouble(),
						TipoDeAtraccion.valueOf(scanner.next())));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		return usuarios;
	}

	public Map<String, Atraccion> leerArchivoAtraccion(String rutaArchivo) {

		Scanner scanner = null;
		Map<String, Atraccion> atracciones = new HashMap<>();

		try {
			File file = new File(rutaArchivo + this.nombre + ".in");

			scanner = new Scanner(file);
			scanner.useLocale(Locale.ENGLISH);
			scanner.nextLine();

			while (scanner.hasNext()) {
				String nombreAtraccion = scanner.next();
				atracciones.put(nombreAtraccion, new Atraccion(nombreAtraccion, scanner.nextDouble(),
						scanner.nextDouble(), scanner.nextInt(), TipoDeAtraccion.valueOf(scanner.next())));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		return atracciones;
	}

	public List<Promocion> leerArchivoPromocion(Map<String, Atraccion> atracciones, String rutaArchivo) {

		Scanner scanner = null;
		List<Promocion> promociones = new ArrayList<>();

		try {
			File file = new File(rutaArchivo + this.nombre + ".in");

			scanner = new Scanner(file);
			scanner.useLocale(Locale.ENGLISH);

			scanner.nextLine();

			while (scanner.hasNext()) {

				TipoDeAtraccion tipoDeAtraccion = TipoDeAtraccion.valueOf(scanner.next());
				String[] nombresAtracciones = scanner.next().split(",");

				Atraccion[] atraccionesPromocion = new Atraccion[nombresAtracciones.length];

				for (int i = 0; i < nombresAtracciones.length; i++) {
					Atraccion atraccionObtenida = atracciones.get(nombresAtracciones[i]);
					atraccionesPromocion[i] = atraccionObtenida;
				}

				TipoDePromocion tipoDePromocion = TipoDePromocion.valueOf(scanner.next());

				switch (tipoDePromocion) {
				case ABSOLUTA:
					promociones.add(new Absoluta(tipoDeAtraccion, atraccionesPromocion, tipoDePromocion));
					break;

				case BONIFICADA:
					promociones.add(new Bonificada(tipoDeAtraccion, atraccionesPromocion, tipoDePromocion));
					break;

				case PORCENTUAL:
					promociones.add(new Porcentual(tipoDeAtraccion, atraccionesPromocion, tipoDePromocion));
					break;

				default:
					break;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		return promociones;
	}

	private void grabarTituloDeColumnas(PrintWriter printWriter) {
		printWriter.println(
				String.format("%15s", "Nombre") + String.format("%31s", "Duracion") + String.format("%28s", "Precio"));
		printWriter.println();
	}

	private void grabarAtraccion(PrintWriter printWriter, Atraccion atraccion) {
		printWriter.println("\t\t" + String.format("%-30s", atraccion.getNombre().replaceAll("(?=[A-Z])", " "))
				+ String.format("%-30s", atraccion.getTiempo() + " horas") + "$" + atraccion.getPrecio());
	}

	private void grabarTotalDePromociones(PrintWriter printWriter, Itinerario itinerario) {
		printWriter.println(String.format("%-38s", "- Total de promociones")
				+ String.format("%-30s", itinerario.obtenerDuracionPromociones() + " horas") + "$"
				+ itinerario.obtenerPrecioPromociones());
	}

	private void grabarPromociones(PrintWriter printWriter, Itinerario itinerario) {
		printWriter.println("============================== Promociones adquiridas ==============================");
		printWriter.println();
		int numeroDePromocion = 1;
		if (itinerario.getPromociones().size() > 0) {
			for (Promocion promocion : itinerario.getPromociones()) {
				printWriter.println(String.format("%24s", "Promocion Nro " + numeroDePromocion++));
				printWriter.println();
				grabarTituloDeColumnas(printWriter);
				for (Atraccion atraccion : promocion.getAtracciones())
					grabarAtraccion(printWriter, atraccion);
				printWriter.println();
				printWriter.println();
			}
			grabarTotalDePromociones(printWriter, itinerario);
		} else
			printWriter.println("El usuario no adquirio ninguna promocion");
	}

	private void grabarTotalDeAtracciones(PrintWriter printWriter, Itinerario itinerario) {
		printWriter.println(String.format("%-38s", "- Total de atracciones")
				+ String.format("%-30s", itinerario.obtenerDuracionAtracciones() + " horas") + "$"
				+ itinerario.obtenerPrecioAtracciones());
	}

	private void grabarAtracciones(PrintWriter printWriter, Itinerario itinerario) {
		printWriter.println();
		printWriter.println("============================== Atracciones adquiridas ==============================");
		printWriter.println();
		if (itinerario.getAtracciones().size() > 0) {
			grabarTituloDeColumnas(printWriter);
			for (Atraccion atraccion : itinerario.getAtracciones())
				grabarAtraccion(printWriter, atraccion);
			printWriter.println();
			grabarTotalDeAtracciones(printWriter, itinerario);
		} else
			printWriter.println("El usuario no adquirio ninguna atraccion");
	}

	private void grabarTotalPorUsuario(PrintWriter printWriter, Itinerario itinerario) {
		printWriter.println();
		printWriter
				.println(
						String.format("%-38s", "- Total por usuario:")
								+ String.format("%-30s",
										(itinerario.obtenerDuracionPromociones()
												+ itinerario.obtenerDuracionAtracciones()) + " horas")
								+ "$"
								+ (itinerario.obtenerPrecioPromociones() + itinerario.obtenerPrecioAtracciones()));
	}

	public void crearArchivoItinerario(List<Itinerario> itinerarios, String rutaArchivo) {
		FileWriter file = null;
		PrintWriter printWriter = null;
		try {
			file = new FileWriter(rutaArchivo + this.nombre + ".out");
			printWriter = new PrintWriter(file);
			printWriter.println("========================== Bienvenido a Turismo Argentino ==========================");
			printWriter.println();
			for (Itinerario itinerario : itinerarios) {
				printWriter.println("Usuario: " + itinerario.getUsuario().getNombre());
				printWriter.println();
				grabarPromociones(printWriter, itinerario);
				grabarAtracciones(printWriter, itinerario);
				grabarTotalPorUsuario(printWriter, itinerario);
				printWriter.println();
				printWriter.println(
						"====================================================================================");
				printWriter.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
