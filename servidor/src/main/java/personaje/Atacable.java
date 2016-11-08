package personaje;

import output.Sprite;

public interface Atacable {

		
	
		void serAtacado(int daño);
		
		int darExperiencia();

		public boolean estaVivo();

		void revivir();

		public Sprite getSprite(); //Todo objeto que se pueda atacar tiene que poder ser visualizado
		
}
