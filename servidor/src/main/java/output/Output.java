package output;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JPanel;

import servidor.MapaLogico;


public class Output  extends JPanel{
	
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
    	
//    	g2.setColor(Color.BLACK);
    	
    	
//    	g2.clearRect(0, 0, this.getWidth(), this.getHeight());
//
//    	if (!Layers.isEmpty())
		for (Layer l : Layers)
			l.printLayer(this, g2);
//		g2.drawString(Integer.toString(Layers.size()), 10, 10);

////    	g2.drawImage(sprt, width/2, height/2, this);
//    	g2.drawString(System.getProperty("user.dir"), width/2, height/2);
//    	g2.drawString(sprt.getSize().toString(), 10, 10);
//    	g2.drawString(sprt.getLocation().toString(), 20, 20);
//    	if (sprt.getIcon()!=null)
//    	g2.drawString(sprt.getIcon().toString(), 30, 30);
//    	else
//    	g2.drawString("NO FUNCA", 30, 30);
		
		
        		
        		
    }
    
    

}
