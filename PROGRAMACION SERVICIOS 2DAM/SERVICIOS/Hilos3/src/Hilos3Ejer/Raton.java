package Hilos3Ejer;
//Lo unico que hemos modificado en la clase Raton es implementar la interfaz Runnable
public class Raton extends Thread{
	
	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public int getTiempoCome() {
		return tiempoCome;
	}



	public void setTiempoCome(int tiempoCome) {
		this.tiempoCome = tiempoCome;
	}



	String nombre;
	int tiempoCome;
	
	public Raton(String string, int i) {
		// TODO Auto-generated constructor stub
		this.nombre=string;
		this.tiempoCome=i;
	}
	
	

	public void run() {
		try {
			System.out.println(this.nombre+" empieza a comer...");
			Thread.sleep(500*this.tiempoCome);
			System.out.println(this.nombre+" termino de comer :)");
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}



	

}
