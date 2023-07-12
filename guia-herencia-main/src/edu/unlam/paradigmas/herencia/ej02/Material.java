package edu.unlam.paradigmas.herencia.ej02;

public abstract class Material {

	private String nombre;

	public Material(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreMaterial() {
		return this.nombre;
	}
}
