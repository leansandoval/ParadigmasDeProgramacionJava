package edu.unlam.paradigmas.herencia.ej02;

import java.util.ArrayList;
import java.util.List;

public class Orquesta {

	private List<Instrumento> instrumentos;

	public Orquesta() {
		instrumentos = new ArrayList<>();
	}

	public void agregarInstrumento(Instrumento instrumento) {
		instrumentos.add(instrumento);
	}

	public void tocarTodosLosInstrumentos() {
		for (Instrumento instrumento : instrumentos)
			instrumento.tocar();
	}

	public void tocarInstrumentosDeViento() {
		for (Instrumento instrumento : instrumentos)
			if (instrumento instanceof Viento)
				instrumento.tocar();
	}

	public void tocarInstrumentosDeCuerda() {
		for (Instrumento instrumento : instrumentos)
			if (instrumento instanceof Cuerda)
				instrumento.tocar();
	}

	public void tocarInstrumentosDePercusion() {
		for (Instrumento instrumento : instrumentos)
			if (instrumento instanceof Percusion)
				instrumento.tocar();
	}

}
