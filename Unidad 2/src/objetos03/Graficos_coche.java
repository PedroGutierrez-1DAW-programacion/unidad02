package objetos03;

import graphics.Color;
import graphics.Ellipse;
import graphics.Rectangle;

public class Graficos_coche {
	
	public static void main(String[] args) throws InterruptedException {
		//Canvas lienzo = Canvas.getInstance();
		
		Ellipse[] ruedas = new Ellipse[2];
		Rectangle[] chasis = new Rectangle[3];
		
		int r = 40; // Radio rueda

		ruedas[0] = new Ellipse(40, 80, r, r);
		ruedas[1] = new Ellipse(140, 80, r, r);

		chasis[0] = new Rectangle(20, 60, 180, 40);
		chasis[1] = new Rectangle(140, 30, 60, 40);
		chasis[2] = new Rectangle(20, 30, 110, 40);

		pintar(ruedas, new Color(100, 100, 100));
		pintar(chasis, new Color(220, 30, 30));

		chasis[2].setColor(new Color(210, 210, 210));
		
		dibujar(ruedas);
		dibujar(chasis);
		
		for(int i=0;i<120;i++){
			Thread.sleep(1000 / 60);
			int x = i / 8;
			int y = (i%20 < 10) ? 2 : -2;

			mover(ruedas, x, y);
			mover(chasis, x, y);

			dibujar(ruedas);
			dibujar(chasis);
		}
	}
	
	// Mover
	private static void mover(Rectangle[] chasis, int x, int y) {
		for(int i=0; i<chasis.length; i++)
			chasis[i].translate(x, y);
	}
	private static void mover(Ellipse[] ruedas, int x, int y) {
		for(int i=0; i<ruedas.length; i++)
			ruedas[i].translate(x, y);
	}

	// Pintar
	private static void pintar(Rectangle[] chasis, Color color) {
		for(int i=0; i<chasis.length; i++)
			chasis[i].setColor(color);
	}
	private static void pintar(Ellipse[] ruedas, Color color) {
		for(int i=0; i<ruedas.length; i++)
			ruedas[i].setColor(color);
	}
	
	// Dibujar
	private static void dibujar(Ellipse[] ruedas) {
		for(int i=0; i<ruedas.length; i++)
			ruedas[i].fill();
	}
	private static void dibujar(Rectangle[] chasis) {
		for(int i=0; i<chasis.length; i++)
			chasis[i].fill();
		
	}
	
}
