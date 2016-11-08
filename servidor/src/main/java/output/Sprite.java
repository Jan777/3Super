package output;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

//Quiza te preguntes porque una clase sprite que es un Label con otro nombre... 
//Sinceramente esperaba escribir mas. Lo dejo porque el constructor quedo cheto.

public class Sprite extends JLabel {
	
	
	public Sprite(String path) {
		super(new ImageIcon(path));
		}
	
	public Sprite() 
	{
		super();
//		super.setIcon(new ImageIcon("bin/E.gif"));
		super.setIcon(new ImageIcon("servidor/bin/tiletest.png"));
		
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
	
	public void printSprite(Component c, Graphics2D g)
	{
		this.getIcon().paintIcon(c, g, this.getX(), this.getY());
		g.drawString(this.getBounds().toString(), 50, 50);
	}

}
