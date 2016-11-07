package output;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

import servidor.MapaLogico;

//Esta clase se usa como conveniencia, para poder siempre dibujar sprites de forma agrupada.

public class Layer implements Observer{
	
	LinkedList <Sprite> sprites;
	
	Layer(){
		
		sprites = new LinkedList<Sprite>();
		
		
	}
	
	public void addSprite(Sprite s)
	{
		sprites.add(s); // Las propiedades del sprite se inicializan con los metodos del sprite, preferiblemente afuera.
	}
	
	public void printLayer(Component c, Graphics2D g)
	{
		g.drawString(this.toString(), 20, 20);
		for(Sprite s : sprites)
		{
			s.printSprite(c, g);
		}
	}
	
	public void update(Observable o, Object arg)
	{
	
			MapaLogico ml=(MapaLogico)o;
			
			for(int i=0;i<ml.getW();i++)
				for (int j=0;j<ml.getH();j++)
					if(ml.ocupada(i, j)) 
						{Sprite s = new Sprite();
						s.setpos(i * ml.getH(), j * ml.getW()); 
						this.addSprite(s);}
		
	}
	
}
