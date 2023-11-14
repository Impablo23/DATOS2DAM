package Conex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class BDPrimeraConex {
	
	public static void conectar(Connection conn) {
		try {
			conn=DriverManager.getConnection("jdbc:sqlite:primera.db");
			System.out.println("Conexion SQLITE correcta :)");
		}catch(SQLException e) {
			System.err.println(e.getMessage());
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
	

	//Metodo que inserta un cliente a la tabla
		 public static boolean insertarCliente(Connection conn,int id,String nom,String ape,String tlf) {
			 String consulta="INSERT INTO cliente(id,nombre,apellidos,telefono) VALUES(?,?,?,?)";
		        if(conn!=null) {
		        	try (PreparedStatement ps =conn.prepareStatement(consulta)){
		        		
		                // Obtenemos la tabla clientes
		                System.out.print("Insertando al cliente numero " + id  + "...");
		                // Insertamos el nuevo registro
		                ps.setInt(1,id);
		                ps.setString(2, nom);
		                ps.setString(3,ape);
		                ps.setString(4,tlf);
		                
		                
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
		//Imprime la tabla cliente
		 public static void printTablaCliente(Connection conn) {
		        try (PreparedStatement s= conn.prepareStatement("SELECT * from cliente")){
		            ResultSet rs=s.executeQuery();
		            while (rs.next()) {
		                String id = rs.getString("id");
		                String n = rs.getString("nombre");
		                String d = rs.getString("apellidos");
		                String sa=rs.getString("telefono");
		                System.out.println(id + "\t" + n + "\t" + d+ "\t" +sa);
		            }
		            rs.close();
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		    }
		 
		//Imprime la tabla cliente segun el nombre
		 public static void printTablaClienteNombre(Connection conn,String nom) {
		        try (PreparedStatement s= conn.prepareStatement("SELECT * from cliente where nombre=?")){
		        	s.setString(1, nom);
		            ResultSet rs=s.executeQuery();
		            if(rs.next()) {
		            	System.out.println("Cliente: "+nom);
		                String id = rs.getString("id");
		                String n = rs.getString("nombre");
		                String d = rs.getString("apellidos");
		                String sa=rs.getString("telefono");
		                System.out.println(id + "\t" + n + "\t" + d+ "\t" +sa);
		            }else {
		            	System.out.println("El cliente: "+nom+" no se ha encontrado en la base de datos");
		            }
		            rs.close();
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		    }
		 
		 
	
		//Metodo que inserta un socio a la tabla
		 public static boolean insertarSocio(Connection conn,int id,String nom,String ape,String tlf) {
			 String consulta="INSERT INTO socio(id,nombre,apellidos,telefono) VALUES(?,?,?,?)";
		        if(conn!=null) {
		        	try (PreparedStatement ps =conn.prepareStatement(consulta)){
		        		
		                // Obtenemos la tabla clientes
		                System.out.print("Insertando al socio numero " + id  + "...");
		                // Insertamos el nuevo registro
		                ps.setInt(1,id);
		                ps.setString(2, nom);
		                ps.setString(3,ape);
		                ps.setString(4,tlf);
		                
		                
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
		 
		//Imprime la tabla socio
		 public static void printTablaSocio(Connection conn) {
		        try (PreparedStatement s= conn.prepareStatement("SELECT * from socio")){
		            ResultSet rs=s.executeQuery();
		            while (rs.next()) {
		                String id = rs.getString("id");
		                String n = rs.getString("nombre");
		                String d = rs.getString("apellidos");
		                String sa=rs.getString("telefono");
		                System.out.println(id + "\t" + n + "\t" + d+ "\t" +sa);
		            }
		            rs.close();
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		    }
		//Imprime la tabla socio segun el nombre
		 public static void printTablaSocioNombre(Connection conn,String nom) {
		        try (PreparedStatement s= conn.prepareStatement("SELECT * from socio where nombre=?")){
		        	s.setString(1, nom);
		            ResultSet rs=s.executeQuery();
		            System.out.println("Socio: "+nom);
		            if (rs.next()) {
		            	System.out.println("Socio: "+nom);
		                String id = rs.getString("id");
		                String n = rs.getString("nombre");
		                String d = rs.getString("apellidos");
		                String sa=rs.getString("telefono");
		                System.out.println(id + "\t" + n + "\t" + d+ "\t" +sa);
		            }else {
		            	System.out.println("El cliente: "+nom+" no se ha encontrado en la base de datos");
		            }
		            rs.close();
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		    }
		 
		//Metodo que inserta un alumno a la tabla
		 public static boolean insertarAlumno(Connection conn,int id,String nom,String ape,String tlf) {
			 String consulta="INSERT INTO alumno(id,nombre,apellidos,telefono) VALUES(?,?,?,?)";
		        if(conn!=null) {
		        	try (PreparedStatement ps =conn.prepareStatement(consulta)){
		        		
		                // Obtenemos la tabla clientes
		                System.out.print("Insertando al alumno numero " + id  + "...");
		                // Insertamos el nuevo registro
		                ps.setInt(1,id);
		                ps.setString(2, nom);
		                ps.setString(3,ape);
		                ps.setString(4,tlf);
		                
		                
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
		 
		//Imprime la tabla alumno
		 public static void printTablaAlumno(Connection conn) {
		        try (PreparedStatement s= conn.prepareStatement("SELECT * from alumno")){
		            ResultSet rs=s.executeQuery();
		            while (rs.next()) {
		                String id = rs.getString("id");
		                String n = rs.getString("nombre");
		                String d = rs.getString("apellidos");
		                String sa=rs.getString("telefono");
		                System.out.println(id + "\t" + n + "\t" + d+ "\t" +sa);
		            }
		            rs.close();
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		    }
		 
		//Imprime la tabla alumno segun el nombre
		 public static void printTablaAlumnoNombre(Connection conn,String nom) {
		        try (PreparedStatement s= conn.prepareStatement("SELECT * from alumno where nombre=?")){
		        	s.setString(1, nom);
		            ResultSet rs=s.executeQuery();
		            System.out.println("Alumno: "+nom);
		            if (rs.next()) {
		            	System.out.println("Alumno: "+nom);
		                String id = rs.getString("id");
		                String n = rs.getString("nombre");
		                String d = rs.getString("apellidos");
		                String sa=rs.getString("telefono");
		                System.out.println(id + "\t" + n + "\t" + d+ "\t" +sa);
		            }else {
		            	System.out.println("El cliente: "+nom+" no se ha encontrado en la base de datos");
		            }
		            rs.close();
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		    }
}
