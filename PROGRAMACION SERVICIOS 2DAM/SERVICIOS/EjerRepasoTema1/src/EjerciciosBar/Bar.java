package EjerciciosBar;


public class Bar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Productos lista=new Productos();
		Camarero camarero1=new Camarero(lista,"X");
		Cliente cliente1=new Cliente(lista,"A");
		Cliente cliente2=new Cliente(lista,"B");
		Cliente cliente3=new Cliente(lista,"C");
		
		Thread a=new Thread(camarero1);
		Thread b=new Thread(cliente1);
		Thread c=new Thread(cliente2);
		Thread d=new Thread(cliente3);
		a.start();
		b.start();
		c.start();
		d.start();

	}

}
