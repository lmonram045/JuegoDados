package org.iesalandalus.programacion.juegodados;

import java.util.Arrays;

public class JuegoDados {
	private static final int MIN_JUGADORES = 2;
	private static final int MAX_JUGADORES = 10;
	private static Jugador[] jugadores;

	public JuegoDados(int numJugadores) {
			comprobarNumeroJugadoresValido(numJugadores);
	}

	private void comprobarNumeroJugadoresValido(int numJugadores) {
		if (numJugadores < MIN_JUGADORES || numJugadores > MAX_JUGADORES)
			throw new IllegalArgumentException("ERROR: El numero de jugadores debe estar entre 2 y 10 (incluidos)");
	}

	public Jugador getJugador(int numJugador) {
		if (numJugador >= jugadores.length)
			throw new IllegalArgumentException("ERROR: El numero de jugador no existe");
		else
			return jugadores[numJugador];
	}

	private void comprobarNumeroJugadorValido(int numJugador) {
		if (numJugador >= jugadores.length)
			throw new IllegalArgumentException("ERROR: El numero de jugador no existe");
	}

	public void setJugador(int numJugador, String nombreJugador) {
		comprobarNumeroJugadorValido(numJugador);
		jugadores[numJugador] = new Jugador(nombreJugador);
	}

	public void jugar() {
		for (Jugador jugador : jugadores) {
			jugador.jugar();
		}
	}

	public int getPuntuacionGanadora() {
		int puntuacionGanadora = 0;
		for (Jugador jugador : jugadores) {
			if (jugador.getPuntuacionTotal() > puntuacionGanadora)
				puntuacionGanadora = jugador.getPuntuacionTotal();
		}
		return puntuacionGanadora;
	}

	public Jugador[] getGanadores() {
		Jugador[] ganadores = new Jugador[jugadores.length];
		for (int i = 0; i < jugadores.length; i++) {
			if (jugadores[i].getPuntuacionTotal() == getPuntuacionGanadora())
				ganadores[i] = jugadores[i];
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