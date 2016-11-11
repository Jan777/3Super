package baseDeDatos;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class MySQLConnection {

	private static Connection conn;
	
	
	private MySQLConnection() {
	}
	
	public static Connection getConnection() {
		try {
			if(conn == null) {	
				String driver="com.mysql.jdbc.Driver"; //el driver varia segun la BD que usemos
				
				
				/*
				 * PARA LOGIN DE http://www.freesqldatabase.com/
				 * email: matias.devanna@gmail.com
				 * contra: matiasdevanna
				 * 
				 * DESPUES TENES QUE IR A "hpMyAdmin for database administration Follow this link for phpMyAdmin" QUE 
				 * ESTA POR EL MEDIO DE LA PANTALLA
				 * 
				 * EN LA VENTANA NUEVA QUE TE ABRE POONES ESTO
				 * 
				 * SERVIDOR:   sql6.freesqldatabase.com
				 * Database user: sql6143481
				   Database password: JtJ4f8uerx
				 * 
				 * 
				 * */

			    String serverName = "sql6.freesqldatabase.com";
			    String mydatabase = "sql6143481";
			    String url = "jdbc:mysql://" + serverName + "/" + mydatabase; 
				String pwd="JtJ4f8uerx";
				String usr="sql6143481";
				Class.forName(driver);
				conn = DriverManager.getConnection(url,usr,pwd);
				System.out.println("Se realiz� la conexi�n con la BD con �xito");
			}
			else{
				System.out.println("La conexi�n se encuentra realizada.");
			}
		} catch (ClassNotFoundException cnfe) {
			System.out.println("No se encuentra el Driver.");
		} catch (SQLException sqle) {
			System.out.println("Error al intentar la conexi�n.");
		}	
		return conn;
	}
	
	public static void close() {
		try {
			if(conn != null) {
				conn.close();
				System.out.println("Desconexi�n de la BD exitosa.");
			}
		} catch (SQLException sqle) {
			System.out.println("Error al intentar la conexi�n.");
		}
	}
	
	
	
	public void consultar(String sql){
			//Establecer Conexion. 
		MySQLConnection conexionBD = new MySQLConnection();
		conexionBD.getConnection();
		ResultSet rs = null;
		try {
				java.sql.Statement s = conexionBD.conn.createStatement(); 
				rs = s.executeQuery(sql); 
				while (rs.next()) 
					{ 
					    System.out.println ("Usuario: " + rs.getString(1) + " / Contrase�a: " + rs.getString(2)); 
					}
					
			}catch(SQLException ex){
				JOptionPane.showMessageDialog(null, "No logro ejecutar Correctamente la consulta","Error", JOptionPane.ERROR_MESSAGE);
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "No Logro ejecutar Correctamente la consulta","Error", JOptionPane.ERROR_MESSAGE);
			} 
	}
	
	public void registrarse (String sql){
		
		MySQLConnection conexionBD = new MySQLConnection();
		conexionBD.getConnection();
		Statement sentencia = null;
		
		try {
			java.sql.Statement s = conexionBD.conn.createStatement(); 
			sentencia.execute(sql);
			System.out.println("Se inserto correctamente");
		}
		catch(SQLException ex){
			JOptionPane.showMessageDialog(null, "No logro ejecutar Insertar Correctamente la consulta","Error", JOptionPane.ERROR_MESSAGE);
		}
		
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "No logro ejecutar Insertar Correctamente la consulta","Error", JOptionPane.ERROR_MESSAGE);
		} 
		
	}
		
		
	
	
	
	public static void main(String[] args) throws SQLException {
		
		
		MySQLConnection conexionBD = new MySQLConnection();
		//conexionBD.consultar("select * from usuarios");
		conexionBD.registrarse("INSERT INTO usuarios(usuario,contrase�a)" + "VALUES('pepe',\"12345\")");
		
//		MySQLConnection conexionBD = new MySQLConnection();
//		conexionBD.getConnection();
//		java.sql.Statement s = conexionBD.conn.createStatement(); 
//		ResultSet rs = s.executeQuery ("select * from usuarios");
//		// Recorremos el resultado, mientras haya registros para leer, y escribimos el resultado en pantalla. 
//		while (rs.next()) 
//		{ 
//		    System.out.println ("Usuario: " + rs.getString(1) + " / Contrase�a: " + rs.getString(2)); 
//		}
//		
//		
		
		//conn = MySQLConnection.getConnection();
	}
	
}
