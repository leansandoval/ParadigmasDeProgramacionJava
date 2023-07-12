package edu.unlam.paradigmas.herencia.ej02;

public class Percusion extends Instrumento implements Lustrable {

	public Percusion(String nombre, String descripcion) {
		super(nombre, descripcion);
	}

	@Override
	public void tocar() {
		System.out.println("Tocar: " + getNombreInstrumento());
	}

	@Override
	public void lustrar() {
		System.out.println("Lustrar: " + getNombreInstrumento());
	}
}
