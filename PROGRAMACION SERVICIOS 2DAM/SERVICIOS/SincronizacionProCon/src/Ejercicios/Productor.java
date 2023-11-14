package Ejercicios;

import java.util.ArrayList;

public class Productor extends Thread{
	
	private Lista l;
	private final String abecedario="abcdefghijklmnñopqrstuvwxyz";

	public Productor(Lista l) {
		this.l = l;
		
	}
	
	public void run() {
        while (true) {
            // Obtenemos una letra al azar
        	char c = abecedario.charAt((int) (Math.random() * abecedario.length()));
            // Producimos un valor
            l.producir(c);
            System.out.println("Depositado el caracter " + c + " a la lista");
            try {
                // Esperamos entre 0 y 3 segundos 
                sleep((int) (Math.random() * 3000));
            } catch (InterruptedException e) {
            	System.out.println(e);
            }
        }
    }

}
