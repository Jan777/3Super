package test;

import org.junit.Assert;
import org.junit.Test;
import npc.Resistencia;
import personaje.Humano;

public class PersonajeTests {

 /* Dado un Personaje, cuando el Personaje
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
