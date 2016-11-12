package servidor;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import baseDeDatos.MySQLConnection;
import org.codehaus.jackson.map.ObjectMapper;

import baseDeDatos.MySQLConnection;
import comun.User;

public class ServerLog implements Runnable {// The Runnable interface should be implemented by any class whose instances are intended to be executed by a thread.
    Socket socket;
    Scanner input;
    String mensaje = "";
    public  ArrayList<Socket> listaDeConexionesMundo1 = new ArrayList<>();
    public  ArrayList<Socket> listaDeConexionesMundo2 = new ArrayList<>();
    ObjectMapper mapper = new ObjectMapper();
    public MySQLConnection mySQLCon;
    
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
			
			
			if(accion.compareTo("login")==0)
			{
				
				String userEnviado = user.getNombre() ;
				String passEnviada = user.getPass() ;
				System.out.println("Llega el usuario con la accion: "+userEnviado+user.getAccion());
				//Comprobar en Base de DATOS
				
				//////////CONEXION CON LA BASE DE DATOS////////////
				mySQLCon = new MySQLConnection();
				mySQLCon.getConnection();

				///////////////////////////////////////////////////
				
				
				if(mySQLCon.verificarUserYPassword(userEnviado, passEnviada) == 1)
				{
					
					mySQLCon.close(); //CIERRO LA CONEXIÓN
					System.out.println("Entro con usuario correcto(?)");
				    User userAEnviar = new User(passEnviada,userEnviado,"abrirSeleccionMundo",this.listaDeConexionesMundo1,this.listaDeConexionesMundo2,0);
		            String jsonInString = mapper.writeValueAsString(userAEnviar);
		            PrintWriter out = new PrintWriter(socket.getOutputStream()); //OBTENGO EL CANAL DE SALIDA DEL SOCKET HACIA EL SERVIDOR
		            out.println(jsonInString); // LE ENVIO EL MENSAJE DE SALA Y NICKNAME
		           
		            out.flush();
		            System.out.println("Pase parte");
					//mando array con mundos
		                      
					///CREO THERAD SEGUN EL MUNDO
					
		            Scanner sc2;
		            System.out.println("entrando al contructor");
					sc2 = new Scanner(socket.getInputStream());
					 if (sc2.hasNextLine()) System.out.println("sc2ok"); else System.out.println("sc2mal");
					//SI UN CAMPO ES LOGIN; COMPRUEBO BDD, SI ES REGISTRO, AGREGO 	
//					 if (sc2.hasNextLine()) System.out.println("sc2ok"); else System.out.println("sc2mal");
					String input2 = sc2.nextLine();
					User user2 = mapper.readValue(input2, User.class);
					String accion2 = user2.getAccion() ;
		            System.out.println(accion2);
		            if(accion2.compareTo("oprimioCerrar")==0){
		            	System.out.println("Se ha desconectado: " + user2.getNombre());
		            }
		            
		            if(accion2.compareTo("entrarAMundo")==0){
						
						ServerThread partida;
						int mundoSeleccionado = user2.getMundoSelec();
						 switch (mundoSeleccionado) {
			             case 1:
			            	 System.out.println("Entre al mundo Fisico");
			            	 listaDeConexionesMundo1.add(socket);
			            	 partida = new ServerThread(socket, listaDeConexionesMundo1, user2.getNombre());
			                 Thread nuevoProcesoParalelo1 = new Thread(partida);
			                 nuevoProcesoParalelo1.start();
			                 break;
			             case 2:
			            	 System.out.println("Entre al mundo Enlace de Datos");
			            	 listaDeConexionesMundo2.add(socket);
			                 partida = new ServerThread(socket, listaDeConexionesMundo2, user2.getNombre());
			                 Thread nuevoProcesoParalelo2 = new Thread(partida);
			                 nuevoProcesoParalelo2.start();
			                 break;
			             default:
			                 break;
			                 }
						
					}
		            else
		            	System.out.println("Se ha desconectado: " + user2.getNombre());
		            
				}
				else {
					User userAEnviar = new User(null, null, "error", null,null, 0);
					
					String jsonInString = mapper.writeValueAsString(userAEnviar);

					PrintWriter out = new PrintWriter(socket.getOutputStream()); 
					out.println(jsonInString); 

					out.flush();
				}
				
			}
			
			
			if(accion=="registrar")
			{
				String userEnviado = user.getNombre() ;
				String passEnviada= user.getPass() ;
				//agregar en base de datos en Base de DATOS
				
			}
			
			//ServerThread chat;
			
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         

         

        
      
         /*
        
*/
    }
    

}
