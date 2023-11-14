package Config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Ejer1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Accede a las lineas de fichero de configuracion de mysql para obtener los parámetros de la cadena de conexión
		 * Crear el fichero  mysql.cnf
			user=usuario
			password=micontrasena
			server=localhost
			port=3306
		 */
		Properties configuracion = new Properties();

		try {

		  configuracion.load(new FileInputStream("configuracion.conf"));

		  String usuario = configuracion.getProperty("user");

		  String password = configuracion.getProperty("password");

		  String servidor = configuracion.getProperty("server");

		  Integer puerto = Integer.valueOf(configuracion.getProperty("port"));
		  
		  System.out.println(usuario);
		  System.out.println(password);
		  System.out.println(servidor);
		  System.out.println(puerto);

		} catch (FileNotFoundException fnfe ) { 

		  fnfe.printStackTrace();

		} catch (IOException ioe) { 

		  ioe.printStackTrace();

		}
	}

}
