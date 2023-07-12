package edu.unlam.paradigmas.basicas.ej01;

import java.util.Objects;

public class Rango implements Comparable<Rango> {

	/*
	 * implements Comparable<Rango> = Interfaz en Java que se utiliza para
	 * especificar que una clase puede ser comparada con otra clase del mismo tipo
	 * utilizando el metodo compareTo. El parametro <> especifica el tipo de dato
	 * que se puede comparar
	 */

	// 10.Un rango es inmutable: No puede modificarse una vez creado.

	private final double valorIzquierda;
	private final double valorDerecha;
	private final boolean izquierdaAbierta; // true = ( -- false = [
	private final boolean derechaAbierta; // true = ) -- false = ]

	/*
	 * 2.Dado que tener un constructor tan complejo puede ser perjudicial,
	 * implementar cuatro métodos estáticos que permitan la creación de estas
	 * combinaciones.
	 */

	public static Rango cerrado(double valorIzquierda, double valorDerecha) {
		return new Rango(valorIzquierda, valorDerecha, false, false);
	}

	public static Rango abierto(double valorIzquierda, double valorDerecha) {
		return new Rango(valorIzquierda, valorDerecha, true, true);
	}

	public static Rango abiertoIzquierda(double valorIzquierda, double valorDerecha) {
		return new Rango(valorIzquierda, valorDerecha, true, false);
	}

	public static Rango abiertoDerecha(double valorIzquierda, double valorDerecha) {
		return new Rango(valorIzquierda, valorDerecha, false, true);
	}

	/*
	 * 3.Teniendo los métodos estáticos, será buena idea hacer el constructor
	 * privado, ya que sólamente se accederá a él por los métodos estáticos.
	 */

	private Rango(double valorIzquierda, double valorDerecha, boolean izquierdaAbierta, boolean derechaAbierta) {
		if (valorIzquierda <= valorDerecha) {
			this.valorIzquierda = valorIzquierda;
			this.valorDerecha = valorDerecha;
			this.izquierdaAbierta = izquierdaAbierta;
			this.derechaAbierta = derechaAbierta;
		} else
			throw new IllegalArgumentException("El final del rango no puede ser menor que el inicio");
	}

	// 4.Se debe poder consultar si un número está dentro de un rango.

	public boolean numeroDentroDeRango(double numero) {

		if (this.izquierdaAbierta && numero <= this.valorIzquierda)
			return false;

		if (this.derechaAbierta && numero >= this.valorDerecha)
			return false;

		return numero >= this.valorIzquierda && numero <= this.valorDerecha;
	}

	// 5.Se debe poder consultar si un rango está dentro de un rango.

	public boolean rangoDentroDeRango(Rango otro) {

		// Caso []
		boolean dentro = this.valorIzquierda >= otro.valorIzquierda && this.valorDerecha <= otro.valorDerecha;

		// Caso (]
		if (otro.izquierdaAbierta)
			dentro = dentro && this.valorIzquierda > otro.valorIzquierda;

		// Caso [)
		if (otro.derechaAbierta)
			dentro = dentro && this.valorDerecha < otro.valorDerecha;

		return dentro;
	}

	// 6.Se debe poder consultar si hay intersección entre dos rangos.

	public boolean intersecta(Rango otroRango) {

		// No hay interseccion por valores. Ejemplo: [1, 2] y [4, 5]
		if (this.valorDerecha < otroRango.valorIzquierda || this.valorIzquierda > otroRango.valorDerecha)
			return false;

		// Caso en el que son iguales los limites pero las llaves son abiertas. Ejemplo:
		// [1, 2) y (2, 3]
		if (this.valorDerecha == otroRango.valorIzquierda && (this.derechaAbierta || otroRango.izquierdaAbierta))
			return false;

		// Caso en el que son iguales los limites pero las llaves son abiertas. Ejemplo:
		// (1, 2] y (-2, 1)
		if (this.valorIzquierda == otroRango.valorDerecha && (this.izquierdaAbierta || otroRango.derechaAbierta))
			return false;

		return true;
	}

