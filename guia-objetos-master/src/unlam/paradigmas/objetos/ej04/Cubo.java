package unlam.paradigmas.objetos.ej04;

/*Ejercicio 04: Implementar la clase Cubo a partir de la interfaz proporcionada.

Realizar todas las pruebas que considere convenientes. Se pueden agregar métodos privados.*/

public class Cubo {

	private double longitud;

	public Cubo(double longitudLado) {
		if (longitudLado > 0)
			this.longitud = longitudLado;
		else
			throw new IllegalArgumentException("La longitud de un lado no puede ser 0 o negativo");
	}

	public double obtenerLado() {
		return this.longitud;
	}

	public void cambiarLado(double nuevaLongitud) {
		if (nuevaLongitud > 0)
			this.longitud = nuevaLongitud;
		else
			throw new IllegalArgumentException("La longitud de un lado no puede ser 0 o negativo");
	}

	public double obtenerAreaCara() {
		return Math.pow(this.longitud, 2);
	}

	public void cambiarAreaCara(double nuevaAreaCara) {
		if (nuevaAreaCara > 0)
			cambiarLado(Math.sqrt(nuevaAreaCara));
		else
			throw new IllegalArgumentException("El area de la cara de un lado no puede ser 0 o negativo");
	}

	public double obtenerVolumen() {
		return Math.pow(this.longitud, 3);
	}

	public void cambiarVolumen(double nuevoVolumen) {
		if (nuevoVolumen > 0)
			cambiarLado(Math.cbrt(nuevoVolumen));
		else
			throw new IllegalArgumentException("El volumen de un cubo no puede ser 0 o negativo");
	}
}
