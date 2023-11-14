package Directorio;

import java.io.File;

public class Ejercicio {

	public static void main(String[] args) {
		// TODO Auto-genera ted method stub
		//Creammos dos rutas, una de un directorio y otra de un archivo.
		String txt="C:\\Users\\pablo\\Desktop\\ACCESO A DATOS 2DAM\\AccesoDirectorio\\textos";
		String txt1="C:\\Users\\pablo\\Desktop\\ACCESO A DATOS 2DAM\\AccesoDirectorio\\textos\\uno.txt";
		//Creamos dos ficheros
		File directorio= new File(txt);
		File fichero= new File(txt1);
		//Mostramos por la consola si es un directorio (true) o no (false)
		System.out.println(directorio.isDirectory());
		//Guardamos un una array los archivos del directorio "textos"
		String[] lista=directorio.list();
		//Mostramos los archivos de la carpeta "textos"
		for(int i=0;i<lista.length;i++) {
			System.out.println(lista[i]);
		}
		//Condicion para ver si el archivo es un directorio o no
		if(directorio.isDirectory()) {
			System.out.println("Esto es un directorio :)");
		}else {
			System.out.println("Esto NO es un directorio :/");
		}
		//Condicion para ver si el archivo es un fichero o no
		if(fichero.isFile()) {
			System.out.println("Esto es un fichero :)");
		}else {
			System.out.println("Esto NO es un fichero :/");
		}
		//Condicion para ver si el fichero es de escritura o no
		if(fichero.canWrite()) {
			System.out.println("Esto es un fichero en el que se puede escribir :)");
		}else {
			System.out.println("Esto es un fichero en el que NO se puede escribir :/");
		}
		//Condicicon para ver si el fichero existe o no 
		if(fichero.exists()) {
			System.out.println("Este fichero EXISTE :)");
		}else {
			System.out.println("Este fichero NO EXISTE :/");
		}

	}

}
