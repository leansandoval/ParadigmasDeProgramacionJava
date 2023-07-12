package edu.unlam.paradigmas.patrones.ej01;

public class Rectangulo extends FormaGeometrica {

	private double base;
	private double altura;

	public Rectangulo(double base, double altura) {
		if (base < 0 || altura < 0)
			throw new ValorInvalidoException("Los atributos deben tener un valor positivo");
		this.base = base;
		this.altura = altura;
	}

	public double getBase() {
		return this.base;
	}

	public double getAltura() {
		return this.altura;
	}

	public void setBase(double nuevaBase) {
		if (nuevaBase < 0)
			throw new ValorInvalidoException("La base debe ser un valor positivo");
		this.base = nuevaBase;
	}

	public void setAltura(double nuevaAltura) {
		if (nuevaAltura < 0)
			throw new ValorInvalidoException("La altura debe ser un valor positivo");
		this.altura = nuevaAltura;
	}

	@Override
	public double getArea() {
		return this.base * this.altura;
	}

	@Override
	public double getPerimetro() {
		return 2 * (this.base + this.altura);
	}

}
