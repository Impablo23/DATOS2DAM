package EjercicioHilos;

public class GestionCola {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Creamos los objetos Cola, AgregaPedidos y EliminaPedido
		Cola cola= new Cola();
		AgregaPedidos unoA=new AgregaPedidos(cola);
		EliminaPedido unoE=new EliminaPedido(cola);
		
		//Hilos de los objetos AgregaPedidos y EliminaPedido
		Thread a=new Thread(unoA);
		Thread b=new Thread(unoE);
		
		//Iniciamos los hilos
		a.start();
		b.start();
		

	}

}
