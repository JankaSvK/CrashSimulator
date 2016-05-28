package Enviroment;

public class Car {

	public double speed = 50;
	private final double MaxSlowdown = 1;
	
	private int posX = 200;
	private final int posY = 100;
	
	private int NumOfSensors = 1;
	
	private double lastRedrawed;
	
	public int returnX(){
		return posX;
	}
	
	public int returnY(){
		return posY;
	}
	
	public void actualizeRedrawed(double time){
		lastRedrawed = time;
	}
	private void ArtificialIntelligence(){
		
		
		
	}
	
	
	
	
	
}
