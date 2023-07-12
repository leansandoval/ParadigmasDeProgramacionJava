package unlam.paradigmas.objetos.ej01;

/*Ejercicio 01: Implementar la clase Nota para cumplir con la interfaz proporcionada.

Agregar a la clase Nota el método:

	pre : nuevoValor está comprendido entre 0 y 10.
	post: modifica el valor numérico de la Nota, cambiándolo
		por nuevoValor, siempre y cuando nuevoValor sea superior al
		valor numérico actual de la Nota.

	public void recuperar(int nuevoValor) { }

Realizar todas las pruebas que considere convenientes. Se pueden agregar métodos privados.*/

public class Nota {

	public static final int VALOR_APROBADO = 4;
	public static final int NOTA_MINIMA = 0;
	public static final int NOTA_MAXIMA = 10;

	private int valor;

	public Nota(int valorInicial) {
		if (valorInicial >= NOTA_MINIMA && valorInicial <= NOTA_MAXIMA)
			this.valor = valorInicial;
		else
			throw new IllegalArgumentException("El valor no esta comprendido entre los rangos permitidos");
	}

	public int obtenerValor() {
		return this.valor;
	}

	public boolean aprobado() {
		return this.valor >= VALOR_APROBADO;
	}

	public boolean desaprobado() {
		return !this.aprobado();
	}

	public void recuperar(int nuevoValor) {
		if (nuevoValor >= NOTA_MINIMA && nuevoValor <= NOTA_MAXIMA)
			if (nuevoValor > this.valor)
				this.valor = nuevoValor;
			else
				throw new IllegalArgumentException("El nuevo valor no supera al valor numero actual de la nota");
		else
			throw new IllegalArgumentException("El valor no esta comprendido entre los rangos permitidos");
	}

}
