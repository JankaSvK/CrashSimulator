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
	}
	
}
