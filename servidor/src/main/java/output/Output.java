package output;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;

import servidor.MapaLogico;


public class Output  extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 765987516366043796L;
	ArrayList<Layer> Layers;
	Component padre;

	
	public Output()
	{
		super();
		Layers= new ArrayList<Layer>(); //TODO: setear el mapa por defecto.
		
	}
	
	public void addLayer(MapaLogico ml)
	{
		Layer l = new Layer();
		l.update(ml, null);
		ml.addObserver(l);
		Layers.add(l);
	}
	
    public void paintComponent(Graphics g) {
        
        g.setColor(Color.BLACK);
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
       
			drawSelf((Graphics2D) g, width, height);
		
    }
   
    private void drawSelf(Graphics2D g2, int width, int height) {

		for (Layer l : Layers)
			l.printLayer(this, g2);

    }
    
    

}
