package Conex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class primeraConex {

	public static void main(String[] args)throws SQLException {
		// TODO Auto-generated method stub
		Scanner input= new Scanner (System.in);
		Connection conex=null;
		
		try {
			conex=DriverManager.getConnection("jdbc:sqlite:primera.db");
			System.out.println("Conexion SQLITE correcta :)");
			int num=1;
			 do{
				menu();
				num=input.nextInt();input.nextLine();
				if(num==1) {
					System.out.println();
					System.out.println("tabla de clientes:");
					BDPrimeraConex.printTablaCliente(conex);
				}else if(num==2){
					System.out.println("introduce un nombre:");
					String nom=input.nextLine();
					BDPrimeraConex.printTablaClienteNombre(conex, nom);
				}else if(num==3) {
					System.out.println("introduce un id:");
					int id=input.nextInt();input.nextLine();
					System.out.println("introduce un nombre:");
					String nom=input.nextLine();
					System.out.println("introduce unos apellidos:");
					String ape=input.nextLine();
					System.out.println("introduce un telefono:");
					String tlf=input.nextLine();
					BDPrimeraConex.insertarCliente(conex, id, nom, ape, tlf);
				}else if(num==4) {
					System.out.println();
					System.out.println("tabla de socios:");
					BDPrimeraConex.printTablaSocio(conex);
				}else if(num==5) {
					System.out.println("introduce un nombre:");
					String nom=input.nextLine();
					BDPrimeraConex.printTablaSocioNombre(conex, nom);
				}else if(num==6) {
					System.out.println("introduce un id:");
					int id=input.nextInt();input.nextLine();
					System.out.println("introduce un nombre:");
					String nom=input.nextLine();
					System.out.println("introduce unos apellidos:");
					String ape=input.nextLine();
					System.out.println("introduce un telefono:");
					String tlf=input.nextLine();
					BDPrimeraConex.insertarSocio(conex, id, nom, ape, tlf);
				}else if(num==7) {
					System.out.println();
					System.out.println("tabla de alumnos:");
					BDPrimeraConex.printTablaAlumno(conex);
				}else if(num==8) {
					System.out.println("introduce un nombre:");
					String nom=input.nextLine();
					BDPrimeraConex.printTablaAlumnoNombre(conex, nom);
				}else if(num==9) {
					System.out.println("introduce un id:");
					int id=input.nextInt();input.nextLine();
					System.out.println("introduce un nombre:");
					String nom=input.nextLine();
					System.out.println("introduce unos apellidos:");
					String ape=input.nextLine();
					System.out.println("introduce un telefono:");
					String tlf=input.nextLine();
					BDPrimeraConex.insertarAlumno(conex, id, nom, ape, tlf);
				}else if(num==10) {
					System.out.println("gracias por usar este programa :)");
				}
			}while (num>0 && num<10);
			 BDPrimeraConex.close(conex);
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
		
		
	}
	
	public static void menu() {
		System.out.println("TABLA DE OPCIONES DE LA BASE DE DATOS primera.db");
		System.out.println("MOSTRAR CLIENTES (1)");
		System.out.println("MOSTRAR CLIENTES POR SU NOMBRE (2)");
		System.out.println("INSERTAR CLIENTES (3)");
		System.out.println("MOSTRAR SOCIOS (4)");
		System.out.println("MOSTRAR SOCIOS POR SU NOMBRE (5)");
		System.out.println("INSERTAR SOCIOS (6)");
		System.out.println("MOSTRAR ALUMNOS (7)");
		System.out.println("MOSTRAR ALUMNOS POR SU NOMBRE (8)");
		System.out.println("INSERTAR ALUMNOS (9)");
		System.out.println("SALIR DEL PROGRAMA (10)");
		System.out.println("Inserte el numero de la accion deseada:");
	}

}
