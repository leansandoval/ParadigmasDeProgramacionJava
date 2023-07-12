package edu.unlam.paradigmas.colecciones.ej01;

import java.util.Objects;

public class Paquete {

	private final int numeroSeguimiento;
	private final String direccionOrigen;
	private String direccionDestino;
	private final double peso;

	public Paquete(int numeroSeguimiento, String direccionOrigen, String direccionDestino, double peso) {

		if (numeroSeguimiento < 0)
			throw new NumeroDeSeguimientoInvalidoException("El numero de seguimiento es invalido");
		if (direccionOrigen == null || direccionDestino == null)
			throw new DireccionInvalidaException("La/s direccion/es no puede/n ser nula/s");
		if (peso < 0)
			throw new PesoInvalidoException("El peso del paquete es invalido");

		this.numeroSeguimiento = numeroSeguimiento;
		this.direccionOrigen = direccionOrigen;
		this.direccionDestino = direccionDestino;
		this.peso = peso;
	}

	@Override
	public int hashCode() {
		return Objects.hash(direccionDestino, direccionOrigen, numeroSeguimiento, peso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paquete other = (Paquete) obj;
		return Objects.equals(direccionDestino, other.direccionDestino)
				&& Objects.equals(direccionOrigen, other.direccionOrigen)
				&& numeroSeguimiento == other.numeroSeguimiento
				&& Double.doubleToLongBits(peso) == Double.doubleToLongBits(other.peso);
	}

	@Override
	public String toString() {
		return "Numero de seguimiento = " + numeroSeguimiento + ", Direccion origen = " + direccionOrigen
				+ ", Direccion destino = " + direccionDestino + ", Peso = " + peso;
	}

	public void setDireccionDestino(String direccionDestino) {
		if (direccionDestino == null)
			throw new DireccionInvalidaException("La direccion de destino no puede ser nula");
		this.direccionDestino = direccionDestino;
	}

	public int getNumeroSeguimiento() {
		return numeroSeguimiento;
	}

	public String getDireccionOrigen() {
		return direccionOrigen;
	}

	public String getDireccionDestino() {
		return direccionDestino;
	}

	public double getPeso() {
		return peso;
	}
}
