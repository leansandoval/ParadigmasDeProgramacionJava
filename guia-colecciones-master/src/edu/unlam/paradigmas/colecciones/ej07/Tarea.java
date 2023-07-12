package edu.unlam.paradigmas.colecciones.ej07;
import edu.unlam.paradigmas.colecciones.ej02.Fecha;

public class Tarea {

	private static int cantidadDeTareas = 1;
	private final int id;
	private String descripcion;
	private Fecha fecha;
	
	public Tarea(String descripcion, Fecha fecha) {
		this.id = cantidadDeTareas++;
		this.descripcion = descripcion;
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Fecha getFecha() {
		return fecha;
	}

	
	@Override
	public String toString() {
		return "Id : " + id + String.format("%-50s", "\tDescripcion : " + descripcion) + " Fecha : " + fecha;
	}

}
