package personaje;

import java.awt.Point;

import servidor.MapaAlianza;

public interface Atacable {

		
		void serAtacado(int daño);
		
		int darExperiencia();

		public boolean estaVivo();

		void revivir();


}
