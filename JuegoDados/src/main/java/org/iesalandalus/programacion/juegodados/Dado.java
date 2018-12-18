package org.iesalandalus.programacion.juegodados;

import java.util.Random;

public class Dado {
	
	private Dado() {
		//Evito que se genere el constructor público por defecto
	}
	
	private static Random generador = new Random();
	
	public static int lanzar() {
		return generador.nextInt(6) + 1;
	}

}
