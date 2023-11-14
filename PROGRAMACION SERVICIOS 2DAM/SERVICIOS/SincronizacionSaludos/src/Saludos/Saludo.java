package Saludos;

class Saludo {
	public synchronized void saludarComoJefe(String nombre) {
        System.out.println(nombre + " llegó.");
        System.out.println("****** JEFE-: Buenos días empleados. ******");
        notifyAll();
    }

    public synchronized void esperarSaludo(String nombre) {
        System.out.println(nombre + " llegó.");
        try {
            wait();
            System.out.println(nombre + "-: Buenos días jefe.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notifyAll();
    }
}
