package Hilos;

public class Hilos extends Thread {
    

    public static void main(String[] args) {
        int posiciones = 5; // Número de posiciones a incrementar en los hilos
        Hilos uno = new Hilos(posiciones);
        Hilos dos = new Hilos(posiciones);
        Hilos tres = new Hilos(posiciones);

        //Iniciamos los tres hilos
        uno.start();
        dos.start();
        tres.start();

        //Si ocurre alguna interrupción durante la espera, se imprime el rastreo del error con el metodo join().
        try {
            uno.join();
            dos.join();
            tres.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Finalmente mostramos la cantidad de posiciones
        System.out.println("Valor final del contador: " + contador);
    }
    
    //Creamos la Clase Hilo con los valores de contador e incremento
    private static int contador = 0;
    private int incremento;

    public Hilos(int incremento) {
        this.incremento = incremento;
    }

    public void run() {
        for (int i = 0; i < incremento; i++) {
            contador++;
            System.out.println("Hilo " + Thread.currentThread().getId() + " - Contador: " + contador);
        }
    }
}

