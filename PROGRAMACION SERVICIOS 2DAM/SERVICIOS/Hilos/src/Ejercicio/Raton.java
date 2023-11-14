package Ejercicio;

public class Raton extends Thread{
	
	String nombre;
	int tiempoCome;
	
	public Raton(String string, int i) {
		// TODO Auto-generated constructor stub
		this.nombre=string;
		this.tiempoCome=i;
	}

	//Metodo run donde el raton empieza a comer y tarde un tiempo determinado en acabar de comer
	public void run() {
		try {
			System.out.println(nombre+" empieza a comer...");
			Thread.sleep(500*tiempoCome);
			System.out.println(nombre+" termino de comer :)");
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
