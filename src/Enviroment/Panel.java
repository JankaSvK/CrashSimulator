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
	public boolean crash = false;
	public double speedInCrash = 0;
	
	public double carSpeed;
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2 = (Graphics2D) g;
		
		drawCarSpeed();
		drawPendant(pendantX, pendantY);
		drawCar(carX,carY);
		if(crash) {
			printSpeedInCrash(speedInCrash);
		}
	}
	
	private void drawCarSpeed() {
		// TODO Auto-generated method stub
		Integer speed = new Integer((int) Math.floor(carSpeed));
		g2.drawString(speed.toString(), 10, 30);
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
		
		//g2.setColor(Color.black);
		
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
		g2.fillRect(x - a/2, y - b/2, a, b);
		
	}

	public void printSpeedInCrash(double carSpeed2) {
		// TODO Auto-generated method stub
		
		Integer speed = new Integer((int) Math.floor(carSpeed2));
		g2.drawString("Speed of the car during the crash: "+speed.toString() + "km/h", 10, 60);
	}	
}
