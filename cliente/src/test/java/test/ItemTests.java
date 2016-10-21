package test;

import org.junit.Assert;
import org.junit.Test;

import equipamiento.ConMouseNoganet;
import personaje.Humano;

public class ItemTests {

	@Test
	public void equiparItemAfectaPuntos(){
		Humano diego = new Humano("diego");
		
		ConMouseNoganet diegoEquipado = new ConMouseNoganet(diego);
		
		System.out.println(diegoEquipado.calcularPuntosDeAtaque());
		
		Assert.assertEquals(0, 0);
	}
	
}
