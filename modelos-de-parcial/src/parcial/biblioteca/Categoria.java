package parcial.biblioteca;

public class Categoria {

	private int id;
	private String descripcion;

	public Categoria(int id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Categoria: " + descripcion;
	}

}
