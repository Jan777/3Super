package personaje;

import java.awt.Point;

import servidor.MapaAlianza;

public interface Atacable {

		
		void serAtacado(int da�o);
		
		int darExperiencia();

		public boolean estaVivo();

		void revivir();


}
