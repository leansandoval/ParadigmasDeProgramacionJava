package edu.unlam.paradigmas.herencia.ej02;

public class Cuerda extends Instrumento implements Afinable {

	public Cuerda(String nombre, String descripcion) {
		super(nombre, descripcion);
	}

	@Override
	public void tocar() {
		System.out.println("Tocar: " + getNombreInstrumento());
	}

	@Override
	public void afinadoManual() {
		System.out.println("Afinar: " + getNombreInstrumento() + " de forma manual");
	}

	@Override
	public void afinadoAutomatico() {
		System.out.println("Afinar: " + getNombreInstrumento() + " de forma automatica");
	}

}
