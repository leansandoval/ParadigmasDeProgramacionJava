package parcial.productos;

import java.util.ArrayList;
import java.util.List;

public class Limpieza extends Producto {

	private List<String> quimicos;

	public Limpieza(String nombre, double precio, int cantDisponible) {
		super(nombre, precio, cantDisponible);
		quimicos = new ArrayList<>();
	}

	public void agregarQuimico(String quimico) {
		if (quimico == null)
			throw new NullPointerException();
		quimicos.add(quimico);
	}

	@Override
	public void chequearCalidad() {
		System.out.println("Segun la lista de quimicos, el producto alcanzo la calidad esperada");
	}

}
