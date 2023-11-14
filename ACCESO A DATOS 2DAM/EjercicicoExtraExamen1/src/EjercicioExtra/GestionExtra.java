package EjercicioExtra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;


public class GestionExtra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		try {
			Connection pablo = DriverManager.getConnection("jdbc:mysql://" + "192.168.6.221" + ":" + "3306" + "/" + "pablo" + "?serverTimezone=UTC", "pablo", "pablo11504");
			Extra.loadDriver(pablo);
			Extra.connect(pablo);
			Extra.usarBD(pablo);
			String archivo="C:\\Users\\dam2\\Documents\\ACCESO A DATOS 2DAM\\EjercicicoExtraExamen1\\usuarios.txt";
			Extra.leeArchivo(pablo, archivo);
			System.out.println("Dime tu nombre usuario:");
			String usuario=input.nextLine();
			System.out.println("Dime tu contraseña:");
			String pass=input.nextLine();
			System.out.println(Extra.inicioCorrecto(pablo, usuario, pass));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};

	}

}
