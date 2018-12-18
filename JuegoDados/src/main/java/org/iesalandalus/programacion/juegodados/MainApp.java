package org.iesalandalus.programacion.juegodados;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {
	
	private static JuegoDados juegoDados;

	public static void main(String[] args) {
		int numeroJugadores = 0;
		boolean esNumeroJugadoresValido = false;
		System.out.println("Juego de dados.\n---------------\n\n");
		do {
			try {
				numeroJugadores = leerNumeroJugadores();
				crearJuego(numeroJugadores);
				esNumeroJugadoresValido = true;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			} 
		} while (!esNumeroJugadoresValido);
		crearJugadores(numeroJugadores);
		juegoDados.jugar();
		System.out.println("\n" + juegoDados);
	}

	private static void crearJuego(int numeroJugadores) {
		juegoDados = new JuegoDados(numeroJugadores);
	}
	
	private static int leerNumeroJugadores() {
		int numeroJugadores = 0;
		System.out.print("Introduce el número de jugadores: ");
		numeroJugadores = Entrada.entero();
		return numeroJugadores;
	}

	private static void crearJugadores(int numeroJugadores) {
		for (int i = 0; i < numeroJugadores; i++) {
			String nombre = leerNombreJugador(i+1);
			juegoDados.setJugador(i, nombre);
		}
	}
	
	private static String leerNombreJugador(int numeroJugador) {
		String nombre;
		do {
			System.out.printf("Introduce el nombre del jugador %d: ", numeroJugador);
			nombre = Entrada.cadena();
		} while (nombre.equals(""));
		return nombre;
	}

}
