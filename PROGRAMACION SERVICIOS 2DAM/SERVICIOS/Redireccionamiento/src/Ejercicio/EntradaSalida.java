package Ejercicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class EntradaSalida {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Esta línea crea un nuevo proceso ejecutando el comando "cmd /c dir" en la línea de comandos del sistema operativo. El comando dir se utiliza para mostrar el contenido del directorio actual en sistemas Windows.
		Process pr=Runtime.getRuntime().exec("cmd /c dir");
		//Obtiene el flujo de entrada del proceso. En este caso, obtienes el flujo de entrada del proceso que representa la salida estándar del comando ejecutado.
		InputStream in= pr.getInputStream();
		//leer el flujo de entrada del proceso. Se utiliza InputStreamReader para convertir el flujo de entrada binaria en caracteres legibles.
		BufferedReader br= new BufferedReader(new InputStreamReader(in));
		String lin;
		System.out.println("Listado del proceso padre");
		//Inicia un bucle while que continuará mientras haya líneas para leer del flujo de entrada. readLine() lee una línea completa de texto del flujo de entrada.
		while ((lin= br.readLine()) != null) {
			System.out.println(lin);
		}

	}

}
