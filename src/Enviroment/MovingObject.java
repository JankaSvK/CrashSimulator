package Enviroment;

public class MovingObject {

	public double speed = 0;
	public double maxSlowdown = 0;
	
	public int posX = 0;
	public int posY = 0;
	
	public double lastRedrawed = 0;

	public int returnX(){
		return posX;
	}
	
	public int returnY(){
		return posY;
	}
	
	public void actualizeRedrawed(double time){
		lastRedrawed = time;
	}
	
	
}
