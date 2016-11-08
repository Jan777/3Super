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
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JComboBox;


public class Estado extends JFrame {
	
	MapaLogico ml;
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
		
		ml = new MapaLogico();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		
		JSplitPane splitPane = new JSplitPane();
		getContentPane().add(splitPane, BorderLayout.SOUTH);
		
		JButton btnVer = new JButton("Ver");
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ml.notifyObservers();
				
					vs.setVisible(true);
					vs.repaint();
				
				
				
			}
		});
		splitPane.setLeftComponent(btnVer);
		
		JButton btnGenerar = new JButton("Generar");
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (vs==null)
				 vs=new Visor();
				 vs.showMapaLogico(ml);
			
			}
		});
		splitPane.setRightComponent(btnGenerar);
		
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
		

	}
	
	private void procesar()
	{
		
//		Funcion para hacer el tick logico. 
		ml.notifyObservers();

	}
	


	
}

;
