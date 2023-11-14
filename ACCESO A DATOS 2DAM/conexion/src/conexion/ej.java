package conexion;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ej {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		Connection pablo = DriverManager.getConnection("jdbc:mysql://" + "192.168.6.221" + ":" + "3306" + "/" + "pablo" + "?serverTimezone=UTC", "pablo", "pablo11504");;
		
		//Hacemos un try para iniciar al driver, conectar a la base de datos e imprimir la tabla de clientes
		try {
			DBclientes.loadDriver(pablo);
			DBclientes.connect(pablo);
			System.out.println("Lista de CLientes:");
			DBclientes.printTablaClientes(pablo);
			//Preguntamos si quiere almacenar en los datos alguna incidencia
			System.out.println("Deseas introducir una incidencia(cualquier numero) o no(0)?");
			int respuesta=input.nextInt();input.nextLine();
			if(respuesta!=0) {
				System.out.println("Dime el codigo del cliente:");
				String codigo=input.nextLine();
				//Verifica si el clientes es correcto para seguir pidiendole datos o no
				if(DBclientes.verificaCliente(pablo,codigo)==true) {
					System.out.println("Dime la descripcion de la incidencia:");
					String desc=input.nextLine();
					System.out.println("Dime el numero de horas de la incidencia:");
					int h=input.nextInt();input.nextLine();
					DBclientes.insertarIncidencia(pablo, codigo, desc, h);
					DBclientes.printTablaIncidencias(pablo);
				}else {
					System.out.println("El cliente numero "+codigo+" no esta registrado en la base de datos.");
				}
				
			}else {
				System.out.println("Que tengas un buen dia :)");
			}
			
			
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("No ha sido posible");
		}
		
			
		

	}

}
