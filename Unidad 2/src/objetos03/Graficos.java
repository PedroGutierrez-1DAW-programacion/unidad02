package objetos03;

import graphics.*;

public class Graficos {
	
	public static void main(String[] args) throws InterruptedException {
		//Canvas lienzo = Canvas.getInstance();
		
		Rectangle rect = new Rectangle(10, 10, 40, 40);
		
		for(int i=0;i<120;i++){
			Thread.sleep(1000/60);
			rect.translate(1 + (0.1 * i), 1);
			rect.setColor(new Color( (i * 2), (i / 4 * 5), (i / 4 * 3)));
			rect.fill();
		}
	}
}
