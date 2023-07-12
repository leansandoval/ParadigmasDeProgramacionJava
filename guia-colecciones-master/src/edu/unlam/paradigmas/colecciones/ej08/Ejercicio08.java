package edu.unlam.paradigmas.colecciones.ej08;

import java.util.LinkedList;
import java.util.Queue;

public class Ejercicio08 {

	public static void invertirCola(Queue<Integer> colaEnteros) {
		if (colaEnteros.isEmpty())
			return;
		int elemento = colaEnteros.poll();
		invertirCola(colaEnteros);
		colaEnteros.offer(elemento);
	}

	public static void main(String[] args) {

		Queue<Integer> colaEnteros = new LinkedList<>();

		for (int i = 0; i < 10; i++)
			colaEnteros.add(i);

		System.out.println("Cola original: " + colaEnteros);
		invertirCola(colaEnteros);
		System.out.println("Cola invertida: " + colaEnteros);
	}
}
