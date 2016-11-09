package jugador;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

//Quiza te preguntes porque una clase sprite que es un Label con otro nombre... 
//Sinceramente esperaba escribir mas. Lo dejo porque el constructor quedo cheto.

public class Sprite extends JLabel {
	
//	JLabel img;
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1776399298201431777L;

	Sprite(String path) 
	{
	
		super(new ImageIcon(path));
		
	
		
		
	}
	
	Sprite() 
	{
		super();
		super.setIcon(new ImageIcon("src/E.gif"));
		
//		super.setPreferredSize(new Dimension(32,32));
	}
	
	public void setpos(int x, int y){
		
		this.setBounds(x, y, 32, 32);
		super.setVisible(true);
		
	}
	

	
	public void paintComponent(Graphics g)
	{
		draw((Graphics2D)g, this.getWidth(),this.getHeight());
		
	}

	private void draw(Graphics2D g2, int width, int height) {
		
		g2.setColor(Color.black);
		super.repaint();
	}

}
