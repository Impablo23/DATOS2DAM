package EjerciciosVehiculos;

public class Vehiculo extends Thread{
	
	public String nombre;
	public int distancia;
	
	
	public Vehiculo(String nombre, int distancia) {
		super();
		this.nombre = nombre;
		this.distancia = distancia;
	}
	
	//Metodo run que muestra km por km un mensaje de los kilometros que esta recorriendo hasta su destino
	public void run() {
		for(int i=1;i<=distancia;i++) {
			try {
				System.out.println("El vehiculo "+nombre+" ha recorrido "+i+" km de "+distancia+" kms.");
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
