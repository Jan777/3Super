package jugador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.codehaus.jackson.map.ObjectMapper;

import comun.User;
import comunicacion.ClientThread;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
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
	Socket socket;

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
				btnReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String password = new String(campoContra.getPassword());
				//Socket socket;
				
				try {
					final int PORT = 4445;
					String server = "127.0.0.1";
		            socket = new Socket(server, PORT);
		            System.out.println("Te conectaste a: " + server);
					
			        ObjectMapper mapper = new ObjectMapper();
					Scanner sc = new Scanner(System.in);
//					Scanner input = new Scanner(socket.getInputStream());

		            User user = new User(password, campoUsu.getText(),"registrar",null,null,0);
		            String jsonInString = mapper.writeValueAsString(user);
		            PrintWriter out = new PrintWriter(socket.getOutputStream()); //OBTENGO EL CANAL DE SALIDA DEL SOCKET HACIA EL SERVIDOR
		            out.println(jsonInString); // LE ENVIO EL MENSAJE DE SALA Y NICKNAME
		            out.flush();
		            

		            ClientThread newClient = new ClientThread(socket);
		            Thread thread = new Thread(newClient);
		            System.out.println("Creando thread");
		            thread.start();
		            
		           

		            
		            //Leo la informacion que vuelve del servidor
		            Scanner input;
		            do{ 
		            	input = new Scanner(socket.getInputStream());
		            	
		            }while (input.hasNext()==false);
		            
					String in = input.nextLine();
					user = mapper.readValue(in, User.class);
					System.out.println("La re accion: "+user.getAccion());
					
		            if(user.getAccion().compareTo("abrirSeleccionMundo")==0){
		            	System.out.println("Aca tengo que abrir la seleccion de mundos");
						SeleccionPersonaje sp = new SeleccionPersonaje(socket,user);
						sp.setVisible(true);
						dispose();
						
					}else{	
						
						JOptionPane.showMessageDialog(null, "Usuario y/o Contraseña no validos");
					}
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				
	            ///////////
				//String password = new String(campo_contra.getPassword()); //para obtener el valor cuando ingrese password
				/*
				if(campo_usuario.getText().equals(usuario) && password.equalsIgnoreCase(contrasenia)){
					SeleccionPersonaje sp = new SeleccionPersonaje();
					sp.setVisible(true);
					dispose();
				}else{ //cuando ingreso mal el usuario o la contraseña aparece msj de eror
					
					
					JOptionPane.showMessageDialog(null, "Usuario y/o Contraseña no validos");
				}
				*/
				
			}

	
		});
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
