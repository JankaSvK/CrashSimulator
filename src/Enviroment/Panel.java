package Enviroment;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class Panel extends JPanel {
	Graphics2D g2;
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2 = (Graphics2D) g;
		
		drawPendant(150, 20);
		drawCar(50,50);
	}
	
	public void drawPendant(int x, int y) {
		final int r = 5;
		
		g2.setColor(Color.black);
		Shape circle = 
				new Ellipse2D.Double(x - r, y - r, 2.0*r, 2.0*r);
		g2.draw(circle);
	}
	
	public void drawCar(int x, int y) {
		final int a = 60;
		final int b = 40;
		
		g2.setColor(Color.black);
		g2.fillRect(x, y, a, b);
		
	}	
}
