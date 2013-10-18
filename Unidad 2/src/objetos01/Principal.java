package objetos01;

public class Principal {

	public static void main(String[] args) {
		
		Clase01 objeto = new Clase01();
		
		objeto.mensaje();
		
		Alumno juan, pablo;

		juan = new Alumno();
		pablo = new Alumno();
		
		juan.nombre = "Juan Jimenez";
		
		juan.mensaje();
		
		pablo.nombre = "Pablo Jimenez";

		juan.mensaje();
		pablo.mensaje();

	}

}
