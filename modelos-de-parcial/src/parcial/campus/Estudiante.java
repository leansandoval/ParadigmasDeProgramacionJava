package parcial.campus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Estudiante {

	private final int legajo;
	private String nombre;
	private String apellido;
	private LocalDate fechaDeIngreso;
	private List<Asignatura> asignaturasEnCurso;
	private List<Calificacion> calificaciones;

	public Estudiante(int legajo, String nombre, String apellido, LocalDate fechaDeIngreso) {
		this.legajo = legajo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeIngreso = fechaDeIngreso;
		this.asignaturasEnCurso = new ArrayList<>();
		this.calificaciones = new ArrayList<>();
	}

	public boolean agregarAsignatura(Asignatura asignatura) {
		boolean asignaturaRendida = false;
		for (Calificacion calificacion : calificaciones) {
			if (calificacion.getAsignatura().equals(asignatura))
				asignaturaRendida = true;
		}
		if (asignaturaRendida)
			return false;
		asignaturasEnCurso.add(asignatura);
		return true;
	}

	public void mostrarAsignaturasEnCurso() {
		System.out.println("Asignaturas en curso\n");
		for (Asignatura asignatura : asignaturasEnCurso) {
			System.out.println(asignatura);
		}
	}

	public void mostrarAsignaturasCursadas() {
		System.out.println("Asignaturas cursadas\n");
		for (Calificacion calificacion : calificaciones) {
			System.out.println(String.format("%-30s", calificacion.getAsignatura().getNombre()) + "\tNota final: "
					+ ((calificacion.getNotaPrimerParcial() + calificacion.getNotaSegundoParcial()) / 2));
		}
	}

	@Override
	public String toString() {
		return "Estudiante: " + legajo + " - " + nombre + " " + apellido;
	}

	public int getLegajo() {
		return legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public LocalDate getFechaDeIngreso() {
		return fechaDeIngreso;
	}

	public List<Asignatura> getAsignaturasEnCurso() {
		return asignaturasEnCurso;
	}

	public List<Calificacion> getCalificaciones() {
		return calificaciones;
	}

}
