package Examen;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class GestionEntradas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=null;
		Scanner input=new Scanner(System.in);
		int num=0;
		while(num!=4) {
			try {
				//Conctamos a la base de datos
				conn=DriverManager.getConnection("jdbc:sqlite:cine.db");
				System.out.println("Conexion SQLITE correcta :)");
				menu();
				num=input.nextInt();input.nextLine();
				if(num==1) {
					//Damos de alta a un nuevo user
					System.out.println("Dime tu nombre:");
					String nom=input.nextLine();
					System.out.println("Dime tu nombre de usuario:");
					String user=input.nextLine();
					System.out.println("Escribe una contraseña:");
					String pass=input.nextLine();
					BDEntradas.insertarUsuario(conn, user, pass, nom);
				}else if(num==2) {
					//Incicio de Sesion de el user
					System.out.println("nombre de usuario: ");
					String user=input.nextLine();
					System.out.println("contraseña: ");
					String pass=input.nextLine();
					if(BDEntradas.inicioCorrecto(conn, user, pass)==true) {
						menuInicioSesion(user);
						int valor=input.nextInt();input.nextLine();
						if(valor==1) {
							BDEntradas.printTablaEntradas(conn);
						}else if(num==2) {
							System.out.println("Cerrando Sesion...");
						}
					}else {
						//Copiamos info de los errores
						FileWriter errores= new FileWriter("erorres.txt");
						BDEntradas.ficheroErrores(errores, user);
					}
				}else if(num==3) {
					//Eliminamos user
					System.out.println("Dime el codigo del usuario que deseas eliminar: ");
					int cod=input.nextInt();input.nextLine();
					BDEntradas.eliminaUser(conn, cod);
				}
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		

	}
	
	public static void menu() {
		System.out.println("1) Alta a un nuevo usuario:");
		System.out.println("2) Iniciar Sesion:");
		System.out.println("3) Borrar Usuario:");
		System.out.println("4) Salir:");
		System.out.println("Indice la opcion deseada: ");
	}
	
	public static void menuInicioSesion(String user) {
		System.out.println("Inicio de Sesion con la cuenta: "+user);
		System.out.println("1) Registro de Inicios de Sesion:");
		System.out.println("2) Salir:");
		System.out.println("Indice la opcion deseada: ");
	}

}
