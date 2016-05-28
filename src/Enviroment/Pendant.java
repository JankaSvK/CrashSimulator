package Enviroment;

public class Pendant {
	
	public double speed = 5;
	private final double MaxSlowdown = 1;
	
	private final int posX = 100;
	private int posY = 0;
	
	public double lastRedrawed;

	public int returnX(){
		return posX;
	}
	
	public int returnY(){
		return posY;
	}
	
}
