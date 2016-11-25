package partida;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.codehaus.jackson.map.ObjectMapper;

import comunicacion.Jugador;
import partida.entidades.dinamicas.*;

public class VentanaPelea extends JFrame {
	private static final long serialVersionUID = 1L;

	public VentanaPelea() {
		getContentPane().setLayout(null);
	}
	Jugador aux;
	protected static final partida.entidades.dinamicas.Player Player = null;
	private JPanel contentPane;

	public VentanaPelea(Player player, Player player2, Partida game) { //recibo los dos jugadores que van a pelear
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		JButton btnHuir = new JButton("Huir");
		btnHuir.setForeground(Color.WHITE);
		btnHuir.setBackground(Color.BLUE);
		btnHuir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				game.setEstaPeleando(false);
			}
		});
		btnHuir.setBounds(333, 237, 101, 23);
		contentPane.add(btnHuir);
		
		JButton btnAtacar = new JButton("Atacar");
		btnAtacar.setForeground(Color.WHITE);
		btnAtacar.setBackground(Color.BLUE);
		btnAtacar.setBounds(211, 237, 94, 23);
		contentPane.add(btnAtacar);
		
		JLabel lblPersonaje = new JLabel("");
		lblPersonaje.setBackground(Color.WHITE);
		lblPersonaje.setIcon(new ImageIcon("res/textures/PeleaProg_izquierda.gif"));
		lblPersonaje.setBounds(50, 100, 64, 64);
		contentPane.add(lblPersonaje);
		
		JLabel lblPersonajeEnemigo = new JLabel("");
		lblPersonajeEnemigo.setBackground(Color.WHITE);
		lblPersonajeEnemigo.setIcon(new ImageIcon("res/textures/PeleaProg_derecha.gif"));
		lblPersonajeEnemigo.setBounds(350, 100, 64, 64);
		contentPane.add(lblPersonajeEnemigo);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon("res/textures/fondo_pelea.png"));
		lblNewLabel.setBounds(0, 0, 444, 271);
		contentPane.add(lblNewLabel);
	}
	
	public VentanaPelea(Player player, GameNpc enemigo, Partida game) { //recibo los dos jugadores que van a pelear
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		JButton btnHuir = new JButton("Huir");
		btnHuir.setForeground(Color.WHITE);
		btnHuir.setBackground(Color.BLUE);
		btnHuir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				game.setEstaPeleando(false);
			}
		});
		btnHuir.setBounds(333, 237, 101, 23);
		contentPane.add(btnHuir);
		
		JButton btnAtacar = new JButton("Atacar");
		btnAtacar.setForeground(Color.WHITE);
		btnAtacar.setBackground(Color.BLUE);
		btnAtacar.setBounds(211, 237, 94, 23);
		contentPane.add(btnAtacar);
		btnAtacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				enemigo.getNpc().serAtacado(player.getPersonaje().getFuerza());
				
				if( !enemigo.getNpc().estaVivo() ){
					int index = game.getListaNpcs().indexOf(enemigo);
					
					
					try {	
						Jugador jugAux = new Jugador();
						jugAux.setMurioIndex(index);
						
						ObjectMapper mapper = new ObjectMapper();
						String jsonInString = mapper.writeValueAsString(jugAux);
						PrintWriter	out = new PrintWriter(game.getSocket().getOutputStream());
						out.println(jsonInString);
						out.flush();
						
						
					} catch (IOException e) {
						e.printStackTrace();
					}
					

					dispose();
					game.setEstaPeleando(false);
					
				}
			}
		});
		
		JLabel lblPersonaje = new JLabel("");
		lblPersonaje.setBackground(Color.WHITE);
		lblPersonaje.setIcon(new ImageIcon("res/textures/PeleaProg_izquierda.gif"));
		lblPersonaje.setBounds(50, 100, 64, 64);
		contentPane.add(lblPersonaje);
		
		
		JLabel lblPersonajeEnemigo = new JLabel("");
		lblPersonajeEnemigo.setBackground(Color.WHITE);
		if( enemigo.getIdentificacion() == 'C')
			lblPersonajeEnemigo.setIcon(new ImageIcon("res/textures/Capacitor_Pelea.gif"));
		else
			lblPersonajeEnemigo.setIcon(new ImageIcon("res/textures/Resistencia_Pelea.gif"));
		lblPersonajeEnemigo.setBounds(350, 100, 64, 64);
		contentPane.add(lblPersonajeEnemigo);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon("res/textures/fondo_pelea.png"));
		lblNewLabel.setBounds(0, 0, 444, 271);
		contentPane.add(lblNewLabel);
		

	}
}
