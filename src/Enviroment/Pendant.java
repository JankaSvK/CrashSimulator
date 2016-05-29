package Enviroment;

public class Pendant extends MovingObject {
	
	public Pendant(double StartTime) {
		speed = 10 / 3.6;
		maxSlowdown = 100;
		
		posX = 390;
		posY = 235;	
		
		lastRedrawn = StartTime;
	}

	public void actualize(double actualTime) {
		double diff = actualTime - lastRedrawn;
		if(diff < 50) return;
		diff /= 1000;
		
		lastRedrawn = actualTime;
		//int y = (int) Math.ceil((pendant.speed / 1000) * (actTime - startTime));
		
		posY = (posY + speed * METERSTODISPLAY * diff); /* s2 = s1 + v0*t */
		System.out.println(posY + " " + diff + " " + speed);
	
	}
	
}
