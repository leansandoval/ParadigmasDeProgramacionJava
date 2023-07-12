package edu.unlam.paradigmas.herencia.ej02;

public class Main {

	public static void main(String[] args) {

		Cuerda guitarra = new Cuerda("Guitarra", "Instrumento de cuerda");
		Cuerda violin = new Cuerda("Violin", "Instrumento de cuerda");
		Viento flauta = new Viento("Flauta", "Instrumento de viento", new Madera());
		Viento saxofon = new Viento("Saxofon", "Instrumento de viento", new Metal());
		Percusion tambor = new Percusion("Tambor", "Instrumento de percusión");
		Percusion bateria = new Percusion("Bateria", "Instrumento de percusión");

		Orquesta orquesta = new Orquesta();
		orquesta.agregarInstrumento(guitarra);
		orquesta.agregarInstrumento(violin);
		orquesta.agregarInstrumento(flauta);
		orquesta.agregarInstrumento(saxofon);
		orquesta.agregarInstrumento(tambor);
		orquesta.agregarInstrumento(bateria);

		// Tocar todos los instrumentos
		orquesta.tocarTodosLosInstrumentos();
		System.out.println();

		// Tocar instrumentos de viento
		orquesta.tocarInstrumentosDeViento();
		System.out.println();

		// Tocar instrumentos de percusion
		orquesta.tocarInstrumentosDePercusion();
		System.out.println();

		// Tocar instrumentos de cuerda
		orquesta.tocarInstrumentosDeCuerda();
		System.out.println();

		Lustrador lustrador = new Lustrador();
		lustrador.lustrarInstrumento(flauta);
		lustrador.lustrarInstrumento(tambor);
		System.out.println();

		Afinador afinador = new Afinador();
		afinador.afinarInstrumentoManual(guitarra);
		afinador.afinarInstrumentoAutomatico(saxofon);
	}

}
