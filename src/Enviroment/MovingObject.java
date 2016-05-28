package Enviroment;

public class MovingObject {

	public final double METERSTODISPLAY = 8.5;
	
	public double speed = 0;
	public double maxSlowdown = 0;
	
	public double posX = 0;
	public double posY = 0;
	
	public double lastRedrawed = 0;

	public double returnX(){
		return posX;
	}
	
	public double returnY(){
		return posY;
	}
	
	public void actualizeRedrawed(double time){
		lastRedrawed = time;
	}
	
	
}
