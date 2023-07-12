package parcial.biblioteca;

import java.time.LocalDate;

public class Autor {

	private int id;
	private String nombre;
	private String apellido;
	private LocalDate fechaDeNacimiento;

	public Autor(int id, String nombre, String apellido, LocalDate fechaDeNacimiento) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	@Override
	public String toString() {
		return nombre + " " + apellido;
	}

	public int getId() {
		return id;
	}

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

}
