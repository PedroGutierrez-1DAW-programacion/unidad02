package objetos03;

import graphics.Color;

public class Pais {
	private String nombre;
	private int[] datos;
	private Color color;

	// C�digo de pa�s
	public static final int es = 0;	// Espa�a
	public static final int fr = 1; // Francia
	public static final int gb = 2; // Reino Unido
	public static final int ie = 3; // Irlanda
	public static final int bg = 4; // Bulgaria
	public static final int lu = 5; // Luxemburgo
	public static final int el = 6; // Grecia
	
	/**
	 * Construye un nuevo Pais
	 * @param nombre destinado al nombre del pa�s
	 * @param datos array de tipo int[] que contiene los datos a representar
	 * @param color objeto de tipo Color de la librer�a graphics, con el color del gr�fico
	 */
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
	// Datos (por posici�n)
	public int datos(int i){
		return this.datos[i];
	}
	// Consultar color
	public Color color(){
		return this.color;
	}
}
