package Enviroment;

import java.awt.*;

import javax.swing.*;

import java.awt.geom.*;

public class Panel extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		Line2D line = new Line2D.Double(10,10,40,40);
		g2.setColor(Color.green);
		g2.setStroke(new BasicStroke(10));
		g2.draw(line);	
		
		drawPendant(g2, 150, 20);
		drawCar(g2, 50,50);
	}
	
	public void drawPendant(Graphics2D g2, int x, int y) {
		final int r = 5;
		
		g2.setColor(Color.black);
		Shape circle = 
				new Ellipse2D.Double(x - r, y - r, 2.0*r, 2.0*r);
		g2.draw(circle);
	}
	
	public void drawCar(Graphics2D g2, int x, int y) {
		final int a = 40;
		final int b = 60;
		
		g2.setColor(Color.black);
		g2.fillRect(x, y, a, b);
		
	}
	
	
}
