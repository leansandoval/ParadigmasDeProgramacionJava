package unlam.paradigmas.objetos.ej02;

public class Punto {
	
	private double x, y;
	
	public static Punto origen = new Punto(0, 0);

	public Punto(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double obtenerX() {
		return this.x;
	}

	public double obtenerY() {
		return this.y;
	}

	public void cambiarX(double nuevoX) {
		this.x = nuevoX;
	}

	public void cambiarY(double nuevoY) {
		this.y = nuevoY;
	}

	public boolean estaSobreEjeX() {
		return this.x == 0;
	}

	public boolean estaSobreEjeY() {
		return this.y == 0;
	}

	public boolean esElOrigen() {
		return estaSobreEjeX() && estaSobreEjeX();
	}

	public double distanciaAlOrigen() {
		return distanciaAOtroPunto(origen);
	}

	public double distanciaAOtroPunto(Punto otro) {
		return Math.hypot(this.x - otro.x, this.y - otro.y);
	}
}
