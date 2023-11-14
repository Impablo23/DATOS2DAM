package Ejer;

import java.io.IOException;
import java.util.Scanner;

public class EjercicioSincronizacionPing {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Scanner input= new Scanner(System.in);
		try {
			//Añadimos el args[0] para que cuando ejecutamos en jar en el cmd y apliquemos un comnado se le añada en al metodo proceso
			//El argumento args[0] se pone para poner el comando en el cmd con el .jar
			Process pro= Runtime.getRuntime().exec(args[0]);
			int exitV=pro.waitFor();
			if(exitV==0) {
				System.out.println("Comando Correcto :)");
				System.out.println(exitV);
			}else {
				System.out.println("Comando Incorrecto :(");
				System.out.println(exitV);
			}
			
			
		}catch(IOException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}

}
