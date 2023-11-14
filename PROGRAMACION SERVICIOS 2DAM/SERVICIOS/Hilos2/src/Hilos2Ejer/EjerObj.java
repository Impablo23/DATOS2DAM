package Hilos2Ejer;

public class EjerObj {
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		//La unica diferencia es que hemos aplicado varios hilos al mismo objeto eso es lo que aplica la interfaz Runnable
		Raton uno= new Raton("Nico",4);
		new Thread (uno).start();
		new Thread (uno).start();
		new Thread (uno).start();
		Raton dos= new Raton("Ivan",2);
		new Thread (dos).start();
		Raton tres= new Raton("Pablo",1);
		new Thread (tres).start();
		
		
		

	}

}
