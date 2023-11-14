package Saludos;

public class Empresa {
	
	
	    public static void main(String[] args) {
	        Saludo saludo = new Saludo();
	        Empleado uno = new Empleado("pablo", saludo, false);
	        Empleado dos = new Empleado("nico", saludo, false);
	        Empleado tres = new Empleado("ivan", saludo, false);
	        Empleado cuatro = new Empleado("laura", saludo, true);

	        try {
	        	uno.start();
		        dos.start();
		        tres.start();
		        cuatro.start();
	        }catch(Exception e) {
	        	e.printStackTrace();
	        }
	    }
}
	


