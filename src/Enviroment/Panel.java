package Enviroment;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class Panel extends JPanel {
	Graphics2D g2;
	
	private int LINEHEIGHT = 15;
	
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
		drawInputConstraints();
		drawPendant(pendantX, pendantY);
		drawCar(carX,carY);
		if(crash) {
			printSpeedInCrash(speedInCrash);
		}
	}
	
	/**
	 * Prints actual speed of the car.
	 */
	private void drawCarSpeed() {
		Integer speed = new Integer((int) Math.floor(carSpeed));
		g2.drawString("Actual speed of the car: "+speed.toString(), 10, lineHeight(7));
	}
	
	double speedKM = 0, maxSlowdown = 100, pendantSpeed = 0; 
	int angle = 0;
	
	/**
	 * Sets constant from the infput file.
	 * @param speedKM
	 * @param maxSlowdown
	 * @param prendantSpeed
	 * @param angle
	 */
	public void setInputConstraints(double speedKM, double maxSlowdown, double prendantSpeed,
			int angle){
		this.speedKM = speedKM;
		this.maxSlowdown = maxSlowdown;
		this.pendantSpeed = prendantSpeed;
		this.angle = angle;
	}
	
	/**
	 * Add to panel constant from the input file.
	 */
	private void drawInputConstraints() {
		g2.drawString("Simulation was setuped to these constants:", 10, lineHeight(1));
		g2.drawString("Speed of the car: " + speedKM, 10, lineHeight(2));
		g2.drawString("Max. slowdown of the car: " + maxSlowdown, 10, lineHeight(3));
		g2.drawString("Speed of the pendant: " + pendantSpeed, 10, lineHeight(4));
		g2.drawString("Angle of the zone of the sensor: " + angle, 10, lineHeight(5));
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

	/**
	 * Print the speed of the car during the crash.
	 * It also prints an information about the chance to survive the crash (as a pendant).
	 * @param carSpeed2
	 */
	public void printSpeedInCrash(double carSpeed2) {
		Integer speed = new Integer((int) Math.floor(carSpeed2));
		g2.drawString("Speed of the car during the crash: "+speed.toString() + "km/h", 10, lineHeight(8));
		
		int chance = 0;
		if(speed <= 30) chance = 97;
		else if(speed <= 50) chance = 80;
		else if(speed <= 55) chance = 50;
		else if(speed <= 60) chance = 10;
		else if(speed > 60) {
			g2.drawString("Chance of surviving is less than 10%", 10, lineHeight(9));
			return;
		}
		g2.drawString("Chance of surviving: "+chance + "%", 10, lineHeight(9));
	}	
	
	private int lineHeight(int number){
		return number*LINEHEIGHT;
	}
}
