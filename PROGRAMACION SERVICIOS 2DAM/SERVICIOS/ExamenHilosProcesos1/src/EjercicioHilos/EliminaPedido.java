package EjercicioHilos;



public class EliminaPedido implements Runnable{
	
	public Cola producto;
	public String nombre;
	public String productoRetirado=null;
	
	public EliminaPedido(Cola producto) {
		this.producto=producto;
		this.nombre="DAM";
	}

	//Metodo run que retira un pedido de la lista y lo muestra por consola
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String texto;
		while(true) {
			productoRetirado = producto.retirarPedido();
			//texto = (productoRetirado != null) ? ", ha atendido " +productoRetirado : " esperando comandas";
			System.out.println("A la cola " + nombre + " se ha eliminado el pedido " + productoRetirado+"\t el siguiente es: "+productoRetirado);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
