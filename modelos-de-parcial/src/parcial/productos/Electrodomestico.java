package parcial.productos;

public class Electrodomestico extends Producto {

	private String fabricante;
	private String paisOrigen;
	private boolean prendido;

	public Electrodomestico(String nombre, double precio, int cantDisponible, String fabricante, String paisOrigen) {
		super(nombre, precio, cantDisponible);
		this.fabricante = fabricante;
		this.paisOrigen = paisOrigen;
		this.prendido = false;
	}

	@Override
	public void chequearCalidad() {
		System.out.println("El electrodomestico no presento desperfectos");
	}

	public void prender() {
		prendido = true;
	}

	public String getFabricante() {
		return fabricante;
	}

	public String getPaisOrigen() {
		return paisOrigen;
	}

	public boolean estaPrendido() {
		return prendido;
	}
}
