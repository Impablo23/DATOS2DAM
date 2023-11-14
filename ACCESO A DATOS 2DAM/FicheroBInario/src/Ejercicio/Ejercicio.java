package Ejercicio;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Ejercicio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Creamos un arrayList para almacenar los productos
		ArrayList<Producto> listaProdu=new ArrayList<Producto>();
		
		//Creamos los objetos y los añadimos a la lista de productos
		Producto produ1=new Producto("Piti-Cola",1,66);
		Producto produ2=new Producto("Fantasma",2,77);
		Producto produ3=new Producto("Seven-tape",3,88);
		
		listaProdu.add(produ1);
		listaProdu.add(produ2);
		listaProdu.add(produ3);
		
		//Creamos un FileOutputStream con destino a "productos.data" para copiar la info en binario
		FileOutputStream f;
		try {
			f = new FileOutputStream ("productos.dat");
			//Este paso pasa a binario
			ObjectOutputStream bin=new ObjectOutputStream(f);
			//Este pasp escribe directamente el objeto
			bin.writeObject(listaProdu);
			bin.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Anulamos la lista de productos para pasarlo a texto
		ArrayList<Producto> listProduct=null;
		ObjectInputStream s=null;
		try {
			//lo pasa a texto
			s=new ObjectInputStream(new FileInputStream("binario.dat"));
			//coge el objeto del fichero y lo lee
			listProduct=(ArrayList<Producto>) s.readObject();
			for (Producto producto : listProduct) {
				System.out.println(producto.muestraInfo());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
