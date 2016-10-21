package main;

import personaje.*;

public class Main {

	public static void main(String[] args) {
		Humano pj1 = new Humano("Ivan");
		Humano pj2 = new Humano("Jose");
		
		System.out.println("Jorge Salud Inicial:" + pj2.obtenerPuntosDeSalud());
		System.out.println("Jorge Energia Despues del Ataque:" + pj1.obtenerPuntosDeEnergia());
		pj1.atacar(pj2);
		pj1.atacar(pj2);
		System.out.println("Jorge Salud Despues del Ataque:" + pj2.obtenerPuntosDeSalud());
		System.out.println("Jorge Energia Despues del Ataque:" + pj1.obtenerPuntosDeEnergia());

	}

}
