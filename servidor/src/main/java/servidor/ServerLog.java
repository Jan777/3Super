package servidor;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import org.codehaus.jackson.map.ObjectMapper;

import comun.User;

public class ServerLog implements Runnable {// The Runnable interface should be implemented by any class whose instances are intended to be executed by a thread.
    Socket socket;
    Scanner input;
    String mensaje = "";
    public  ArrayList<Socket> listaDeConexionesMundo1 = new ArrayList<>();
    public  ArrayList<Socket> listaDeConexionesMundo2 = new ArrayList<>();
    String nickName;
    ObjectMapper mapper = new ObjectMapper();

    //CONSTRUCTOR DEL CHAT
    public ServerLog(Socket socket, ArrayList<Socket> listaDeConexionesMundo1,ArrayList<Socket> listaDeConexionesMundo2) {
        this.socket = socket;
        this.listaDeConexionesMundo1=listaDeConexionesMundo1;
        this.listaDeConexionesMundo2=listaDeConexionesMundo2;
       // this.nickName = alias;
    }

    @Override
    public void run() {//SOBRECARGAR DE RUN QUE SE REALIZARA CUANDO INICIE EL THREAD CREADO EN "SERVIDOR"
		try {
			Scanner sc;
			sc = new Scanner(socket.getInputStream());
			System.out.println("Entree1");
			//SI UN CAMPO ES LOGIN; COMPRUEBO BDD, SI ES REGISTRO, AGREGO 
			String input = sc.nextLine();
			User user = mapper.readValue(input, User.class);
			String accion = user.getAccion() ;
			System.out.println("Accion!: "+accion);
			
			if(accion.compareTo("login")==0)
			{
				
				String userEnviado = user.getNombre() ;
				String passEnviada = user.getPass() ;
				System.out.println("Llega al servidor la accion login: "+userEnviado+passEnviada);
				//Comprobar en Base de DATOS
				if(userEnviado.equals("ivan"))
				{
					System.out.println("Entro con usuario correcto(?)");
				    User userAEnviar = new User(passEnviada,userEnviado,"abrirSeleccionMundo",this.listaDeConexionesMundo1,this.listaDeConexionesMundo2,0);
		            String jsonInString = mapper.writeValueAsString(userAEnviar);
		            PrintWriter out = new PrintWriter(socket.getOutputStream()); //OBTENGO EL CANAL DE SALIDA DEL SOCKET HACIA EL SERVIDOR
		            out.println(jsonInString); // LE ENVIO EL MENSAJE DE SALA Y NICKNAME
		            out.flush();
		            
					//mando array con mundos
		                      
					///CREO THERAD SEGUN EL MUNDO
					
				}
				else {
					User userAEnviar = new User(null, null, "error", null,null, 0);
					
					String jsonInString = mapper.writeValueAsString(userAEnviar);

					PrintWriter out = new PrintWriter(socket.getOutputStream()); 
					out.println(jsonInString); 

					out.flush();
				}
				
			}
			
			if(accion.compareTo("entrarAMundo")==0){
				System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA: "+ accion);
				ServerThread partida;
				int mundoSeleccionado = user.getMundoSelec();
				 switch (mundoSeleccionado) {
	             case 1:
	            	 System.out.println("Entre al mundo Fisico");
	            	 listaDeConexionesMundo1.add(socket);
	            	 partida = new ServerThread(socket, listaDeConexionesMundo1, user.getNombre());
	                 Thread nuevoProcesoParalelo1 = new Thread(partida);
	                 nuevoProcesoParalelo1.start();
	                 break;
	             case 2:
	            	 listaDeConexionesMundo2.add(socket);
	                 partida = new ServerThread(socket, listaDeConexionesMundo2, user.getNombre());
	                 Thread nuevoProcesoParalelo2 = new Thread(partida);
	                 nuevoProcesoParalelo2.start();
	                 break;
	             default:
	                 break;
	                 }
				
			}
			if(accion=="registrar")
			{
				String userEnviado = user.getNombre() ;
				String passEnviada= user.getPass() ;
				//agregar en base de datos en Base de DATOS
				
			}
			
			//ServerThread chat;
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         

         

        
      
         /*
        
*/
    }
    

}
