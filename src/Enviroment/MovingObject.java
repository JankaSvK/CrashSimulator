package Enviroment;

public class MovingObject {

	public double speed;
	private double MaxSlowdown;
	
	private int posX;
	private int posY;
	
	public double lastRedrawed;

	public int returnX(){
		return posX;
	}
	
	public int returnY(){
		return posY;
	}
	
	
}
