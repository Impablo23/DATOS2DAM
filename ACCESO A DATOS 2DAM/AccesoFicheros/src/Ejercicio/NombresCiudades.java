package Ejercicio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class NombresCiudades {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input= new Scanner(System.in);
		//Creamos un fichero de escritura donde mostraremos los nombres introducidos en la lista de "nombres"
		FileWriter fichero;
		ArrayList<String> nombres= new ArrayList<String>();
		int num=0;
		String nombre;
		//Do-While para pedir al usuario nombres hasta que introduzca el 0, cada ve que introduzca un nombre, se añadira a la lista
		 do{
			System.out.println("Deseas Introducir un nombre o ciudad(Cualquier numero) o no(0)");
			num=input.nextInt();input.nextLine();
			if(num!=0) {
				System.out.println("Escribe nombre o ciudad:");
				nombre=input.nextLine();
				nombres.add(nombre);
			}
			
			
		}while (num!=0);
		 
		//Empezamos a escribir los nombres en un documento de texto
		try {
			//al fichero FileWriter le damos un .txt para despues aplicarle ese mismo fichero al BufferedWriter
			fichero= new FileWriter("nombres.txt");
			BufferedWriter escribe= new BufferedWriter(fichero);
			escribe.write("Ciudades Introducidas:");
			escribe.newLine();
			//Escribimos los nombres en el .txt
			for (String s : nombres) {
				escribe.write(s.toString());
				escribe.newLine();
			}
			//Cerramos el BufferedWriter
			escribe.close();
			System.out.println("Escritura hecha correctamente :)");
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		

	}

}
