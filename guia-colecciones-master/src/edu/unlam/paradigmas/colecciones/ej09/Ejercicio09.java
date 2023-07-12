package edu.unlam.paradigmas.colecciones.ej09;

import java.util.Stack;

public class Ejercicio09 {

	public static boolean verificarBalanceoDeExpresionAritmetica(String expresionAritmetica) {

		Stack<Character> pilaParentesis = new Stack<>();

		for (int i = 0; i < expresionAritmetica.length(); i++) {
			char caracter = expresionAritmetica.charAt(i);
			if (caracter == '(' || caracter == ')')
				pilaParentesis.push(caracter);
		}

		int cantidadParentesisAbiertos = 0, cantidadParentesisCerrados = 0;

		while (!pilaParentesis.isEmpty()) {
			char caracter = pilaParentesis.pop();
			if (caracter == '(')
				cantidadParentesisAbiertos++;
			else
				cantidadParentesisCerrados++;
		}

		return cantidadParentesisAbiertos == cantidadParentesisCerrados;
	}

	public static void main(String[] args) {

		String primeraExpresion = "((3 + 4) * 2) - (5 / 2)";
		String segundaExpresion = "((3 + 4) * 2) - (5 / 2))";

		System.out.println("La expresion " + primeraExpresion + " esta balanceada? "
				+ verificarBalanceoDeExpresionAritmetica(primeraExpresion));
		System.out.println("La expresion " + segundaExpresion + " esta balanceada? "
				+ verificarBalanceoDeExpresionAritmetica(segundaExpresion));
	}
}
