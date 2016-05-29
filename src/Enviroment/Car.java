package Enviroment;

public class Car extends MovingObject {
	public double actualSlowdown = 0;
	
	Enviroment enviroment;
	public final int width = 60;
	public final int height = 40;
	
	public double originalSpeed;
	public int angle;
	
	public Car(double StartTime, Enviroment enviroment) {
		posX = 50;
		posY = 290;
		
		lastRedrawn = StartTime;
		this.enviroment = enviroment;
	}
	
	/**
	 * Return speed of the car in Kilometers per hour (instead of meters per second).
	 * @return
	 */
	public double speedKM() {
		return speed*3.6;
	}

	
	/**
	 * Compute slowdown.
	 * @param percent
	 */
	public void brake(int percent){
		actualSlowdown = percent  * maxSlowdown / 100;
	
		if(speed > originalSpeed) {
			actualSlowdown = 0; 
			speed = originalSpeed;
		}
	}
	
	/**
	 * Set new position of the car and speed.
	 * @param actualTime
	 */
	public void actualize(double actualTime){
		double diff = actualTime - lastRedrawn;
		if(diff < 50) return;
		diff /= 1000;
		
		lastRedrawn = actualTime;
		
		posX = (posX + ((speed * METERSTODISPLAY) * diff) - (actualSlowdown * METERSTODISPLAY)*diff*diff/2); /* s2 = s1 + v0*t + a*t^2/2 */
		actualizeSpeed(diff);
		
	}
	
	/**
	 * Function for computing speed.
	 * @param diff
	 */
	public void actualizeSpeed(double diff) {
		speed = speed - diff * actualSlowdown;
		if(speed <= 0) {
			speed = 0;
			actualSlowdown = 0;
		}
	}
	
	/**
	 * ArtificialIntelligence for the car using the sensrs.
	 */
	public void ArtificialIntelligence(){
		if(enviroment.isInZone(angle) < 100){
			brake(100);
		} else { // zobrazovanie brzdnej drahy
			brake(-50);
		}
	}


	
}
