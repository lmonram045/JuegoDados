package org.iesalandalus.programacion.juegodados;

import java.util.Arrays;

public class Jugador {
	
	private static final int NUM_TIRADAS = 5;
	
	private String nombre;
	private int[] puntuacionTiradas;
	
	public Jugador(String nombre) {
		setNombre(nombre);
		puntuacionTiradas = new int[NUM_TIRADAS];
	}
	
	public String getNombre() {
		return nombre;
	}
	
	private void setNombre(String nombre) {
		if (nombre == null) {
			throw new IllegalArgumentException("El nombre de un jugador no puede ser nulo.");
		}
		if (nombre.equals("")) {
			throw new IllegalArgumentException("El nombre de un jugador no puede estar vacío.");
		}
		this.nombre = nombre;
	}
	
	public void jugar() {
		for (int i = 0; i < NUM_TIRADAS; i++) {
			puntuacionTiradas[i] = Dado.lanzar(); 
		}
	}
	
	public int getPuntuacionTotal() {
		int puntuacionTotal = 0;
		for (int puntuacion : puntuacionTiradas) {
			puntuacionTotal += puntuacion;
		}
		return puntuacionTotal;
	}

	@Override
	public String toString() {
		return String.format("Jugador [nombre=%s, puntuaciones=%s, puntuacion total=%d]%n",
				nombre, Arrays.toString(puntuacionTiradas), getPuntuacionTotal());
	}

}
