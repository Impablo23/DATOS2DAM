package Ejercicio;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;


@Entity
@Table(name = "persona")
public class Persona {
		
		private int id;
		private String nombre;
		private int edad;
		
		
		
		@Id // Marca el campo como la clave de la tabla
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="id")
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		
		@Column(name="id")
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		
		@Column(name="edad")
		public int getEdad() {
			return edad;
		}
		public void setEdad(int edad) {
			this.edad = edad;
		}
		
		
	
	
	 

}
