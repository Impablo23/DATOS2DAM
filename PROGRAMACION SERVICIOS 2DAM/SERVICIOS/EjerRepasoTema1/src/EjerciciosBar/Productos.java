package EjerciciosBar;

import java.util.LinkedList;

public class Productos {
	
	private LinkedList<String> productos = new LinkedList<>();

	//Agrega productos a una lista y notifica a los clientes
    synchronized public void agregarProducto(String producto) {
        productos.add(producto);
    	notifyAll();
    }

    synchronized public String retirarProducto() {
        if (!productos.isEmpty()) {
            String producto = productos.removeFirst();
            return producto;
        } else {
        	try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            return null;
            }
    }
    
    public boolean isEmpty() {
    	return productos.isEmpty();
    }

}
