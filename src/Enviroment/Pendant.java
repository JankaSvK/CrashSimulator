package Enviroment;

public class Pendant extends MovingObject {
	
	public Pendant(double StartTime) {		
		posX = 390;
		posY = 235;	
		
		lastRedrawn = StartTime;
	}

	/**
	 * Set a new position of the pendant;
	 * @param actualTime
	 */
	public void actualize(double actualTime) {
		double diff = actualTime - lastRedrawn;
		if(diff < 50) return;
		diff /= 1000;
		
		lastRedrawn = actualTime;
		
		posY = (posY + speed * METERSTODISPLAY * diff); /* s2 = s1 + v0*t */
	}
	
}
