package EjercicioFilosofos;

public class CenaFilosofos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Creamos 5 tenedores
		Tenedor[] tenedores = new Tenedor[5];
        for (int i = 0; i < 5; i++) {
            tenedores[i] = new Tenedor();
            
        }

        //Creamos 5 filosofos
        Thread[] filosofos = new Thread[5];
        for (int i = 0; i < 5; i++) {
            filosofos[i] = new Thread(new Filosofo(tenedores[i], tenedores[(i + 1) % 5]), "Filósofo " + (i + 1));
        }

        //Ejecutamos los hilos
        for (Thread f : filosofos) {
            f.start();
        }
        
        
		

	}

}
