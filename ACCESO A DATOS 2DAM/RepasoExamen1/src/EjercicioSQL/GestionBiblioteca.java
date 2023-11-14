package EjercicioSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class GestionBiblioteca {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conex=null;
		Scanner input= new Scanner(System.in);
		try {
			conex=DriverManager.getConnection("jdbc:sqlite:biblioteca.db");
			System.out.println("Conexion SQLITE correcta :)");
			BDBiblioteca.printTablaLibros(conex);
			BDBiblioteca.printTablaUsuarios(conex);
			System.out.println("Cod usuario para el prestamo:");
			int codU=input.nextInt();input.nextLine();
			System.out.println("Cod libro para el prestamo:");
			int codL=input.nextInt();input.nextLine();
			System.out.println(BDBiblioteca.insertarPrestamo(conex, codU, codL));
			System.out.println("Que libro deseas devolver (dime su codigo)");
			int codLD=input.nextInt();input.nextLine();
			BDBiblioteca.devolucion(conex, codLD);
			BDBiblioteca.printTablaPrestamos(conex);
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
