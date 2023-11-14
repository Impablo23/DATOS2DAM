package EjercicioAlumnos;

public class Alumno extends Thread{
	
	public String nombre;
	public int tiempoComerPlato;
	
	
	public Alumno(String nombre, int tiempoComerPlato) {
		this.nombre = nombre;
		this.tiempoComerPlato = tiempoComerPlato;
	}
	
	//Metodo run dond el alumno se zampa 3 platos y dejamos un tiempo de espera aleatorio
	public void run() {
		for(int i=1;i<4;i++) {
			try {
				System.out.println(nombre+" se zampa el plato "+i+"\n");
				Thread.sleep(500*tiempoComerPlato);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(nombre+" ha terminado de comer :)\n");
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", tiempoComerPlato=" + tiempoComerPlato + "]";
	}
	
	
	
	
}
