package unlam.paradigmas.objetos.ej06;

public class Cerradura {

	int claveDeApertura, cantidadDeAperturasExitosas, cantidadDeAperturasFallidas;
	int cantidadDeFallosConsecutivosActualmente, cantidadDeFallosConsecutivosQueLaBloquean;
	boolean cerraduraAbierta; // true = Abierto false = Cerrada
	boolean estadoBloqueo; // true = Bloqueada false = Desbloqueada

	public Cerradura(int claveDeApertura, int cantidadDeFallosConsecutivosQueLaBloquean) {
		if (claveDeApertura >= 10000000 && claveDeApertura <= 99999999
				&& cantidadDeFallosConsecutivosQueLaBloquean > 0) {
			this.claveDeApertura = claveDeApertura;
			this.cantidadDeAperturasExitosas = this.cantidadDeAperturasFallidas = cantidadDeFallosConsecutivosActualmente = 0;
			this.cantidadDeFallosConsecutivosQueLaBloquean = cantidadDeFallosConsecutivosQueLaBloquean;
			this.cerraduraAbierta = this.estadoBloqueo = false;
		} else
			throw new IllegalArgumentException(
					"La clave y la cantidad de fallos consecutivos deben encontrarse en el rango permitido");
	}

	public boolean abrir(int clave) {
		if (this.estadoBloqueo == false && this.cerraduraAbierta == false)
			if (this.claveDeApertura == clave) {
				this.cerraduraAbierta = true;
				this.cantidadDeAperturasExitosas++;
				this.cantidadDeFallosConsecutivosActualmente = 0;
				return true;
			} else {
				this.cantidadDeAperturasFallidas++;
				this.cantidadDeFallosConsecutivosActualmente++;
				if (cantidadDeFallosConsecutivosActualmente == cantidadDeFallosConsecutivosQueLaBloquean)
					this.estadoBloqueo = true;
			}
		return false;
	}

	public void cerrar() {
		if (this.estadoBloqueo == false)
			if (this.cerraduraAbierta == true) {
				this.cerraduraAbierta = false;
				this.cantidadDeFallosConsecutivosActualmente = 0;
			}
	}

	public boolean estaAbierta() {
		return this.cerraduraAbierta;
	}

	public boolean estaCerrada() {
		return !this.cerraduraAbierta;
	}

	public boolean fueBloqueada() {
		return this.estadoBloqueo;
	}

	public int contarAperturasExitosas() {
		return cantidadDeAperturasExitosas;
	}

	public int contarAperturasFallidas() {
		return cantidadDeAperturasFallidas;
	}
}
