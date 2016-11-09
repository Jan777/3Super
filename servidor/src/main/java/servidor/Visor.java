package servidor;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gameIO.Input;
import output.Output;
import javax.swing.BoxLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Visor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4257190517533286965L;
	private JPanel contentPane;
	private Output out;
	private Input in;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Visor frame = new Visor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Visor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		out = new Output();
		in = new Input();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				in.procesarMouse(arg0);
			}
		});
		contentPane.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				in.procesarTeclado(arg0);
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		out = new Output();
		in = new Input();
		contentPane.add(out, BorderLayout.CENTER);
		out.setLayout(new BoxLayout(out, BoxLayout.X_AXIS));
		
		
	}
	
	public void showMapaLogico(MapaLogico ml)
	{
		out.addLayer(ml);
	}
	
	public void repaint()
	{
//		super.repaint();
		out.repaint();
	}
}
