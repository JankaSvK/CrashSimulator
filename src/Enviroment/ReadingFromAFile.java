package Enviroment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadingFromAFile {
	public double speedCar;
	public double maxSlowDown;
	public double speedPendant;
	public int angle;
	
	public ReadingFromAFile(String filename){
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			StringBuilder sb = new StringBuilder();
			String parts[];
			String line;
			
			line = br.readLine();
			parts = line.split(": ");
		    speedCar = Double.parseDouble(parts[1]);
		    
		    line = br.readLine();
			parts = line.split(": ");
		    maxSlowDown = Double.parseDouble(parts[1]);
		    
		    line = br.readLine();
			parts = line.split(": ");
		    speedPendant = Double.parseDouble(parts[1]);
		    
		    line = br.readLine();
			parts = line.split(": ");
		    angle = Integer.parseInt(parts[1]);
		    
		    br.close();
		} catch (IOException e) {
			System.out.println("Error while reading the file");
		}		
	}
}
