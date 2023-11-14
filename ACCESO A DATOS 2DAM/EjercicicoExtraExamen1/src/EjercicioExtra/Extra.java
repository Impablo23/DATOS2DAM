package EjercicioExtra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import com.mysql.cj.xdevapi.PreparableStatement;

public class Extra {
	
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
	 
	 public static void close(Connection conn) {
	        try {
	            System.out.print("Cerrando la conexión...");
	            conn.close();
	            System.out.println("OK!");
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }
	 
	 public static void usarBD(Connection conn) {
		 try (PreparedStatement s= conn.prepareStatement("use pablo;")){
			 System.out.print("Usando la base de datos de pablo...");
			 System.out.println("OK!");
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 
	 public static void leeArchivo(Connection conn,String archivo) {
		 try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
	            String linea;
	            while ((linea = br.readLine()) != null) {
	                // Procesa cada línea del archivo
	                String[] lista = linea.split(","); // Suponiendo que los datos están separados por comas
	                String usuario = lista[0].trim();
	                String contrasena = lista[1].trim();
	                String nombreCompleto = lista[2].trim();
	                ingresaUsuario(conn,usuario,contrasena,nombreCompleto);
	                System.out.println("¡Inserccion Realizada Correctamente! :)");
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 
	 
	 private static boolean ingresaUsuario(Connection conn,String nombreL,String contra,String nombreC) {
		 String consulta="INSERT INTO usuarios(nombreLogin,contrasena,nombreCompleto) VALUES(?,?,?)";
		 if(conn!=null) {
	        	try (PreparedStatement ps =conn.prepareStatement(consulta)){
	                ps.setString(1, nombreL);
	                ps.setString(2, getMD5(contra));
	                ps.setString(3, nombreC);
	                ps.execute();
	                // Todo bien, cerramos ResultSet y devolvemos true
	                ps.close();
	                
	                return true;

	            } catch (SQLException ex) {
	               
	                return false;
	            }
	        }
	        return false;
	    
	 }
	 


	private static String getMD5(String input) {
		 try {
			 MessageDigest md = MessageDigest.getInstance("MD5");
			 byte[] messageDigest = md.digest(input.getBytes());
			 BigInteger number = new BigInteger(1, messageDigest);
			 String hashtext = number.toString(16);
			 while (hashtext.length() < 32) {
				 hashtext = "0" + hashtext;
			 }
			 return hashtext;
			 }
		 catch (NoSuchAlgorithmException e) {
			 throw new RuntimeException(e);
		 	}
	}
	
	


	//Metodo que verifica que se ha iniciado sesion correctamente
	public static boolean inicioCorrecto(Connection conn,String nombreL,String pass) {
		 
			try(PreparedStatement ps =conn.prepareStatement("select nombreLogin,contrasena from usuarios where nombreLogin=? and contrasena=?")){
				ps.setString(1, nombreL);
				ps.setString(2, pass);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {	
					return true;
				}
				return false;
			}catch (SQLException ex) {
	           return false;
	       }
		}

}
	
	
	


