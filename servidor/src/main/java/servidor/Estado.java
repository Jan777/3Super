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
import javax.swing.JSplitPane;

import output.Layer;
import output.Output;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Estado extends JFrame {
	
	JLabel label;
	Point loc;
	MapaLogico ml;
	Visor vs;
	Output test;


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
		
		ml = new MapaLogico();
		test = new Output();
		test.setBounds(110, 110, 430, 270);
		test.setEnabled(true);
		test.setVisible(true);
		

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
		
		JSplitPane splitPane = new JSplitPane();
		getContentPane().add(splitPane, BorderLayout.SOUTH);
		
		JButton btnVer = new JButton("Ver");
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ml.notifyObservers();
				test.repaint();
				
					vs.repaint();
				
				
				
			}
		});
		splitPane.setLeftComponent(btnVer);
		
		JButton btnGenerar = new JButton("Generar");
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 vs=new Visor();
				 vs.showMapaLogico(ml);
				vs.setVisible(true);
				test.addLayer(ml);
			
			}
		});
		splitPane.setRightComponent(btnGenerar);
		

	}
	
	public void procesar()
	{
		ml.notifyObservers();

		label.setText(ml.toString());
		label.repaint();
	}
	


	
}

;
