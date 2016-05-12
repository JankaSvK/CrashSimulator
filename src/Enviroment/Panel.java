package Enviroment;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class Panel {
	private JFrame frame;
	private JPanel panel;
	
	private static final int PWIDTH = 500;
	private static final int PHEIGHT = 400;
	
	public Panel() {
		prepareGUI();
		
		//setBackground(Color.white);
		
	}
	
	private void prepareGUI() {
		frame = new JFrame("Crash Simulation");
		frame.setSize(new Dimension(PWIDTH, PHEIGHT));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2 = (Graphics2D) g;
				
				Line2D line = new Line2D.Double(10,10,40,40);
				g2.setColor(Color.green);
				g2.setStroke(new BasicStroke(10));
				g2.draw(line);
			}
			
		};
		panel.setBackground(Color.white);
		//panel.setPreferredSize(new Dimension(PWIDTH, PHEIGHT));
		
		frame.add(panel);
		frame.setVisible(true);
	}
	
	private void showGUI() {
		
	
	}
	
	
}
