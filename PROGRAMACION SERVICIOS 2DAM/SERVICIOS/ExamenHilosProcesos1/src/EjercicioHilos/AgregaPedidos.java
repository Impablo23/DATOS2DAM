package EjercicioHilos;



public class AgregaPedidos implements Runnable{
	public Cola producto;
	public String nombre;
	public String nuevoPedido1;
	
	
	public AgregaPedidos(Cola producto) {
		this.producto=producto;
		this.nombre="DAM";
	}
	
	//Metodo run que genera un nuevo pedido y se añade a la lista mostrandolo por consola
	public void run() {
		// TODO Auto-generated method stub
		//Lo hacemos con 5 pedidos para ver como sale
		for (int i = 1; i < 5; i++) {
			nuevoPedido1=PedidosRamdoms.generateRandomString(i);
            producto.agregarPedido(nuevoPedido1);
	        System.out.println("A la cola " + nombre + " se han agregado los pedidos " + nuevoPedido1+"\t Pedidos Pendientes: "+(5-i));
	        try {
	            Thread.sleep((long) (Math.random() * 700));
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
        }
	}

}
