package npc;

import personaje.Atacable;

public abstract class Npc implements Atacable{
	protected String nombre;
	protected int salud;
	protected int saludpornivel=this.nivel*100;
	protected int nivel = 1;
	
	
	public boolean estaVivo() {
		return this.salud > 0;
	}
	
	public void serAtacado(int daño) {
		this.salud -= daño;
	}
	
	public void serCurado() {
		this.salud = this.saludpornivel;
	}
	
	public int obtenerPuntosDeSalud() {
		return calcularPuntosDeSalud()+this.salud;
	}
	public abstract int calcularPuntosDeSalud();
	
	public abstract int obtenerPuntosDeDefensa();
	
	@Override
	public int darExperiencia() {
		return this.nivel*10; // Cuando lo matas te da de experiencia su nivel*10
	}
}
