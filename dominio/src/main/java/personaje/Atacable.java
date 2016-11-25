package personaje;

import java.awt.Point;

public interface Atacable{ //Todo objeto que se pueda atacar tiene que poder ser visualizado


	
		void serAtacado(int daño);
		
		int darExperiencia();

		public boolean estaVivo();

		void revivir();

		void setPosition(Point p);

		Point getPosition();

		
		
}
