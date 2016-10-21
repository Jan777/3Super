package npc;

public class Resistencia extends Npc{
	public Resistencia() {
		super();
		this.nombre="Resistencia";
		this.salud=this.nivel*100;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int obtenerPuntosDeDefensa() {
		return 0;
	}

	@Override
	public int calcularPuntosDeSalud() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
