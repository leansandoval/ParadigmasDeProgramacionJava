package edu.unlam.paradigmas.herencia.ej02;

public abstract class Instrumento {

	private String nombre;
	private String descripcion;

	public Instrumento(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public abstract void tocar();

	public String getNombreInstrumento() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}
}
