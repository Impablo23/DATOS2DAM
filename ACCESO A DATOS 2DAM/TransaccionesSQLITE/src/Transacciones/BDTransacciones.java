package Transacciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class BDTransacciones {
	
	//Metodo que inserta un pedido a la tabla
	 public static boolean insertarPedido(Connection conn,int cod,int cliente,int articulo,int cantidad) {
		 String consulta="INSERT INTO pedidos(codPedido,fecha,codCliente,codArticulo,cantidad) VALUES(?,?,?,?,?)";
		 LocalDate fechaActual = LocalDate.now();
		 Date fechaSQL = java.sql.Date.valueOf(fechaActual);
		 if(conn!=null) {
	        	try (PreparedStatement ps =conn.prepareStatement(consulta)){
	        		
	                // Obtenemos la tabla clientes
	                System.out.print("Insertando el pedido numero " +cod+ "...");
	                // Insertamos el nuevo registro
	                ps.setInt(1,cod);
	                ps.setDate(2, (java.sql.Date) fechaSQL);
	                ps.setInt(3,cliente);
	                ps.setInt(4,articulo);
	                ps.setInt(5,cantidad);
	                
	                
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
	 
	//Imprime la tabla pedidos
	 public static void printTablaPedidos(Connection conn) {
	        try (PreparedStatement s= conn.prepareStatement("SELECT * from pedidos")){
	            ResultSet rs=s.executeQuery();
	            System.out.println("tabla de pedidos: ");
	            while(rs.next()) {
	                int id = rs.getInt("codPedido");
	                String n = rs.getString("fecha");
	                int d = rs.getInt("codCliente");
	                int sa = rs.getInt("codArticulo");
	                int i = rs.getInt("cantidad");
	                System.out.println("Cod del Pedido: "+id + "\t Fecha: " + n + "\t Cod del Cliente: " + d+ "\t Cod del Articulo: " +sa+ "\t Cantidad: "+i);
	            }
	            rs.close();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }
	 
	
		 
		//Imprime la tabla existencias
		 public static void printTablaExistencias(Connection conn) {
		        try (PreparedStatement s= conn.prepareStatement("SELECT * from existencias")){
		            ResultSet rs=s.executeQuery();
		            System.out.println("Carta del Restaurante: ");
		            while(rs.next()) {
		                int id = rs.getInt("codArticulo");
		                String n=rs.getString("descripcion");
		                int d = rs.getInt("existencias");
		                double sa=rs.getDouble("precio");
		                System.out.println("Codigo Articulo: "+id+" ;Descripcion: "+n+" ;Unidades: "+d+" ;Precio: "+sa);
		            }
		            rs.close();
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		    }
		 
		//Metodo que inserta un pedido a la tabla
		 public static boolean insertarEnvio(Connection conn,int pedido,int rider,boolean terminado) {			 
			 String consulta="INSERT INTO envios(codPedido,codRider,terminado) VALUES(?,?,?)";
			 if(conn!=null) {
		        	try (PreparedStatement ps =conn.prepareStatement(consulta)){
		        		
		                // Obtenemos la tabla clientes
		                System.out.print("Insertando el envio numero " +pedido+ "...");
		                // Insertamos el nuevo registro
		                ps.setInt(1,pedido);
		                ps.setInt(2, rider);
		                ps.setBoolean(3, terminado);
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
		 
		//Imprime la tabla envios
		 public static void printTablaEnvios(Connection conn) {
		        try (PreparedStatement s= conn.prepareStatement("SELECT * from envios")){
		            ResultSet rs=s.executeQuery();
		            System.out.println("tabla de envios: ");
		            while(rs.next()) {
		                int id = rs.getInt("codPedido");
		                int n = rs.getInt("codRider");
		                int d = rs.getInt("existencias");
		                double sa=rs.getDouble("precio");
		                System.out.println(id + "\t" + n + "\t" + d+ "\t" +sa);
		            }
		            rs.close();
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
		    }
		 
		 //Metodo que hace la transaccion en las existencias.
		 public static void transaccion(Connection conn,int codArt,int cantidad) {
			 
			 LocalDate fechaActual = LocalDate.now();
			 Date fechaSQL = java.sql.Date.valueOf(fechaActual);
			 try {
				 conn.setAutoCommit(false);
				 
				 String update="update existencias set existencias=existencias-? where codArticulo=?";
				 PreparedStatement up= conn.prepareStatement(update);
				 up.setInt(1, cantidad);
				 up.setInt(2,codArt);
				 up.execute();
				 
				 String consulta="select existencias from existencias where codArticulo=?";
				 PreparedStatement c= conn.prepareStatement(consulta);
				 c.setInt(1, codArt);
				 ResultSet rs=c.executeQuery();
				 if(rs.next()) {
					 int resultado=rs.getInt("existencias");
					 if (resultado<=cantidad) {
						 System.out.println("Pedido Denegado porque has pedido mas de los"+resultado+" articulos que tenemos disponibles :)");
						 conn.rollback();
						 
					 }else {
						 String pedido2="insert into pedidos (fecha,codCliente,codArticulo,cantidad) values (?,?,?,?)";
						 try (PreparedStatement p = conn.prepareStatement(pedido2)){
							 p.setString(1, fechaSQL.toString());
							 p.setInt(2, 1);
							 p.setInt(3,codArt);
							 p.setInt(4, cantidad);
							 p.executeUpdate();
							 System.out.println("Pedido Realizado con Exito !!");
							 
						 }catch(SQLException e) {
							 e.printStackTrace();
						 }
						 conn.commit();
						
						 
					 }
				 }
				 
				 
				
			 }catch(Exception e) {
				 e.getMessage();
			 }
		 }
}




