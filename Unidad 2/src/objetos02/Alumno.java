package objetos02;

public class Alumno {
	private String nombre;
	private int edad;
	
	Alumno(String nombre){
		this.nombre = nombre;
		this.edad = 20;
	}

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
