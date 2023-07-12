package edu.unlam.paradigmas.patrones.ej01;

public class Cuadrado extends FormaGeometrica {

	private double lado;

	public Cuadrado(double lado) {
		if (lado < 0)
			throw new ValorInvalidoException("El lado debe ser un valor positivo");
		this.lado = lado;
	}

	public double getLado() {
		return this.lado;
	}

	public void setLado(double nuevoLado) {
		if (nuevoLado < 0)
			throw new ValorInvalidoException("El lado debe ser un valor positivo");
		this.lado = nuevoLado;
	}

	@Override
	public double getArea() {
		return Math.pow(this.lado, 2);
	}

	@Override
	public double getPerimetro() {
		return 4 * this.lado;
	}

}
