package servidor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;


public class Estado extends JFrame {
	
	JLabel label;
	Point loc;
	MapaLogico ml;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Estado frame = new Estado();
					frame.setVisible(true);
					frame.procesar();
					
					
				
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Estado() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		loc = new Point();
		
		label = new JLabel("Todo Mal");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				loc = e.getPoint();
				procesar();
			}
		});
		getContentPane().add(label, BorderLayout.NORTH);
		

	}
	
	public void procesar()
	{
		ml = new MapaLogico();
		label.setText(ml.toString());
		label.repaint();
	}
	


	
}

;
