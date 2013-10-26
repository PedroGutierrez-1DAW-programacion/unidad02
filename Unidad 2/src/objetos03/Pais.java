package objetos03;

import graphics.Color;

public class Pais {
	private String nombre;
	private int[] datos;
	private Color color;

	// Código de país
	public static final int es = 0;	// España
	public static final int fr = 1; // Francia
	public static final int gb = 2; // Reino Unido
	public static final int ie = 3; // Irlanda
	public static final int bg = 4; // Bulgaria
	public static final int lu = 5; // Luxemburgo
	public static final int el = 6; // Grecia
	
	// Constructor
	Pais(String nombre, int[] datos, Color color){
		this.nombre = nombre;
		this.datos = datos;
		this.color = color;
	}
	
	// Nombre
	public String nombre(){
		return this.nombre;
	}
	// Datos (completos)
	public int[] datos(){
		return this.datos;
	}
	// Datos (por posición)
	public int datos(int i){
		return this.datos[i];
	}
	// Consultar color
	public Color color(){
		return this.color;
	}
}
