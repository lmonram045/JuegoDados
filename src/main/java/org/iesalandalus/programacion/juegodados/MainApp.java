package org.iesalandalus.programacion.juegodados;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.util.Objects;

public class MainApp {

    static Jugador[] jugadores;
    static JuegoDados juego;

    public static void main(String[] args) {
        int numJugadores = leerNumeroJugadores();
        crearJuego(numJugadores);
        crearJugadores(numJugadores);

        juego.jugar();

        System.out.println(juego);

    }

    private static void crearJuego(int numJugadores) {
        juego = new JuegoDados(numJugadores);
    }

    /** Metodo para leer por teclado el numero de jugadores */
    private static int leerNumeroJugadores() {
        int numJugadores;
        do {
            System.out.println("Cuantos vais a jugar?");
            numJugadores = Entrada.entero();
        } while (numJugadores < 2 || numJugadores > 10);

        return numJugadores;
    }

    private static void crearJugadores(int numJugadores) {
        String nombreJugador;


        for (int i=0; i < numJugadores; i++) {
            jugadores = new Jugador[numJugadores];
            nombreJugador = leerNombreJugador(i+1);
            juego.setJugador(i, nombreJugador);
        }

    }

    /** Metodo para leer por teclado el nombre de un jugador */
    private static String leerNombreJugador(int numJugador) {
        String nombreJugador = "";

        do {
            System.out.println("Introduzca el nombre de el jugador " + numJugador + ": ");
            nombreJugador = Entrada.cadena();
        } while (Objects.equals(nombreJugador, ""));

        return nombreJugador;
    }

}

















































/*
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
	} */