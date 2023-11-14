package Examen;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class BDEntradas {
	
	//Metodo que verifica si el nombreLogin existe
	public static boolean verificaUser(Connection conn,String user) {
		try(PreparedStatement ps =conn.prepareStatement("select codUser from usuarios where nombreLogin=?")){
			ps.setString(1, user);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return false;
			}else {
				return true;
			}
		}catch (SQLException ex) {
            return false;
        }
	}
	
	
	
	
	//Metodo que inserta un usuario
		 public static void insertarUsuario(Connection conn,String nombreL,String pass,String nombreC) {
			 String consulta="INSERT INTO usuarios(nombreLogin,contrasena,nombreCompleto) VALUES(?,?,?)";
			 if(conn!=null) {
				 if(verificaUser(conn,nombreL)==true) {
					 try (PreparedStatement ps =conn.prepareStatement(consulta)){
						   ps.setString(1, nombreL);
			               ps.setString(2, pass);
			               ps.setString(3, nombreC);
			               ps.execute();
			               System.out.println("Usuario Insertado Correctamente :)");
		                
					 }catch (SQLException ex) {
						 System.out.println("Usuario NO Insertado  :)");
			                
					 }
				 }else {
					 System.out.println("Usuario NO Insertado  :)");
				 }
		     }
		       
		    
		 }
		 
		 
	//Metodo que verifica que se ha iniciado sesion correctamente
		 public static boolean inicioCorrecto(Connection conn,String nombreL,String pass) {
			 
				try(PreparedStatement ps =conn.prepareStatement("select nombreLogin,contrasena from usuarios where nombreLogin=? and contrasena=?")){
					ps.setString(1, nombreL);
					ps.setString(2, pass);
					ResultSet rs=ps.executeQuery();
					if(rs.next()) {	
						PreparedStatement is =conn.prepareStatement("insert into entradas (contador_entradas,hora_ultima_entrada) values (?,?)");
						is.setInt(1, (int)Math.random()*100);
						is.setString(2, LocalDateTime.now().toString());
						is.execute();
						return true;
					}
					return false;
				}catch (SQLException ex) {
		            return false;
		        }
			}
		 
	//Metodo que muestra las entradas de inicio de sesion
		 
		 public static void printTablaEntradas(Connection conn) {
		        try (PreparedStatement s= conn.prepareStatement("SELECT * from entradas")){
		            ResultSet rs=s.executeQuery();
		            System.out.println("Registro de Entradas: ");
		            while(rs.next()) {
		                int cod=rs.getInt("codUser");
		                int contador=rs.getInt("contador_entradas");
		                String hora=rs.getString("hora_ultima_entrada");
		                System.out.println("Codigo del Usuario: "+cod+"\t ,Numero de Incicios de Sesion: "+contador+"\t y Ultima hora de el ultimo inicio de sesion: "+hora);
		            }
		            rs.close();
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		    }
		 
	//Metodo que si da error en el inicio de sesion se graba en un fichero
		 public static void ficheroErrores(FileWriter f,String user) {
			 try{
				 f.write("Hora del error al usuario: "+user+" : "+LocalDateTime.now().toString());
				 System.out.println("Copiado Correctamente :)");
				 f.close();
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
			 
		 }
		 
	//metodo que borra un usuario y sus entradas
		 public static void eliminaUser(Connection conn,int codUser) {
			 try {
				 PreparedStatement u= conn.prepareStatement("delete from usuarios where codUser=?");
				 u.setInt(1, codUser);
				 u.execute();
				 PreparedStatement e= conn.prepareStatement("delete from entradas where codUser=?");
				 e.setInt(1, codUser);
				 e.execute();
				 System.out.println("Eliminacion del usuario "+codUser+" Realizada con Exito!!");
			 } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		 }
		 
	
		 
		

}
