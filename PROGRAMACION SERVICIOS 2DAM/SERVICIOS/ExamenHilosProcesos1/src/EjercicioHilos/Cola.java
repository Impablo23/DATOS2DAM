package EjercicioHilos;

import java.util.LinkedList;

public class Cola {
	//Creamos una lista
private LinkedList<String> lista = new LinkedList<>();
	
	//Metodo sincronizado que añade pedidos a la lista
	synchronized public void agregarPedido(String pedido1) {
        lista.add(pedido1);
        
    	notifyAll();
    }
	
	//Metodo sincronizado que retira un producto de la lista
	synchronized public String retirarPedido() {
        if (!lista.isEmpty()) {
            String producto = lista.removeFirst();
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
    
	//Metodo que devuelve true o false si la lista esta vacia o no
    public boolean isEmpty() {
    	return lista.isEmpty();
    }

}
