package Ejercicio1;
//PABLO RICO MACHIO 2DAM PROCESOS
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ejer1 {
	public static void main(String[] args) throws IOException, InterruptedException {

		Scanner input= new Scanner(System.in);
		String arg="notepad.exe";
		String note="nombres.txt";
		String chrome="C:\\\\Program Files\\\\Google\\\\Chrome\\\\Application\\\\chrome.exe";
		String ies="https://iesplayamar.es";
		//No te puedo ponder la captura porque tengo una version diferente
		try {
			//abrimos el bloc de notas y el especifico
			ProcessBuilder bloc = new ProcessBuilder(arg,note);
			Process uno = bloc.start();
			//Lo dejamos abierto un tiempo y los destruimos
			Thread.sleep(1000);
			uno.destroyForcibly(); 
			
			System.out.println("EL proceso se ha destruido :)");
			//Creamos el proceso de abrir la pagina del insti
			ProcessBuilder web = new ProcessBuilder(chrome,ies);
			Process dos=web.start();
		}catch (Exception e){
			e.getStackTrace();
		}
		 
		 
	}
}