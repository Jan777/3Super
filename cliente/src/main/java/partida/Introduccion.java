package partida;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Introduccion extends JPanel{
	private static final long serialVersionUID = 1L;
	
	int x = 20, y = 200;
    	String texto1 = "Todo lo que recuerdo es un fuerte resplandor,";
    	String texto2 = "y haber despertado en una tierra desconocida.";
    	String texto3 = "Necesito escapar de aqui...";

    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        Font font = new Font("Tahoma",Font.BOLD+Font.PLAIN,25);
        g2.setFont(font);
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, 650, 400);
        g2.setColor(Color.decode("#953db4"));
        g2.drawString(texto1,x,y);
        g2.drawString(texto2,x,y+50);
        Font font2 = new Font("Tahoma",Font.BOLD+Font.PLAIN,40);
        g2.setFont(font2);
        g2.setColor(Color.decode("#ae49d2"));
        g2.drawString(texto3,x,y+150);
        
        
        try{Thread.sleep(100);}catch(Exception ex){}
        y-=2;
        if(y>this.getWidth ())
        {
            y=0;
        } 
        repaint();
    }
    
}