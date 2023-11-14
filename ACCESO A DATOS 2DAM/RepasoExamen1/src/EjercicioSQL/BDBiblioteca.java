package EjercicioSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BDBiblioteca {
	
	//Imprime la tabla libros
		 public static void printTablaLibros(Connection conn) {
		        try (PreparedStatement s= conn.prepareStatement("SELECT * from libro")){
		            ResultSet rs=s.executeQuery();
		            System.out.println("\nTABLA DE LIBROS DE LA BIBLIOTECA: ");
		            while(rs.next()) {
		                int id = rs.getInt("id");
		                String n = rs.getString("titulo");
		                String a = rs.getString("autor");
		                String d = rs.getString("disponible");
		                System.out.println("Cod del Libro: "+id + "\nNombre: " + n + "\nAutor: " + a+ "\nDisponible: " +d+"\n");
		            }
		            rs.close();
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		    }
		 
		//Imprime la tabla usuarios
		 public static void printTablaUsuarios(Connection conn) {
		        try (PreparedStatement s= conn.prepareStatement("SELECT * from usuario")){
		            ResultSet rs=s.executeQuery();
		            System.out.println("\nTABLA DE USUARIOS DE LA BIBLIOTECA: ");
		            while(rs.next()) {
		                int id = rs.getInt("id");
		                String n = rs.getString("nombre");
		                String a = rs.getString("email");
		                System.out.println("Cod del Usuario: "+id + "\nNombre: " + n + "\nEmail: " + a+ "\n");
		            }
		            rs.close();
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		    }
		 
		//Imprime la tabla prestamos
		 public static void printTablaPrestamos(Connection conn) {
		        try (PreparedStatement s= conn.prepareStatement("SELECT * from prestamo")){
		            ResultSet rs=s.executeQuery();
		            System.out.println("\nPRESTAMOS REALIZADOS EN LA BIBLIOTECA: ");
		            while(rs.next()) {
		                int idp = rs.getInt("idPrestamo");
		                int idu = rs.getInt("idUsuario");
		                int idl = rs.getInt("idLibro");
		               
		                System.out.println("Prestamo numero: "+idp + "\t Codigo del Usuario: " + idu + "\t Codigo del Libro: " + idl);
		            }
		            rs.close();
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		    }
		 
	private static boolean verificaUsuario(Connection conn,int codUsuario) {
		try(PreparedStatement s= conn.prepareStatement("SELECT id from usuario where id=?")){
			s.setInt(1, codUsuario);
			ResultSet rs=s.executeQuery();
			if(rs.next()) {
				return true;
			}
			return false;
		}catch(SQLException e) {
			return false;
		}
	}
		 
		 //Metodo que inserta un prestamo de un libro si esta disponible en la biblioteca
	public static boolean insertarPrestamo(Connection conn,int codUsuario,int codLibro) {
		try(PreparedStatement s= conn.prepareStatement("SELECT disponible from libro where id=?")){
			s.setInt(1, codLibro);
			ResultSet rs=s.executeQuery();
			if(rs.next()) {
				String respuesta=rs.getString("disponible");
				if(respuesta.equalsIgnoreCase("si") && verificaUsuario(conn, codUsuario)==true) {
					PreparedStatement prestamo= conn.prepareStatement("insert into prestamo (idUsuario,idLibro) values (?,?)");
					prestamo.setInt(1, codUsuario);
					prestamo.setInt(2, codLibro);
					prestamo.execute();
					PreparedStatement noDisponible= conn.prepareStatement("update libro set disponible='no' where id=?");
					noDisponible.setInt(1, codLibro);
					noDisponible.execute();
					return true;
				}else if(respuesta.equalsIgnoreCase("no")) {
					return false;
				}
			}
			return false;
		}catch(SQLException e) {
			return false;
		}
	}
	
	 //Metodo que inserta devuelve un libro a la biblioteca acabando el prestamo
	public static boolean devolucion(Connection conn,int codLibro) {
		try(PreparedStatement s= conn.prepareStatement("SELECT disponible from libro where id=?")){
			s.setInt(1, codLibro);
			ResultSet rs=s.executeQuery();
			if(rs.next()) {
				String respuesta=rs.getString("disponible");
				if(respuesta.equalsIgnoreCase("no")) {
					PreparedStatement prestamo= conn.prepareStatement("delete from prestamo where idLibro=?");
					prestamo.setInt(1, codLibro);
					prestamo.execute();
					PreparedStatement noDisponible= conn.prepareStatement("update libro set disponible='si' where id=?");
					noDisponible.setInt(1, codLibro);
					noDisponible.execute();
					return true;
				}else if(respuesta.equalsIgnoreCase("no")) {
					return false;
				}
			}
			return false;
		}catch(SQLException e) {
			return false;
		}
	}
}
/*
Crea una clase Libro con propiedades id, titulo, autor y disponible.
Crea una clase Usuario con propiedades id, nombre y email.
Crea una clase ConexionBD que maneje la conexión a la base de datos usando JDBC.
Implementa métodos para:
Agregar un nuevo libro a la base de datos.
Mostrar todos los libros disponibles en la biblioteca.
Permitir a un usuario tomar prestado un libro (esto debería actualizar el estado de disponibilidad del libro en la base de datos).
Mostrar los libros prestados por un usuario específico.
Devolver un libro (esto debería actualizar el estado de disponibilidad del libro en la base de datos).*/