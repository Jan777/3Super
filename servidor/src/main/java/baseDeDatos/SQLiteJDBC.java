package baseDeDatos;

import java.sql.*;

import javax.swing.JOptionPane;

public class SQLiteJDBC
{
	private static Connection conn;
	private static java.sql.Statement sentencia;
	
	public SQLiteJDBC(){
		
	}
	
	public Connection getConnection() {
		try {
			if(conn == null) {	
				
				Class.forName("org.sqlite.JDBC");
			    conn = DriverManager.getConnection("jdbc:sqlite:test.db");
			    conn.setAutoCommit(false);				
			}
			else{
				JOptionPane.showMessageDialog(null, "Ya se encuentra conectado", "Error", JOptionPane.ERROR_MESSAGE);

			}
		} catch (ClassNotFoundException cnfe) {
			JOptionPane.showMessageDialog(null, "No se encuentra el driver", "Error", JOptionPane.ERROR_MESSAGE);

		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error al Intentar la conexion", "Error", JOptionPane.ERROR_MESSAGE);
		}	
		return conn;
	}
	

	

	public int registrarse(String usuario, String password) throws SQLException {
		sentencia = null;
		boolean respuesta = false;
		try {
			

			sentencia = conn.createStatement(); 
			String query = "SELECT * FROM usuarios WHERE usuario = \""+usuario+"\"";
			ResultSet rs = sentencia.executeQuery(query);
			while(rs.next()){
				respuesta = true;
				rs.close();
		        sentencia.close();
			}
			if(respuesta == true){
				return 0;
			}
			else{
				sentencia = conn.createStatement();
				query = "INSERT INTO `usuarios`(`usuario`, `contraseña`)  VALUES(\"" + usuario + "\",\"" + password+ "\")";
				sentencia.execute(query);
				sentencia.close();
				conn.commit();
				return 1;
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error en la consulta SQL", "Error",JOptionPane.ERROR_MESSAGE);
			return 0;
		}

		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se logro ejecutar Insertar Correctamente la consulta", "Error", JOptionPane.ERROR_MESSAGE);
			return 0;
		}
	}
  

 
    public int verificarUserYPassword(String usuario, String password) throws SQLException 
    {
      sentencia = null;
      boolean respuesta = false;
		
		try {
			
			sentencia = conn.createStatement(); 
			String query = "SELECT * FROM usuarios WHERE usuario = \""+usuario+"\" and contraseña = \""+password+"\"";
			ResultSet rs = sentencia.executeQuery(query);
			while(rs.next()){
				respuesta = true;
				rs.close();
		        sentencia.close();
			}
			if(respuesta == true){
				return 1;
			}
			else{
				return 0;
			}
		
			
		}
		catch(SQLException ex){
			JOptionPane.showMessageDialog(null, "No se logro establecer conexión con la BD","Error", JOptionPane.ERROR_MESSAGE);
			return 0;
		}
		
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "No se logro establecer conexión con la BD","Error", JOptionPane.ERROR_MESSAGE);
			return 0;
		}
		
    }
    
    
	public void close() {
		try {
			if(conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error al intentar realizar la desconexion", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
    
	
	public static void crearTabla(){
		
		try {
	        sentencia = conn.createStatement();
	        String sql = "CREATE TABLE usuarios (usuario CHAR(15) PRIMARY KEY,contraseña CHAR(15))";
	        sentencia.executeUpdate(sql);
	        sentencia.close();

	      } catch ( Exception e ) {
				JOptionPane.showMessageDialog(null, "Error al crear la tabla", "Error", JOptionPane.ERROR_MESSAGE);
	        System.exit(0);
	      }
	}
	
   /* public static void main( String args[] ) throws SQLException
    {
  	  
  	  SQLiteJDBC mySQLCon = new SQLiteJDBC();
  	  mySQLCon.getConnection();
  		mySQLCon.verificarUserYPassword("ivan","123");
  		mySQLCon.close();
      
    }*/
  
}
  
  
  





