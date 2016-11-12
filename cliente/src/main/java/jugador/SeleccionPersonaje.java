package jugador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.codehaus.jackson.map.ObjectMapper;

import comun.User;
import comunicacion.ClientThread;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class SeleccionPersonaje extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2726214439028001680L;
	private JPanel contentPane;

	
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeleccionPersonaje frame = new SeleccionPersonaje();
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
	public SeleccionPersonaje(final Socket socket,final User user) {
		setTitle("Seleccion de Personaje");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRaza = new JLabel("Raza:");
		lblRaza.setBounds(10, 29, 76, 14);
		contentPane.add(lblRaza);
		
		JComboBox comboRaza = new JComboBox();
		comboRaza.setModel(new DefaultComboBoxModel(new String[] {"Humano", "Holograma", "Bot"}));
		comboRaza.setBounds(58, 26, 104, 20);
		contentPane.add(comboRaza);
		
		JLabel lblCasta = new JLabel("Casta:");
		lblCasta.setBounds(10, 77, 61, 14);
		contentPane.add(lblCasta);
		
		JComboBox comboCasta = new JComboBox();
		comboCasta.setModel(new DefaultComboBoxModel(new String[] {"Programador", "Tester", "Soporte"}));
		comboCasta.setBounds(58, 74, 104, 20);
		contentPane.add(comboCasta);
		
		JLabel lblMapa = new JLabel("Mapa:");
		lblMapa.setBounds(10, 125, 46, 14);
		contentPane.add(lblMapa);
		
		final JComboBox comboMapa = new JComboBox();
		comboMapa.setModel(new DefaultComboBoxModel(new String[] {"Fisica", "Enlace de Datos", "Red(SOON)","Transporte(SOON)","Sesion(SOON)","Presentacion(SOON)","Aplicacion(SOON))"}));
		comboMapa.setBounds(58, 122, 104, 20);
		contentPane.add(comboMapa);
		
		JButton btnMapa = new JButton("Jugar");
		btnMapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ObjectMapper mapper = new ObjectMapper();
				User user2 = new User(user.getPass(),user.getNombre(),null,null,null,0);
				
				String mapaSeleccionado = (String) comboMapa.getSelectedItem();
				switch (mapaSeleccionado) {
				case "Fisica":
					user2.setMundoSelec(1);
					break;
				case "Enlace de Datos":
					user2.setMundoSelec(2);
				default:
					//Poner mensaje de error
					break;
				}
	            	
				user2.setAccion("entrarAMundo");
		        String jsonInString;

				try {
					//Le envio al servidor la informacion del mundo al que quiere entrar el usuario
		            
					jsonInString = mapper.writeValueAsString(user2);
					PrintWriter out = new PrintWriter(socket.getOutputStream()); //OBTENGO EL CANAL DE SALIDA DEL SOCKET HACIA EL SERVIDOR
					out.println(jsonInString);
					out.flush();
					ClientThread newClient = new ClientThread(socket);
		            Thread thread = new Thread(newClient);
		            thread.start();
		            System.out.println("Se ejecuto la acción: "+ user2.getAccion());
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
					Mapa mapa = new Mapa();
					mapa.setVisible(true);
					dispose();
				
	            
				
			}
		});
		btnMapa.setBounds(143, 200, 151, 23);
		contentPane.add(btnMapa);
		
		JButton btnCerrar = new JButton("Cerrar"); //Cierro el socket cuando cierro ventana de Seleccion de Personaje
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
								
	            try {
	            	 ObjectMapper mapper = new ObjectMapper();
	        		 String jsonInString;
	        		 User user2 = new User(null,null,"oprimioCerrar",null,null,0);
	        		 jsonInString = mapper.writeValueAsString(user2);
	        		 PrintWriter out = new PrintWriter(socket.getOutputStream()); //OBTENGO EL CANAL DE SALIDA DEL SOCKET HACIA EL SERVIDOR
	        		 out.println(jsonInString);
	        		 out.flush();
					socket.close();
					System.exit(0);
					//dispose();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnCerrar.setBounds(300, 200, 151, 23);
		contentPane.add(btnCerrar);

		
		
	}


	private void desconectar(Socket socket) throws IOException {
		 socket.close();
		 ObjectMapper mapper = new ObjectMapper();
		 String jsonInString;
		 User user2 = new User(null,null,"oprimioCerrar",null,null,0);
		 jsonInString = mapper.writeValueAsString(user2);
		 PrintWriter out = new PrintWriter(socket.getOutputStream()); //OBTENGO EL CANAL DE SALIDA DEL SOCKET HACIA EL SERVIDOR
		 out.println(jsonInString);
		 out.flush();
	     System.exit(0);
		
	}
}
