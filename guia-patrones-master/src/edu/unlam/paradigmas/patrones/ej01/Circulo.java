package edu.unlam.paradigmas.patrones.ej01;

public class Circulo extends FormaGeometrica {

	private double radio;

	public Circulo(double radio) {
		if (radio < 0)
			throw new ValorInvalidoException("El radio debe ser un valor positivo");
		this.radio = radio;
	}

	public double getRadio() {
		return this.radio;
	}

	public void setRadio(double nuevoRadio) {
		if (nuevoRadio < 0)
			throw new ValorInvalidoException("El radio debe ser un valor positivo");
		this.radio = nuevoRadio;
	}

	@Override
	public double getPerimetro() {
		return 2 * Math.PI * this.radio;
	}

	@Override
	public double getArea() {
		return Math.PI * Math.pow(this.radio, 2);
	}

}
