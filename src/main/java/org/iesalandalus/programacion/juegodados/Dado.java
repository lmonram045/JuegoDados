package org.iesalandalus.programacion.juegodados;

import java.util.Random;

public class Dado {
	/** Aunque en el diagrama no lo dice, lo marco como final (constante), ya que es más correcto
	 * (nunca modificamos ese valor) */
	private static final Random GENERADOR = new Random();

	/** Evitamos que se genere el constructor por defecto */
	private Dado() {

	}

	/** Método lanzar */
	public static int lanzar() {
		return GENERADOR.nextInt(6) +1;
	}
}