	// 7.Se debe poder comparar por igualdad los rangos.

	@Override
	public int hashCode() {
		return Objects.hash(derechaAbierta, izquierdaAbierta, valorDerecha, valorIzquierda);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Rango other = (Rango) obj;
		return derechaAbierta == other.derechaAbierta && izquierdaAbierta == other.izquierdaAbierta
				&& Double.doubleToLongBits(valorDerecha) == Double.doubleToLongBits(other.valorDerecha)
				&& Double.doubleToLongBits(valorIzquierda) == Double.doubleToLongBits(other.valorIzquierda);
	}

	/*
	 * 8.Se debe poder ordenar rangos mediante su inicio. Si empatan, se resuelve el
	 * empate por su fin. Si empatan, los rangos cerrados irán primero que los
	 * abiertos.
	 */

	@Override
	public int compareTo(Rango otro) {

		int compareIzquierda = Double.compare(this.valorIzquierda, otro.valorIzquierda);
		if (compareIzquierda != 0)
			return compareIzquierda;

		int compareDerecha = Double.compare(this.valorDerecha, otro.valorDerecha);
		if (compareIzquierda != 0)
			return compareDerecha;

		if (this.izquierdaAbierta != otro.izquierdaAbierta) // Si no tienen la misma llave
			return this.izquierdaAbierta ? 1 : -1;

		if (this.derechaAbierta != otro.derechaAbierta)
			return this.derechaAbierta ? 1 : -1;

		return 0;
	}

	// 9.Se debe poder imprimir un rango en formato cadena de caracteres.

	@Override
	public String toString() {
		String llaveIzquierda = this.izquierdaAbierta ? "(" : "[";
		String llaveDerecha = this.derechaAbierta ? ")" : "]";
		return llaveIzquierda + this.valorIzquierda + ", " + this.valorDerecha + llaveDerecha;
	}

	/*
	 * 11.Proporcionar un método estático que devuelva un rango que abarque a todos
	 * los otros rangos.
	 */

	public static Rango abarcarRangos(Rango[] rangos) {

		double minLimiteIzquierda = rangos[0].valorIzquierda;
		double maxLimiteDerecha = rangos[0].valorDerecha;

		for (int i = 1; i < rangos.length; i++) {

			if (rangos[i].valorIzquierda < minLimiteIzquierda)
				minLimiteIzquierda = rangos[i].valorIzquierda;

			if (rangos[i].valorDerecha > maxLimiteDerecha)
				maxLimiteDerecha = rangos[i].valorDerecha;
		}

		return new Rango(minLimiteIzquierda, maxLimiteDerecha, false, false);
	}

	/*
	 * 12.Se deben poder sumar rangos, utilizando el inicio del primero y el fin del
	 * segundo.
	 */

	public Rango sumarRangos(Rango otro) {
		if (intersecta(otro)) {
			return compareTo(otro) < 0
					? new Rango(this.valorIzquierda, otro.valorDerecha, this.izquierdaAbierta, otro.derechaAbierta)
					: new Rango(otro.valorIzquierda, this.valorDerecha, otro.izquierdaAbierta, this.derechaAbierta);
		} else
			throw new IllegalArgumentException("No hay interseccion para sumar los rangos");

	}

	/*
	 * 13.Se debe poder calcular un rango intersección, que en caso de no existir
	 * tal intersección retornará (0.0, 0.0)
	 */

	public Rango obtenerRangoInterseccion(Rango otro) {
		if (intersecta(otro)) {
			return compareTo(otro) < 0
					? new Rango(otro.valorIzquierda, this.valorDerecha, otro.izquierdaAbierta, this.derechaAbierta)
					: new Rango(this.valorDerecha, otro.valorIzquierda, otro.derechaAbierta, otro.izquierdaAbierta);
		}
		return new Rango(0, 0, true, true);
	}

	// 14.Se debe poder desplazar un rango con un número escalar.

	public Rango desplazarRango(double numero) {
		return new Rango(this.valorIzquierda + numero, this.valorDerecha + numero, this.izquierdaAbierta,
				this.derechaAbierta);
	}

}
