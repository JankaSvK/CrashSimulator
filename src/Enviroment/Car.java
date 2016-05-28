package Enviroment;

public class Car extends MovingObject {
	public int NumOfSensors = 1;
	public double actualSlowdown = 0;
	
	public Car(double StartTime) {
		speed = 50 / 3.6; /*Prevod na m/s*/
		maxSlowdown = 4.5; /*Pri optimálnom brzdení môže automobil na suchej betónovej ceste dosiahnuť maximálne spomalenie 4,5 m/s^2*/
		
		posX = 50;
		posY = 290;
		
		lastRedrawed = StartTime;
	}
	

	public double speedKM() {
		return speed*3.6;
	}

	
	public void brake(int percent){
		actualSlowdown = percent  * maxSlowdown / 100;
	}
	
	public void actualize(double actualTime){
		double diff = actualTime - lastRedrawed;
		if(diff < 50) return;
		diff /= 1000;
		
		lastRedrawed = actualTime;
		
		posX = (int) (posX + ((speed * METERSTODISPLAY) * diff) - (actualSlowdown * METERSTODISPLAY)*diff*diff/2); /* s2 = s1 + v0*t + a*t^2/2 */
		actualizeSpeed(diff);
		
		System.out.println(posX + " " + diff + " " + speed + " " + actualSlowdown);
	}
	
	public void actualizeSpeed(double diff) {
		speed = speed - diff * actualSlowdown;
		if(speed <= 0) {
			speed = 0;
			actualSlowdown = 0;
		}
	}
	
	private void ArtificialIntelligence(){
		
		
	}


	
}
