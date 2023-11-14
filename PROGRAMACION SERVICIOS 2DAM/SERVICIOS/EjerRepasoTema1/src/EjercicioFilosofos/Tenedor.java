package EjercicioFilosofos;

public class Tenedor {
	
	private boolean disponible=true;
	
	//Metodo sincroizado que cambia la disponibilidad del tenedor para que no puedan seguir los demas filosofos hasta que tengan los tenedores disponibles
	public synchronized void tomar() throws InterruptedException {
        while (!disponible) {
            wait();
        }
        disponible = false;
    }

	//Metodo sincronizado que hace soltar el tenedor para que se pueda seguir ejecutando el codigo y los demas filosofos puedan escribir
    public synchronized void soltar() {
        disponible = true;
        notifyAll();
    }

}
