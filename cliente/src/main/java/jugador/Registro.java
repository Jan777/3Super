package jugador;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField campoUsu;
	private JPasswordField campoContra;
	private JTextField CampoMail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
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
	public Registro() {
		setTitle("Registrar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(10, 46, 59, 14);
		panel.add(lblUsuario);
		
		campoUsu = new JTextField();
		campoUsu.setBounds(66, 43, 209, 20);
		panel.add(campoUsu);
		campoUsu.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(10, 104, 95, 14);
		panel.add(lblContrasea);
		
		campoContra = new JPasswordField();
		campoContra.setBounds(84, 101, 191, 20);
		panel.add(campoContra);
		
		JLabel lblDireccionEmail = new JLabel("Direccion e-mail: ");
		lblDireccionEmail.setBounds(10, 158, 105, 14);
		panel.add(lblDireccionEmail);
		
		CampoMail = new JTextField();
		CampoMail.setBounds(115, 155, 160, 20);
		panel.add(CampoMail);
		CampoMail.setColumns(10);
		
		JButton btnReg = new JButton("Registrar");
		btnReg.setBounds(100, 209, 89, 23);
		panel.add(btnReg);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(227, 209, 95, 23);
		panel.add(btnCancelar);
	}
}
