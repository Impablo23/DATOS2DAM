package EjercicioProcesos;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Procesos {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Scanner input= new Scanner(System.in);
		//Ruta del Chrome
		String chrome="C:\\\\Program Files\\\\Google\\\\Chrome\\\\Application\\\\chrome.exe";
		String notepad="notepad.exe";
		//Pedimos al usuario una ip y la verificamos
		System.out.println("Introduce una ip: ");
		String ip=input.nextLine();
		String url="https://"+ip;
		String comando="ping -n 1 "+ip;
		//Se verifica y si es correcta se le redirige a la pagina de google chrome con el url de esa ip sino se escribe la ip en el fichero de las ip incorrectas
		try {
			Process pro= Runtime.getRuntime().exec(comando);
			int exitV=pro.waitFor();
			if(exitV==0) {
				System.out.println("DIRECCION IP CORRECTA,REDIRIGIENDO A LA PAGINA...");
				ProcessBuilder bloc = new ProcessBuilder(chrome,url);
				Process uno = bloc.start();
			}else {
				System.err.println("ERROR DE IP");
				FileWriter fichero=new FileWriter("ip.txt",true);
				fichero.write("IP Desconocida Introducida: "+ip+"\n");
				fichero.close();
				ProcessBuilder bloc = new ProcessBuilder(notepad,"ip.txt");
				Process uno = bloc.start();
				
				
			}
		}catch(IOException e) {
			System.out.println("Error: "+e.getMessage());
		}

	}

}
