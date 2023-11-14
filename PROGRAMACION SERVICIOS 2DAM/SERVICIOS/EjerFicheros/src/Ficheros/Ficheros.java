package Ficheros;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ficheros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input= new Scanner(System.in);
		FileWriter fichero;
		ArrayList<String> nombres= new ArrayList<String>();
		int num=0;
		String nombre;
		 do{
			System.out.println("Deseas Introducir un nombre o ciudad o no(0)");
			num=input.nextInt();input.nextLine();
			if(num!=0) {
				System.out.println("Escribe nombre o ciudad:");
				nombre=input.nextLine();
				nombres.add(nombre);
			}
			
			
		}while (num!=0);
		/*for (String s : nombres) {
			System.out.println(s.toString());
		}*/
		 
		try {
			fichero= new FileWriter("ciudades.txt");
			BufferedWriter escribe= new BufferedWriter(fichero);
			int lineas=0;
			System.out.println("palabras introducidas en la lista:");
			for (String s : nombres) {
				escribe.write(s.toString()+"\n");
				lineas++;
			}
			escribe.close();
			System.out.println("Escritura hecha correctamente :)");
			System.out.println("Numero de lineas: "+lineas);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		

	}

}

