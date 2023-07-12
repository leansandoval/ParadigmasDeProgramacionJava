package edu.unlam.paradigmas.herencia.ej01;

import java.util.Objects;
import java.time.*;
import java.time.format.*;

public class Fecha implements Comparable<Fecha> {

	final private int dia;
	final private int mes;
	final private int anio;

	private static boolean esBisiesto(int anio) {
		return anio % 4 == 0 && (anio % 100 != 0 || anio % 400 == 0);
	}

	private static int diasDelMes(int mes, int anio) {
		if (mes == 2)
			return esBisiesto(anio) ? 29 : 28;
		return (mes == 4 || mes == 6 || mes == 9 || mes == 11) ? 30 : 31;
	}

	private static boolean fechaValida(int dia, int mes, int anio) {
		if (mes < 1 || mes > 12)
			return false;
		return dia < 1 || dia > diasDelMes(mes, anio) ? false : true;
	}

	public Fecha(int dia, int mes, int anio) {
		if (!fechaValida(dia, mes, anio))
			throw new FechaInvalidaException("Fecha Invalida");
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
	}

	public int getDia() {
		return dia;
	}

	public int getMes() {
		return mes;
	}

	public int getAnio() {
		return anio;
	}

	public static Fecha parseFecha(String fechaString) {

		String[] partes = fechaString.split("/");
		if (partes.length != 3)
			throw new FechaInvalidaException("Formato de fecha inválido: " + fechaString);

		int dia = Integer.parseInt(partes[0]);
		int mes = Integer.parseInt(partes[1]);
		int anio = Integer.parseInt(partes[2]);

		return new Fecha(dia, mes, anio);

	}

	public static Fecha getFechaActual() {
		LocalDate fechaActual = LocalDate.now();
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String fechaActualString = fechaActual.format(formatoFecha);
		return parseFecha(fechaActualString);
	}

	@Override
	public int hashCode() {
		return Objects.hash(anio, dia, mes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fecha other = (Fecha) obj;
		return anio == other.anio && dia == other.dia && mes == other.mes;
	}

	@Override
	public String toString() {
		return String.format("%02d", this.dia) + "/" + String.format("%02d", this.mes) + "/" + String.format("%04d", this.anio);
	}

	@Override
	public int compareTo(Fecha otraFecha) {
		String fechaActualString = String.format("%04d%02d%02d", this.anio, this.mes, this.dia);
		String otraFechaString = String.format("%04d%02d%02d", otraFecha.anio, otraFecha.mes, otraFecha.dia);
		return fechaActualString.compareTo(otraFechaString);
	}

}
