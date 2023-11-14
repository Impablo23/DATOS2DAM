package Ejercicios;

import java.util.ArrayList;

public class Lista {
	
	private char[] lista;
	private int siguiente;
	private boolean estaVacia;
	private boolean estaLlena;

	
	public Lista(int longitud) {
		this.lista = new char[longitud];
		this.siguiente = 0;
		this.estaVacia = true;
		this.estaLlena = false;
	}

	public synchronized char consumir() {
		while(estaVacia==true) {
			// No se puede consumir si el buffer está vacío
			try {
                wait(); // Se sale cuando estaVacia cambia a false
            } catch (InterruptedException e) {
            	System.out.println(e);
            }
			
		}
		// Decrementa la cuenta, ya que va a consumir una letra
			siguiente--;
		// El array no puede estar lleno, porque acabamos
		// de consumir  
		if (siguiente == 0) {
            estaVacia = true;
        }
		estaLlena = false;
		 notifyAll();
		 // Devuelve la palabra al thread consumidor
	     return (lista[siguiente]);
	}
	
	// Método para añadir letras al buffer
    public synchronized void producir(char s) {
        // Espera hasta que haya sitio para otra letra
        while (estaLlena == true) {
            try {
                wait(); // Se sale cuando estaLlena cambia a false
            } catch (InterruptedException e) {
             
            }
        }
        // Añade una letra en el primer lugar disponible
        lista[siguiente]=s;
        // Cambia al siguiente lugar disponible
        siguiente++;
        estaVacia = false;
     // Comprueba si el buffer está lleno
        if (siguiente == this.lista.length) {
            estaLlena = true;
        }
        notifyAll();
    }
	

}
