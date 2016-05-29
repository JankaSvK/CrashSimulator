package Enviroment;

public class MovingObject {

	// Special constant of convertion to speed on display
	public final double METERSTODISPLAY = 5;
	
	public double speed = 0;
	public double maxSlowdown = 0;
	
	public double posX = 0;
	public double posY = 0;
	
	public double lastRedrawn = 0;

	public double returnX(){
		return posX;
	}
	
	public double returnY(){
		return posY;
	}
	
}
