package EjercicioJAR;

import java.io.IOException;
import java.util.Scanner;

public class Jar {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Scanner input= new Scanner(System.in);
		
		try {
			Process pro= Runtime.getRuntime().exec(args[0]);
			if(pro.waitFor()==0) {
				System.out.println("Comando OK!!!");
			}else {
				System.out.println("Comando NO OK!!!");
			}
		}catch(IOException e) {
			System.out.println("Error: "+e.getMessage());
		}

	}

}
