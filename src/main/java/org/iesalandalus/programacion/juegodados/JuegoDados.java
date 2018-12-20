package org.iesalandalus.programacion.juegodados;

import java.util.Arrays;

public class JuegoDados {

	private static final int MIN_JUGADORES = 2;
	private static final int MAX_JUGADORES = 10;
	
	private Jugador[] jugadores;
	
	public JuegoDados(int numeroJugadores) {
		comprobarNumeroJugadoresValido(numeroJugadores);
		jugadores = new Jugador[numeroJugadores];
	}
	
	private void comprobarNumeroJugadoresValido(int numeroJugadores) {
		if (numeroJugadores < MIN_JUGADORES || numeroJugadores > MAX_JUGADORES) {
			throw new IllegalArgumentException("El número de jugadores no es válido (" + 
					MIN_JUGADORES + "-" + MAX_JUGADORES + ").");
		}
	}
	
	public Jugador getJugador(int numeroJugador) {
		comprobarNumeroJugadorValido(numeroJugador);
		return jugadores[numeroJugador];
	}
	
	private void comprobarNumeroJugadorValido(int numeroJugador) {
		if (numeroJugador < 0 || numeroJugador >= jugadores.length) {
			throw new IllegalArgumentException("El número de jugador no es válido.");
		}
	}
	
	public void setJugador(int numeroJugador, String nombre) {
		comprobarNumeroJugadorValido(numeroJugador);
		jugadores[numeroJugador] = new Jugador(nombre);
	}
	
	public void jugar() {
		for (Jugador jugador : jugadores) {
			jugador.jugar();
		}
	}
	
	public int getPuntuacionGanadora() {
		int puntuacionMaxima = 0;
		for (Jugador jugador : jugadores) {
			int puntuacionJugador = jugador.getPuntuacionTotal();
			if (puntuacionJugador > puntuacionMaxima) {
				puntuacionMaxima = puntuacionJugador;
			}
		}
		return puntuacionMaxima;
	}
	
	public Jugador[] getGanadores() {
		Jugador[] ganadores = new Jugador[jugadores.length];
		int puntuacionGanadora = getPuntuacionGanadora();
		int indiceGanadores = 0;
		for (Jugador jugador : jugadores) {
			if (jugador.getPuntuacionTotal() == puntuacionGanadora) {
				ganadores[indiceGanadores++] = jugador;
			}
		}
		return ganadores;
	}

	@Override
	public String toString() {
		String resultados = "Resultados del juego.\n";
		resultados += "---------------------\n";
		resultados += String.format("Puntuación de los jugadores: %n%s%n", Arrays.toString(jugadores));
		resultados += String.format("Puntuación máxima: %d%n", getPuntuacionGanadora());
		StringBuilder ganadores = new StringBuilder("");
		for (Jugador ganador : getGanadores()) {
			if (ganador != null) {
				if (!ganadores.toString().equals("")) {
					ganadores.append(", ");
				}
				ganadores.append(ganador.getNombre());
			}
		}
		resultados += String.format("Ganadores: %s", ganadores);
		return resultados;
	}
	
	
}
