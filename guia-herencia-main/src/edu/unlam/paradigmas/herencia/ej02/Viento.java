package edu.unlam.paradigmas.herencia.ej02;

public class Viento extends Instrumento implements Afinable, Lustrable {

	private Material material;

	public Viento(String nombre, String descripcion, Material material) {
		super(nombre, descripcion);
		this.material = material;
	}

	@Override
	public void tocar() {
		System.out.println("Tocar: " + getNombreInstrumento() + " de " + material.getNombreMaterial());
	}

	@Override
	public void afinadoManual() {
		System.out.println("Afinar: " + getNombreInstrumento() + " de forma manual");
	}

	@Override
	public void afinadoAutomatico() {
		System.out.println("Afinar: " + getNombreInstrumento() + " de forma automatica");
	}

	@Override
	public void lustrar() {
		System.out.println("Lustrar: " + getNombreInstrumento());
	}
}
