package jugador;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;

import javax.swing.JPanel;


public class Output  extends JPanel{
	
	Layer capa;
	Sprite sprt;
	
	public Output()
	{
		super();
		sprt= new Sprite();
		
		
	}
	
    public void paintComponent(Graphics g) {
        
        g.setColor(Color.BLACK);
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
       
			drawSelf((Graphics2D) g, width, height);
		
    }
   
    private void drawSelf(Graphics2D g2, int width, int height) {
    	
    	g2.setColor(Color.BLACK);


		sprt.setpos(width/2, height/2);
		sprt.getIcon().paintIcon(this, g2, 50, 50);

//    	g2.drawImage(sprt, width/2, height/2, this);
    	g2.drawString(System.getProperty("user.dir"), width/2, height/2);
    	g2.drawString(sprt.getSize().toString(), 10, 10);
    	g2.drawString(sprt.getLocation().toString(), 20, 20);
    	if (sprt.getIcon()!=null)
    	g2.drawString(sprt.getIcon().toString(), 30, 30);
    	else
    	g2.drawString("NO FUNCA", 30, 30);
        		
        		
    }

}
