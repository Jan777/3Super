package jugador;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import comunicacion.ClientThread;
import logica.MapaLogico;
import output.Output;

public class Mapa extends JFrame implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -751031079532977799L;
	private JPanel contentPane;
	private ClientThread Estado;
	private Output out;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				//Aca va el procesamiento de output
			}
		});
	}

	/**
	 * Create the frame.
	 * @param newClient 
	 */
	public Mapa(ClientThread newClient) {
		setTitle("Mapa");
		this.Estado = newClient;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		out = new Output();
		Estado.inicializar();
		for (MapaLogico ml : Estado.getML()) out.addLayer(ml);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(out);
		contentPane.repaint();
	}
	
	public Mapa() {
		setTitle("Mapa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new Output();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.repaint();
	}
	
	public void draw(){
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		//Por ahora nada :D
		
	}

}
