package Enviroment;

import java.awt.*;
import java.awt.geom.*;

import javax.swing.*;

public class Window {
	private JFrame frame;
	private JPanel panel;
	
	private static final int PWIDTH = 500;
	private static final int PHEIGHT = 400;
	
	public Window() {
		prepareGUI();
		
		
		//setBackground(Color.white);
		
	}
	
	private void prepareGUI() {
		frame = new JFrame("Crash Simulation");
		frame.setSize(new Dimension(PWIDTH, PHEIGHT));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new Panel(); 
		panel.setBackground(Color.white);
		//panel.setPreferredSize(new Dimension(PWIDTH, PHEIGHT));
		
		frame.add(panel);
		frame.setVisible(true);
	}
	
	private void showGUI() {
		
	
	}
	
}
