package Enviroment;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class Panel extends JPanel {
	Graphics2D g2;
	
	public int pendantX;
	public int pendantY;
	public int carX;
	public int carY;
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2 = (Graphics2D) g;
		
		drawPendant(pendantX, pendantY);
		drawCar(carX,carY);
	}
	
	/**
	 * Set pendant coordinates on which it will be drawed.
	 * @param x
	 * @param y
	 */
	public void setPendantCor(int x, int y){
		pendantX = x;
		pendantY = y;
	}
	
	/**
	 * Set cars coordinates on which it will be drawed.
	 * @param x
	 * @param y
	 */
	public void setCarCor(int x, int y){
		carX = x;
		carY = y;
	}
	
	/**
	 * Draws pendant on given coordinates.
	 * @param x
	 * @param y
	 */
	public void drawPendant(int x, int y) {
		final int r = 5;
		
		System.out.println("a");
		g2.setColor(Color.black);
		System.out.println("ab");
		Shape circle = 
				new Ellipse2D.Double(x - r, y - r, 2.0*r, 2.0*r);
		g2.draw(circle);
	}
	
	/**
	 * Draw car on given coordinates.
	 * @param x
	 * @param y
	 */
	public void drawCar(int x, int y) {
		final int a = 60;
		final int b = 40;
		
		g2.setColor(Color.black);
		g2.fillRect(x, y, a, b);
		
	}	
}
