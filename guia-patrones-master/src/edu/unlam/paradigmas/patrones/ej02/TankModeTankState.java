package edu.unlam.paradigmas.patrones.ej02;

public class TankModeTankState implements TankState {

	@Override
	public String moverse() {
		return "El tanque se mueve en modo tanque";
	}

	@Override
	public String atacar() {
		return "El tanque ataca en modo tanque";
	}
	
}
