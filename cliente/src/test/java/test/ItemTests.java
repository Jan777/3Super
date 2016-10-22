package test;

import org.junit.Assert;
import org.junit.Test;

import equipamiento.*;
import personaje.Humano;
import personaje.Personaje;

public class ItemTests {

/* Dado un Personaje, cuando el Personaje obtenga un item, 
entonces el mismo incrementará o decrementará los Puntos de Defensa 
o Puntos de Ataque del Personaje*/
	
	@Test
	public void equiparItemAfectaPuntos(){
		
		Personaje diego = new Humano("diego");
		//aca tiene 40 PA, porque tiene 30 de fuerza + 10 de ataque. // PA = Puntos Ataq.
		
		diego = new ConMouseNoganet(diego);
		// Ahora debe tener 30 PA, porque el mouse le da -10

		Assert.assertEquals(30, diego.obtenerPuntosDeAtaque());
		
		diego = new ConMouseThermaltake(diego);
		// Ahora debe tener 60 PA, porque el mouse hace 30*2
		
		Assert.assertEquals(60, diego.obtenerPuntosDeAtaque());
	}
	
/* Dado un Personaje, cuando el Personaje recoja un item entonces
  el mismo se equipará sin importar la cantidad de items que ya tenga equipados.*/

	@Test
	public void equiparMuchosItems(){
		
		Personaje diego = new Humano("diego");
		//aca tiene 40 PA, porque tiene 30 de fuerza + 10 de ataque. // PA = Puntos Ataq.
		
		diego = new ConMouseThermaltake(diego);
		// Ahora debe tener 80 PA, porque el mouse hace 40*2
		diego = new ConMouseThermaltake(diego);
		// Ahora debe tener 160 PA, porque el mouse hace 80*2
		diego = new ConMouseThermaltake(diego);
		// Ahora debe tener 320 PA, porque el mouse hace 169*2
		diego = new ConMouseThermaltake(diego);
		// Ahora debe tener 640 PA, porque el mouse hace 320*2
		
		Assert.assertEquals(640, diego.obtenerPuntosDeAtaque());
	}
	
}
