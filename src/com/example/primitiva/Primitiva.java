package com.example.primitiva;

import java.util.Arrays;
import java.util.Random;

public class Primitiva {
	private final static int TOTALNUMEROS = 6;
	private final static int TOPENUMEROS = 49;
	private static int[] lista;

	public static String getNumeros() {
		generanumeros();
		return montaCadena() ;
	}

	private static void generanumeros() {
		Random rand = new Random();
		int aleatorio;
		lista = new int[TOTALNUMEROS];

		for (int i = 0; i < lista.length; i++) {
			aleatorio = rand.nextInt(TOPENUMEROS) + 1;

			while (comprobarRepetido(aleatorio)) {
				aleatorio = rand.nextInt(TOPENUMEROS) + 1;
			}

			lista[i] = aleatorio;
		}

		Arrays.sort(lista);

	}

	private static boolean comprobarRepetido(int aleatorio) {

		for (int i = 0; i < lista.length; i++) {
			if (lista[i] == aleatorio) {
				return true;
			}
		}

		return false;
	}

	private static String montaCadena() {
		StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < lista.length; i++) {
			buffer.append( lista[i]+"  ");
		}

		return buffer.toString();

	}
}
