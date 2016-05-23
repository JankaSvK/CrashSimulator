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
	
	public void reDraw(){
		panel.setPendantCor(50, 50);
		panel.repaint();
		//thread.sleep 
		panel.setPendantCor(100, 50);
		panel.repaint();
	}
	
}
