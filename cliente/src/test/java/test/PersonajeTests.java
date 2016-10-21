package test;

import org.junit.Assert;
import org.junit.Test;
import npc.Resistencia;
import personaje.Humano;

public class PersonajeTests {

/*
 *   Dado un Personaje y un NPC, cuando el Personaje 
 *   elimina al NPC entonces aumenta el nivel de experiencia del Personaje:
 */
	@Test
	public void aumentarExperienciaAlMatarNPC(){
		Humano diego = new Humano("diego");
		Resistencia npc = new Resistencia();
		
		diego.atacar(npc);
		diego.atacar(npc);
		diego.atacar(npc);
		diego.atacar(npc);
		diego.atacar(npc);
		diego.atacar(npc);
		diego.atacar(npc);
		diego.atacar(npc);
		diego.atacar(npc);
		diego.atacar(npc);

		// Lo ataco hasta matarlo y me tiene que dar 10 de experiencia
		Assert.assertEquals(10, diego.getExperiencia());
	}
	
/*
 *   * Dado un Personaje y un Personaje Enemigo, cuando el Personaje elimina al 
 *    Personaje Enemigo entonces aumenta el nivel de experiencia del Personaje.
 */
	@Test
	public void aumentarExperienciaAlMatarPersonajeEnemigo(){
		Humano diego = new Humano("diego");
		Humano matias = new Humano("matias");
		
		for(int i=0; i<50; i++)
			diego.atacar(matias);

		// Lo ataco hasta matarlo y me tiene que dar 10 de experiencia
		Assert.assertEquals(10, diego.getExperiencia());
	}
	
/*
 * Dado un Personaje, cuando el Personaje
 *  no tiene mas energia entonces no puede atacar.
 */
	@Test
	public void noAtacarCuandoNoHayEnergia(){
		Humano diego = new Humano("diego");
		Humano matias = new Humano("matias");
		Resistencia npc = new Resistencia();
		
		for(int i=0; i<50; i++)
			diego.atacar(matias); // Gaste 500 de energia despues de atacar
		
		// No pudo atacar porque no tiene mas energia, atacar me devuelva false.
		Assert.assertEquals(false, diego.atacar(npc));
	}
	
	
}
