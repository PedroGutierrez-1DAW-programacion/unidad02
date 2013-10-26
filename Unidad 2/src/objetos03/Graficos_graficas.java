package objetos03;

import graphics.Color;
import graphics.Line;
import graphics.Text;

public class Graficos_graficas {
	private static final int inicioX = 60; // Inicio de cuadrícula en X
	private static final int inicioY = 50; // Inicio de cuadrícula en Y
	private static final int maximoX = 2013 - 2000; // Maximo en X
	private static final int graficaX = 80; // Separación en X
	private static final int graficaY = 30; // Separación en Y
	private static final int reduccionY = 100; // Ratio de reducción del dato en eje Y
	private static final int saltoDato = 2; // Número cada cuantas línas
	private static final String nombreGrafica = "Salario bruto mínimo (en Euros)";
	private static int ancho, alto;
	

	public static void main(String[] args) throws InterruptedException {
		Pais[] paises = new Pais[7];

		paises[Pais.es] = new Pais("España", new int[] {495, 505, 515, 526, 537, 598, 631, 665, 700, 728, 738, 748, 748, 752}, new Color(73, 100, 148));
		paises[Pais.fr] = new Pais("Francia", new int[] {1048, 1083, 1127, 1154, 1215, 1286, 1217, 1256, 1280, 1321, 1343, 1365, 1396, 1413}, new Color(14, 143, 129));
		paises[Pais.gb] = new Pais("Reino Unido", new int[] {952, 977, 1109, 1063, 1054, 1134, 1212, 1314, 1242, 995, 1076, 1138, 1201, 1264}, new Color(42, 190, 19));
		paises[Pais.ie] = new Pais("Irlanda", new int[] {944, 944, 1008, 1073, 1073, 1183, 1292, 1402, 1461, 1461, 1461, 1461, 1461, 1461}, new Color(181, 18, 117));
		paises[Pais.bg] = new Pais("Bulgaria", new int[] {34, 40, 51, 56, 61, 76, 81, 92, 112, 122, 122, 122, 138, 158}, new Color(103, 23, 154));
		paises[Pais.lu] = new Pais("Luxemburgo", new int[] {1191, 1258, 1290, 1368, 1402, 1466, 1503, 1570, 1570, 1641, 1682, 1757, 1801, 1874}, new Color(222, 22, 41));
		paises[Pais.el] = new Pais("Grecia", new int[] {542, 543, 571, 606, 630, 667, 709, 730, 794, 817, 862, 862, 876, 683}, new Color(230, 117, 23));
		
		grafica(paises);
	}

	private static void grafica(Pais[] paises) throws InterruptedException {
		int datoMaximo = datoMasAlto(paises);
		generarCuadricula(datoMaximo);
		leyenda(paises);
		dibujarGrafos(paises);		
	}

	// Dibuja los datos en la grafica
	private static void dibujarGrafos(Pais[] paises) throws InterruptedException {
		for(int i=0; i<paises.length; i++){
			Thread.sleep(1000 / 4);
			Color color = paises[i].color();
			for(int j=0; j < (paises[i].datos().length - 1); j++){
				Thread.sleep(1000 / 30);
				int X = inicioX + (j * graficaX);
				double y1 = inicioX + alto - (paises[i].datos(j) * graficaY / reduccionY);
				double y2 = inicioX + alto - (paises[i].datos(j + 1) * graficaY / reduccionY);
				// Crea varias líneas para aumentar el grosor
				for(int l=0; l<3;l++){
					Line linea = new Line(X, y1 + l - (l/2), X + graficaX, y2 + l - (l/2));
					linea.setColor(color);
					linea.draw();
				}				
			}
		}
	}

	// Calcular el dato más elevado
	private static int datoMasAlto(Pais[] paises) {
		int masAlto = 0;
		for(int i=0; i<paises.length; i++)
			for(int j=0; j<paises[i].datos().length; j++)
				masAlto = masAlto > paises[i].datos(j) ? masAlto : paises[i].datos(j);
		return masAlto;
	}
	
	// Generar leyenda
	private static void leyenda(Pais[] paises) {
		Text titulo = new Text(inicioX, 6, nombreGrafica);
		double aW = 110f;
		double aH = 10f;
		titulo.translate(aW, aH);
		titulo.grow(aW, aH);
		titulo.draw();

		for(int i=0; i<paises.length; i++){
			int nX = inicioX + ancho + 8;
			int nY = -8 + inicioX + alto - (paises[i].datos(paises[i].datos().length - 1) * graficaY / reduccionY);
			Text nombre = new Text(nX, nY, paises[i].nombre());
			nombre.setColor(paises[i].color());
			nombre.draw();
		}
	}
	
	// Generar la cuadrícula
	private static void generarCuadricula(int datoMaximo) {
		int maximoY;
		maximoY = Math.round(datoMaximo / reduccionY) + 2;
		ancho = graficaX * maximoX;
		alto = graficaY * maximoY;

		int c1 = 210; // Color gris cuadricula
		int c2 = 140; // Color gris números
		
		// Lineas horizontales
		for(int i=0; i<=maximoY; i++){
			int X = inicioX;
			int Y = inicioY + (i * graficaY);
			Line linea = new Line(
				X,	Y,
				X + ancho,	Y
			);
			linea.setColor(new Color(c1, c1, c1));
			linea.draw();
		}
		
		// Líneas verticales
		for(int i=0; i<=maximoX; i++){
			int X = inicioX + (i * graficaX);
			int Y = inicioY;
			Line linea = new Line(
				X,	Y,
				X,	Y + alto
			);
			linea.setColor(new Color(c1, c1, c1));
			linea.draw();
		}

		// Números eje Y
		for(int i=0; i < (maximoY / saltoDato); i++){
			//reduccionY
			String numero = String.valueOf(saltoDato * i * reduccionY);
			int dX = 16;
			int dY = -10 + inicioY + alto - (graficaY * i * saltoDato);
			Text dato = new Text(dX, dY, numero);
			dato.setColor(new Color(c2, c2, c2));
			dato.draw();
		}
		
		// Números eje X
		for(int i=0; i<=maximoX; i++){
			//reduccionY
			String numero = String.valueOf(2000  + i);
			int dX = -14 + inicioX + (graficaX * i);
			int dY = inicioY + alto + 4;
			Text dato = new Text(dX, dY, numero);
			dato.setColor(new Color(c2, c2, c2));
			dato.draw();
		}
	}
}
