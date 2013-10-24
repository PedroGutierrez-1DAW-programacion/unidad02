package objetos03;

import graphics.*;

public class Graficos_semaforo {
	
	public static void main(String[] args) throws InterruptedException {
		//Canvas lienzo = Canvas.getInstance();
		
		Rectangle bg = new Rectangle(10, 10, 120, 320);
		bg.setColor(new Color(200,200,200));
		bg.fill();
		
		Ellipse rojo, naranja, verde;

		rojo = new Ellipse(30, 30, 80, 80);
		naranja = new Ellipse(30, 30, 80, 80);
		verde = new Ellipse(30, 30, 80, 80);

		naranja.translate(0, 100);;
		verde.translate(0, 200);;
		
		for(int i=0;i<21;i++){
			Thread.sleep(1000);
			
			rojo.setColor(new Color(150, 10, 10));
			naranja.setColor(new Color(140, 70, 30));
			verde.setColor(new Color(20, 100, 30));
			
			switch(i%3){
				case 0: rojo.setColor(new Color(250, 10, 10)); break;
				case 1: naranja.setColor(new Color(240, 150, 30)); break;
				case 2: verde.setColor(new Color(20, 200, 30)); break;
			}
			rojo.fill();
			naranja.fill();
			verde.fill();
		}
	}
}
