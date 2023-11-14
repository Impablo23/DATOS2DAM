package Ejemplos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

//Ejercicio que recoge los datos de un archivo A y B y luego crea un archivo A_B.txt donde escribe los datos de los dos archivos anteriores
public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> letras=new ArrayList<>();
		ArrayList<String> numeros=new ArrayList<>();
		String rutaLetras="H:\\Otros ordenadores\\Mi PC\\Documents\\ACCESO A DATOS 2DAM\\RepasoExamen1\\letras.txt";
		String rutaNumeros="H:\\\\Otros ordenadores\\\\Mi PC\\\\Documents\\\\ACCESO A DATOS 2DAM\\\\RepasoExamen1\\\\numeros.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(rutaLetras))) {
            String linea;
            // Lee cada línea del archivo hasta que no haya más líneas
            while ((linea = br.readLine()) != null) {
                letras.add(linea);            }
        } catch (IOException e) {
            // Captura cualquier excepción de entrada/salida (por ejemplo, archivo no encontrado)
            e.printStackTrace();
        }
		
		try (BufferedReader br = new BufferedReader(new FileReader(rutaNumeros))) {
            String linea;
            // Lee cada línea del archivo hasta que no haya más líneas
            while ((linea = br.readLine()) != null) {
                numeros.add(linea);            }
        } catch (IOException e) {
            // Captura cualquier excepción de entrada/salida (por ejemplo, archivo no encontrado)
            e.printStackTrace();
        }
		
		//Escribe el contenido de los anteriores .txt en uno nuevo
		try(BufferedWriter escribe= new BufferedWriter(new FileWriter("letras_numeros.txt"))){
			escribe.write("Datos del archivo: letras.txt");
			escribe.newLine();
			for (String l : letras) {
				escribe.write(l.toString()+"\n");
			}
			
			escribe.write("Datos del archivo: numeros.txt");
			escribe.newLine();
			for (String n : numeros) {
				escribe.write(n.toString()+"\n");
			}
			escribe.close();
			System.out.println("Escritura completada correctamente");
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		

	}

}
