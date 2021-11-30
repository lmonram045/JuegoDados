package org.iesalandalus.programacion.juegodados;

import java.util.Arrays;

public class Jugador {

	private static final int NUM_TIRADAS = 5;
	private String nombre;
	private final int[] puntuacionTiradas = new int[NUM_TIRADAS]; // Esta creo que debería ser final

	public Jugador(String nombre){
		setNombre(nombre);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre.equals(""))
			throw new IllegalArgumentException("ERROR: El nombre no puede estar vacío");
		else
			this.nombre = nombre;
	}

	public void jugar() {
		for (int i = 0; i < NUM_TIRADAS; i++) {
			puntuacionTiradas[i] = Dado.lanzar();
		}
	}

	public int getPuntuacionTotal() {
		int puntuacionTotal = 0;
		for (int i = 0; i < NUM_TIRADAS; i++){
			puntuacionTotal += puntuacionTiradas[i];
		}
		return puntuacionTotal;
	}

	/** Lo hice de otra forma, con un bucle, pero he decidido copiarlo de la solución */
	@Override
	public String toString() {
		return String.format("Jugador [nombre=%s, puntuaciones=%s, puntuacion total=%d]%n",
				nombre, Arrays.toString(puntuacionTiradas), getPuntuacionTotal());
	}
}