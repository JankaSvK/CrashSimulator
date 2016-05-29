package Enviroment;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class Frame {
	JFrame frame = new JFrame("CrashSimulator");
	Panel panel = new Panel();
	
	public Frame(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel.setPreferredSize(new Dimension(800,600));
		frame.add(panel);
		
		frame.pack();
		frame.setVisible(true);	
	}
	
	/**
	 * Will tell the panel to draw car and pendant on giver coords.
	 * @param cx
	 * @param cy
	 * @param px
	 * @param py
	 * @param speedOfCar
	 */
	public void drawObjects(int cx, int cy, int px, int py, double speedOfCar){
		panel.setCarCor(cx, cy);
		panel.setPendantCor(px, py);
		panel.carSpeed = speedOfCar;
		panel.repaint();
		
	}

	/**
	 * Will tell the panel the speed in crash.
	 * @param carSpeed
	 */
	public void printSpeedInCrash(double carSpeed) {
		panel.speedInCrash = carSpeed;
		panel.crash = true;
		panel.repaint();
	}
	
}
