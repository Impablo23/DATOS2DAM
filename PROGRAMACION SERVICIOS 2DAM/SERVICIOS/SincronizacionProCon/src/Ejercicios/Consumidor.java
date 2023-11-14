package Ejercicios;

public class Consumidor extends Thread{
	
	private Lista l;

	public Consumidor(Lista l) {
		this.l = l;
	}
	
	
	public void run() {
        while (true) {
            // Consume el valor si es posible
            char s = l.consumir();
            System.out.println("Recogido el caracter " + s + " del buffer");
            try {
                // Esperamos entre 0 y 3 segundos
                sleep((int) (Math.random() * 3000));
            } catch (InterruptedException e) {
            	System.out.println(e);
            }
        }
    }
	

}
