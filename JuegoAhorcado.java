package com.ahorcado;

import java.util.Scanner;

public class JuegoAhorcado {

	public static void main(String[] args) {

		String jugador1;
		String jugador2;
		double sorteo;
		String jugadorQueInicia;
		String palabra,palabraAcertada = "";
		char palabraAdivinada[];
		char letra = '\0';
		int intentos = 0;
		Scanner reader = new Scanner(System.in);
		System.out.println("Ingrese Jugador 1 ");
		jugador1 = reader.nextLine();
		System.out.println("Ingrese Jugador 2 ");
		jugador2 = reader.nextLine();

		sorteo = Math.random();

		if (sorteo < 0.5) {
			jugadorQueInicia = jugador1;
		} else {
			jugadorQueInicia = jugador2;
		}
		System.out.println("Jugador que inicia " + jugadorQueInicia);

		System.out.println("Ingrese palabra ");
		palabra = reader.next();
		palabraAdivinada = new char[palabra.length()];

		for (int i = 0; i < palabraAdivinada.length; i++) {
			palabraAdivinada[i] = '_';
		}
		System.out.println("Estado de la adivinanza ");
		for (int i = 0; i < palabraAdivinada.length; i++) {
			System.out.print(palabraAdivinada[i] + " ");
		}
		while (intentos < 8 && !laPalabraFueAdivinada(palabraAdivinada)) {
			System.out.println();
			System.out.println("ingrese letra ");
			letra = reader.next().charAt(0);
			boolean existeLaLetra = false;

			for (int i = 0; i < palabra.length(); i++) {
				if (palabra.charAt(i) == letra) {
					palabraAdivinada[i] = letra;
					existeLaLetra = true;
				}
			}
			if (existeLaLetra == false) {
				System.out.println("La letra ingresada no existe ");
			}
			
			System.out.println("Estado de la adivinanza ");
			for (int i = 0; i < palabra.length(); i++) {
			
				System.out.print(palabraAdivinada[i] + " ");
		}
			intentos++;
		}

		for (int i = 0; i < palabra.length(); i++) {
//			System.out.print(palabraAdivinada[i] + " ");
			palabraAcertada += palabraAdivinada[i];
		}
		// System.out.println(palabraAcertada);
		if (palabra.equals(palabraAcertada)) {
			System.out.println("Gano el juego");
		} else {
			System.out.println("Juego perdido");
		}
	}

	private static boolean laPalabraFueAdivinada(char palabraAdivinada[]) {
		boolean resultado = true;
		for (int i = 0; i < palabraAdivinada.length; i++) {
			if (palabraAdivinada[i] == '_') {
				resultado = false;
			}
		}
		return resultado;
	}

}
