package edu.unlam.paradigmas.patrones.ej02;

public class TankModeSiegeState implements TankState {

	@Override
	public String moverse() {
		return "El tanque no se puede mover en modo asedio";
	}

	@Override
	public String atacar() {
		return "El tanque ataca en modo asedio";
	}

}
