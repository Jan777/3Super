package jugador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.codehaus.jackson.map.ObjectMapper;

import comun.User;
import comunicacion.Client;
import comunicacion.ClientThread;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;



public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6087367122783786127L;
	private JPanel contentPane;
	private JTextField campo_usuario;
	private JPasswordField campo_contra;
	Socket socket;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel usuario = new JLabel("Usuario:");
		usuario.setBounds(55, 71, 54, 14);
		contentPane.add(usuario);
		
		JLabel contrasenia = new JLabel("Contrase\u00F1a:");
		contrasenia.setBounds(55, 130, 138, 14);
		contentPane.add(contrasenia);
		
		campo_usuario = new JTextField();
		campo_usuario.setBounds(144, 68, 130, 20);
		contentPane.add(campo_usuario);
		campo_usuario.setColumns(10);
		
		campo_contra = new JPasswordField();
		campo_contra.setBounds(144, 127, 130, 20);
		contentPane.add(campo_contra);
		
		JButton botonlogin = new JButton("Entrar");
	
		botonlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String password = new String(campo_contra.getPassword());
				//Socket socket;
				
				try {
					final int PORT = 4445;
					String server = "127.0.0.1";
		            socket = new Socket(server, PORT);
		            System.out.println("Te conectaste a: " + server);
					
			        ObjectMapper mapper = new ObjectMapper();
					Scanner sc = new Scanner(System.in);
//					Scanner input = new Scanner(socket.getInputStream());

		            User user = new User(password, campo_usuario.getText(),"login",null,null,0);
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
		botonlogin.setBounds(185, 202, 89, 23);
		contentPane.add(botonlogin);
		
		JButton btnRegistrar = new JButton("Registrarse");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Registro reg = new Registro();
				reg.setVisible(true);
				dispose();
			}
		});
		btnRegistrar.setBounds(41, 202, 124, 23);
		contentPane.add(btnRegistrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					socket.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		btnCancelar.setBounds(298, 202, 89, 23);
		contentPane.add(btnCancelar);
		
	
	}
	
}
