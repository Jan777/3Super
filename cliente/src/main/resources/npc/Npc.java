package npc;

public abstract class Npc {
	protected String nombre;
	protected int salud;
	protected int saludpornivel=this.nivel*10;
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

}
