package jugador;

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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1453514283810873060L;
	private JPanel contentPane;
	private JTextField campoUsu;
	private JPasswordField campoContra;
	private JTextField campoMail;

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
		setTitle("Registro");
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
		
		JLabel lblNombreUsuario = new JLabel("Nombre Usuario:");
		lblNombreUsuario.setBounds(10, 36, 128, 14);
		panel.add(lblNombreUsuario);
		
		campoUsu = new JTextField();
		campoUsu.setBounds(113, 33, 180, 20);
		panel.add(campoUsu);
		campoUsu.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(10, 90, 97, 14);
		panel.add(lblContrasea);
		
		campoContra = new JPasswordField();
		campoContra.setBounds(113, 87, 180, 20);
		panel.add(campoContra);
		
		JLabel lblDireccinEmail = new JLabel("Direcci\u00F3n e-mail:");
		lblDireccinEmail.setBounds(10, 152, 97, 14);
		panel.add(lblDireccinEmail);
		
		campoMail = new JTextField();
		campoMail.setBounds(123, 149, 170, 20);
		panel.add(campoMail);
		campoMail.setColumns(10);
		
		JButton btnReg = new JButton("Registrar");
		btnReg.setBounds(123, 211, 89, 23);
		panel.add(btnReg);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(236, 211, 89, 23);
		panel.add(btnCancelar);
	}
}
