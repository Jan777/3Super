package personaje;

import output.Sprite;

public interface Atacable {

		
	
		void serAtacado(int da�o);
		
		int darExperiencia();

		public boolean estaVivo();

		void revivir();

		public Sprite getSprite(); //Todo objeto que se pueda atacar tiene que poder ser visualizado
		
}
