package extra01;

import java.awt.*;

public class InterfazGrafica01 extends Frame {
	private static final long serialVersionUID = 5678226578947547451L;

	public InterfazGrafica01(){
		super ("Titulo");
		
		setLayout(new FlowLayout());
		Button b1 = new Button("Botón");
		add(b1);
		
		setSize(300, 300);
		setVisible(true);
		
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		InterfazGrafica01 interfaz = new InterfazGrafica01();
		Thread.sleep(2000);
		interfaz.hide();
	}

}
