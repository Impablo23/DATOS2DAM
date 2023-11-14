package Ejercicio;


import org.hibernate.Session;
public class HibernatePrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session sesion = Conexion.getSessionFactory().openSession();
		String sql = "SELECT VERSION()";
		String resultado = (String) sesion.createNativeQuery(sql).getSingleResult();
		System.out.println("La versión que estás usando es: " + resultado);
		
		 Conexion.getSessionFactory().close();
	}

}
