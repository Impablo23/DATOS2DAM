package EjerciciosVehiculos;

public class RecorridoTransportes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Creamos 3 Vehiculos de prueba
		Vehiculo auto=new Vehiculo("auto",5);
		Vehiculo moto=new Vehiculo("moto",7);
		Vehiculo patinete=new Vehiculo("patinete",2);
		
		
		//Iniciamos los hilos
		auto.start();
		moto.start();
		patinete.start();

	}

}
