package edu.unlam.paradigmas.tp.entidades;

import java.util.Objects;

import edu.unlam.paradigmas.tp.enums.TipoDeAtraccion;

public class Atraccion {

	private final String nombre;
	private final double precio;
	private final double tiempo;
	private int cupoDiario;
	private final TipoDeAtraccion tipo;
	private boolean disponibilidad;

	public Atraccion(String nombre, double precio, double tiempo, int cupoDiario, TipoDeAtraccion tipo) {
		this.nombre = nombre;
		this.precio = precio;
		this.tiempo = tiempo;
		this.cupoDiario = cupoDiario;
		this.tipo = tipo;
		this.disponibilidad = true;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public double getTiempo() {
		return tiempo;
	}

	public int getCupoDiario() {
		return cupoDiario;
	}

	public TipoDeAtraccion getTipo() {
		return tipo;
	}

	public boolean getDisponibilidad() {
		return disponibilidad;
	}

	public void setCupoDiario(int cupoDiario) {
		this.cupoDiario = cupoDiario;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public static String formatearTipoAtraccion(TipoDeAtraccion tipoDeAtraccion) {
		String tipoDeAtraccionString = tipoDeAtraccion.toString();
		if (tipoDeAtraccionString == null || tipoDeAtraccionString.isEmpty()) {
			return tipoDeAtraccionString;
		}
		String primeraLetra = tipoDeAtraccionString.substring(0, 1).toUpperCase();
		String restoPalabra = tipoDeAtraccionString.substring(1).toLowerCase();
		return primeraLetra + restoPalabra;
	}

	private static String separarPalabrasPorEspacios(String cadena) {
		return cadena.replaceAll("(?=[A-Z])", " ");
	}

	@Override
	public String toString() {
		return "Atraccion \n" + String.format("%-24s", "-Tipo:") + formatearTipoAtraccion(tipo) + "\n"
				+ String.format("%-23s", "-Nombre:") + separarPalabrasPorEspacios(nombre) + "\n"
				+ String.format("%-24s", "-Precio:") + "$" + precio + "\n" + String.format("%-24s", "-Duracion:")
				+ tiempo + " horas\n";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cupoDiario, nombre, precio, tiempo, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atraccion other = (Atraccion) obj;
		return cupoDiario == other.cupoDiario && Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio)
				&& Double.doubleToLongBits(tiempo) == Double.doubleToLongBits(other.tiempo) && tipo == other.tipo;
	}

}
