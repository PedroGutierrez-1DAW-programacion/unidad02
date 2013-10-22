package objetos02;

import java.util.Scanner;

public class Principal {
	static Alumno[] clase = new Alumno[3];
	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		pedirNombres(clase);	// Pedimos los nombres de los alumnos
		
		mostarDatos(clase);		// Mostramos los datos

		pedirEdad(clase);		// Pedimos las edades de cada alumno
		
		mostarDatos(clase);		// Mostramos los datos
	
		// Muestra la media de edad
		System.out.println( "Edad media: " + (Math.round(calcularMedia(clase) * 100) / 100.0) );

		teclado.close();
	}
	
	private static void pedirNombres(Alumno[] personas) {
		
		for(int i=0; i<clase.length; i++){
			System.out.println("Nombre del nuevo alumno:");
			String nombre = teclado.next();
			personas[i] = new Alumno(nombre);
		}
	}
	
	private static void pedirEdad(Alumno[] personas) {
		
		for(int i=0; i<clase.length; i++){
			System.out.println("Edad de " + personas[i].queNombre() + ":");
			int edad = teclado.nextInt();
			personas[i].nuevaEdad(edad);
		}
	}
	
	private static void mostarDatos(Alumno[] personas) {
		System.out.println();
		
		for(int i=0; i<clase.length; i++)
			System.out.println(personas[i]);

		System.out.println();
	}
	
	private static double calcularMedia(Alumno[] personas){
		double media = 0;
		
		for(int i=0; i < personas.length; i++)
			media += personas[i].queEdad();
		
		return media / personas.length;			
	}
}
