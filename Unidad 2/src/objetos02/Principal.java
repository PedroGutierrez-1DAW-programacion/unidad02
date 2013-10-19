package objetos02;

public class Principal {
	public static void main(String[] args) {
		Alumno juan, raul, pepe;
		
		juan = new Alumno("Juan Sancho");
		raul = new Alumno("Raúl Sancho");
		pepe = new Alumno("Pepe Sancho");
		
		System.out.println(juan.queEdad());
		System.out.println(raul.queEdad());
		System.out.println(pepe.queEdad());

		juan.nuevaEdad(18);
		raul.nuevaEdad(23);
		pepe.nuevaEdad(21);

		System.out.println("\nMedia edad:");
		Alumno[] clase = new Alumno[3];
		clase[0] = juan;
		clase[1] = raul;
		clase[2] = pepe;
		
		System.out.println( Math.round(calcularMedia(clase) * 100) / 100.0 );
	}
	private static double calcularMedia(Alumno[] personas){
		double media = 0;
		
		for(int i=0; i < personas.length; i++)
			media += personas[i].queEdad();
		
		return media / personas.length;			
	}
}
