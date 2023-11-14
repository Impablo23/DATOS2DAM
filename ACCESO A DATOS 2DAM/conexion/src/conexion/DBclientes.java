package conexion;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.*;

public class DBclientes {
	
	static Connection conn;
	 public static boolean loadDriver(Connection conn) {
	        try {
	            System.out.print("Cargando Driver...");
	            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
	            System.out.println("OK!");
	            return true;
	        } catch (ClassNotFoundException ex) {
	            ex.printStackTrace();
	            return false;
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            return false;
	        }
	    }
	 public static boolean connect(Connection conn) {
	        try {
	            System.out.print("Conectando a la base de datos...");
	            conn = DriverManager.getConnection("jdbc:mysql://192.168.6.221/pablo", "pablo", "pablo11504");
	            System.out.println("OK!");
	            return true;
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            return false;
	        }
	    }
	 public static boolean isConnected(Connection conn) {
	        // Comprobamos estado de la conexión
	        try {
	            if (conn != null && conn.isValid(0)) {
	                System.out.println("CONEXIÓN CORRECTA");
	                return true;
	            } else {
	                return false;
	            }
	        } catch (SQLException ex) {
	            System.out.println("ERROR EN LA CONEXIÓN");
	            ex.printStackTrace();
	            return false;
	        }
	    }
	 
	 public static void close(Connection conn) {
	        try {
	            System.out.print("Cerrando la conexión...");
	            conn.close();
	            System.out.println("OK!");
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }
	 
	 

	 //Imprime la tabla clientes
	 public static void printTablaClientes(Connection pablo) {
	        try (PreparedStatement s= pablo.prepareStatement("SELECT * from clientes")){
	            ResultSet rs = s.executeQuery();
	            while (rs.next()) {
	                String id = rs.getString("cod");
	                String n = rs.getString("nombre");
	                String d = rs.getString("tlf");
	                double sa=rs.getDouble("saldo");
	                System.out.println(id + "\t" + n + "\t" + d+ "\t" +sa);
	            }
	            rs.close();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	   
	 }
	 
	 
	 //Imprime la tabla incidencias
	 public static void printTablaIncidencias(Connection conn) {
	        try (PreparedStatement s= conn.prepareStatement("SELECT * from incidencia")){
	            ResultSet rs=s.executeQuery();
	            while (rs.next()) {
	                String id = rs.getString("codCli");
	                String n = rs.getString("fecha");
	                String d = rs.getString("descripcion");
	                int sa=rs.getInt("numHoras");
	                System.out.println(id + "\t" + n + "\t" + d+ "\t" +sa);
	            }
	            rs.close();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }
	 
	 //Metodo que inserta una incidencia a la tabla
	 public static boolean insertarIncidencia(Connection conn,String cod,String descripcion,int numh) {
		 String consulta="INSERT INTO incidencia(codCli,fecha,descripcion,numHoras) VALUES(?,?,?,?)";
		 LocalDateTime fecha=LocalDateTime.now();
		 Timestamp f=Timestamp.valueOf(fecha);
	        if(conn!=null) {
	        	try (PreparedStatement ps =conn.prepareStatement(consulta)){
	        		
	                // Obtenemos la tabla clientes
	                System.out.print("Insertando al cliente la incidencia numero " + cod + "...");
	                // Insertamos el nuevo registro
	                ps.setString(1,cod);
	                ps.setTimestamp(2, f);
	                ps.setString(3,descripcion);
	                ps.setInt(4,numh);
	                
	                
	                int registoOK=ps.executeUpdate();

	                // Todo bien, cerramos ResultSet y devolvemos true
	                ps.close();
	                System.out.println("¡Inserccion Realizada Correctamente! :)");
	                return true;

	            } catch (SQLException ex) {
	               
	                return false;
	            } 
	        }
	        return false;
	    
	 }
	 
	 public static boolean verificaCliente(Connection conn, String codigo) {
		    String consulta = "SELECT cod FROM clientes WHERE cod=?";
		    try (PreparedStatement ps = conn.prepareStatement(consulta)) {
		        ps.setString(1, codigo);
		        
		        try (ResultSet rs = ps.executeQuery()) {
		            // Si hay al menos un resultado en el ResultSet, el cliente existe en la tabla
		            if (rs.next()) {
		                return true;
		            } else {
		                // No hay resultados en el ResultSet, el cliente no existe en la tabla
		                return false;
		            }
		        }
		    } catch (SQLException ex) {
		        // Manejo de excepciones SQL, devuelve false en caso de error
		        ex.printStackTrace(); // Aquí puedes manejar la excepción según tus necesidades
		        return false;
		    }
		}

	 
	 
}
