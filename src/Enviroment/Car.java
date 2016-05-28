package Enviroment;

public class Car extends MovingObject {
	public int NumOfSensors = 1;
	public double actualSlowdown = 0;
	
	Enviroment enviroment;
	public final int width = 60;
	public final int height = 40;
	
	public Car(double StartTime, Enviroment enviroment) {
		speed = 50 / 3.6; /*Prevod na m/s*/
		maxSlowdown = 4.5; /*Pri optimálnom brzdení môže automobil na suchej betónovej ceste dosiahnuť maximálne spomalenie 4,5 m/s^2*/
		
		posX = 50;
		posY = 290;
		
		lastRedrawn = StartTime;
		
		this.enviroment = enviroment;
	}
	

	public double speedKM() {
		return speed*3.6;
	}

	
	public void brake(int percent){
		actualSlowdown = percent  * maxSlowdown / 100;
	}
	
	public void actualize(double actualTime){
		double diff = actualTime - lastRedrawn;
		if(diff < 50) return;
		diff /= 1000;
		
		lastRedrawn = actualTime;
		
		posX = (posX + ((speed * METERSTODISPLAY) * diff) - (actualSlowdown * METERSTODISPLAY)*diff*diff/2); /* s2 = s1 + v0*t + a*t^2/2 */
		actualizeSpeed(diff);
		
		//System.out.println(posX + " " + diff + " " + speed + " " + actualSlowdown);
	}
	
	public void actualizeSpeed(double diff) {
		speed = speed - diff * actualSlowdown;
		if(speed <= 0) {
			speed = 0;
			actualSlowdown = 0;
		}
	}
	
	public void ArtificialIntelligence(){
		if(enviroment.Distance(60) < 100){
			brake(100);
		}
	}


	
}
