package unlam.paradigmas.objetos.ej03;

/*Ejercicio 03: Implementar una clase que modele un círculo, del que se desea manipular (obtener y cambiar):

	• Radio
	• Diámetro
	• Perímetro
	• Área

Realizar todas las pruebas que considere convenientes. Se pueden agregar métodos privados*/

public class Circulo {

	private double radio;

	public Circulo(double radio) {
		if (radio > 0)
			this.radio = radio;
		else
			throw new IllegalArgumentException("El radio no puede ser negativo");
	}

	public double getDiametro() {
		return this.radio * 2;
	}

	public double getPerimetro() {
		return 2 * Math.PI * this.radio;
	}

	public double getArea() {
		return Math.PI * Math.pow(this.radio, 2);
	}

	public void cambiarRadio(double nuevoRadio) {
		if (nuevoRadio > 0)
			this.radio = nuevoRadio;
		else
			throw new IllegalArgumentException("El radio no puede ser negativo");
	}

	public void cambiarDiametro(double nuevoDiametro) {
		if (nuevoDiametro > 0)
			cambiarRadio(nuevoDiametro / 2);
		else
			throw new IllegalArgumentException("El diametro no puede ser negativo");
	}

	public void cambiarPerimetro(double nuevoPerimetro) {
		if (nuevoPerimetro > 0)
			cambiarRadio(nuevoPerimetro / (2 * Math.PI));
		else
			throw new IllegalArgumentException("El perimetro no puede ser negativo");
	}

	public void cambiarArea(double nuevaArea) {
		if (nuevaArea > 0)
			cambiarRadio(Math.sqrt(nuevaArea / Math.PI));
		else
			throw new IllegalArgumentException("El area no puede ser negativa");
	}
}
