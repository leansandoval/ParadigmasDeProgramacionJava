package edu.unlam.paradigmas.colecciones.ej02;

import java.time.LocalTime;
import java.time.format.*;

public class Hora {

	private final int hora;
	private final int minuto;
	private final int segundo;

	private static boolean horaValida(int hora) {
		return hora >= 0 && hora < 24;
	}

	private static boolean minutoValido(int minuto) {
		return minuto >= 0 && minuto < 60;
	}

	private static boolean segundoValido(int segundo) {
		return segundo >= 0 && segundo < 60;
	}

	public Hora(int hora, int minuto, int segundo) {
		if (!horaValida(hora) || !minutoValido(minuto) || !segundoValido(segundo))
			throw new IllegalArgumentException("Hora invalida");
		this.segundo = segundo;
		this.minuto = minuto;
		this.hora = hora;
	}

	public static Hora parseHora(String horaString) {
		String[] partes = horaString.split(":");
		if (partes.length != 3) {
			throw new IllegalArgumentException("Formato de hora inválido: " + horaString);
		}
		int horas = Integer.parseInt(partes[0]);
		int minutos = Integer.parseInt(partes[1]);
		int segundos = Integer.parseInt(partes[2]);
		return new Hora(horas, minutos, segundos);
	}

	public static Hora getHoraLocal() {
		LocalTime horaActual = LocalTime.now();
		DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
		String horaActualString = horaActual.format(formatoHora);
		return parseHora(horaActualString);
	}

	@Override
	public String toString() {
		return this.hora + ":" + this.minuto + ":" + this.segundo;
	}

}
