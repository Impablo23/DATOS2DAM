package Ficheros;

import java.io.IOException;

public class FicheroIvan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

        /*Una vez que el fichero esta creado , abriremos el fichero desde aqui , utilizando ProcessBuilder */

        String app = "notepad.exe";

        String archivo = "ciudades.txt";

        String web = "C:\\\\Program Files\\\\Google\\\\Chrome\\\\Application\\\\chrome.exe";

        String url="https://iesplayamar.es";

        try {

            ProcessBuilder procesoAbrir = new ProcessBuilder(app, archivo);

            ProcessBuilder procesoAbrir1 = new ProcessBuilder(web,url);

            Process proceso = procesoAbrir.start();



            // Espera durante 10 segundos

            Thread.sleep(5000);



            // Destruye el proceso del Bloc de notas

            proceso.destroy();

            System.out.println("El proceso " + app + " ha sido destruido");

            /*Una vez destruido el proceso del bloc de notas , abriremos la pagina del iesPlayamar*/

            Process proceso1=procesoAbrir1.start();
            Thread.sleep(5000);
            proceso1.destroy();

          

            

        } catch (IOException ex) {

            System.err.println("Error al abrir el proceso: " + ex.getMessage());

            System.exit(1);

        } catch (InterruptedException ex) {

            System.err.println("Error de interrupción: " + ex.getMessage());

            System.exit(1);

        }

    }





        



	}


