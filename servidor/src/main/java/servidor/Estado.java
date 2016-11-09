package servidor;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSplitPane;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;


public class Estado extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8171413268402334608L;

	LinkedList<MapaLogico> mapasLogicos;
	Visor vs;
	private JTextField textField;


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
		
		mapasLogicos=new LinkedList<MapaLogico>();
		MapaAlianza ma= new MapaAlianza("Humanos");
		MapaObstaculos mo= new MapaObstaculos(32, 32, 0.5);
		
		mapasLogicos.add(ma);
		mapasLogicos.add(mo);
		
		
		


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(99, 40, 335, 10);
		panel.add(panel_1);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(31, 69, 37, 14);
		panel.add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(99, 66, 335, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnGenerar = new JButton("Generar");
		btnGenerar.setBounds(10, 228, 320, 23);
		panel.add(btnGenerar);
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (vs==null)
				 vs=new Visor();
				for (MapaLogico ml : mapasLogicos)
				 vs.showMapaLogico(ml);
					vs.setVisible(true);
					vs.repaint();
			
			}
		});
		

	}
	
	private void procesar()
	{
		
//		Funcion para hacer el tick logico. 
		for (MapaLogico ml : mapasLogicos)
		ml.notifyObservers();

	}
	


	
}

;
