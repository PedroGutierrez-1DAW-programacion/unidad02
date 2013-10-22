package objetos02;

public class Alumno {
	private String nombre;
	private int edad;
	
	// Constructor
	Alumno(String nombre){
		this.nombre = nombre;
		this.edad = 20;
	}
	
	// Servicios
	public String toString(){
		return "+ " + this.nombre + "	[" + this.edad + "años]";
	}
	
	// Getters y Setters
	public int queEdad(){
		return this.edad;
	}
	public void nuevaEdad(int edad){
		this.edad = edad;
	}
	public String queNombre(){
		return this.nombre;
	}
}
