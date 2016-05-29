package Enviroment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			InputStreamReader read = new InputStreamReader(System.in);
			BufferedReader in = new BufferedReader(read);
	        int n;
	        System.out.println("Enter the name of the file to test");
	        String name = in.readLine();
	        
	        File f = new File(name);
	        if(!f.exists()) { 
	        	System.out.println("Set does not exists, try new one");
	        	name = in.readLine();
		        
	        	f = new File(name);
	        }
	        
			new Enviroment(name);
		} catch (IOException e) {
			System.out.println("Error while reading from standart input");
		}
        
	}

}
