package edu.unlam.paradigmas.patrones.ej02;

public class Tank {

	private TankState estado;
	
	public void setEstado(TankState nuevoEstado) {
		this.estado = nuevoEstado;
	}
	
	public String moverse() {
		return estado.moverse();
	}
	
	public String atacar() {
		return estado.atacar();
	}
	
}
	