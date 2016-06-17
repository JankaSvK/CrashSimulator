package Enviroment;

import java.io.File;

import javax.swing.JFileChooser;

/**
 * @author Jana Bátoryová
 *
 */
public class Enviroment{
	
	Car car;
	Pendant pendant;
	Frame frame;
	ReadingFromAFile reader;
	double startTime;
	
	public final double INF = 9999;
	
	public Enviroment(){
		
		frame = new Frame();	
		reader = new ReadingFromAFile("in1.txt"/*frame.chooseAFile()*/);
		
		
		startTime = System.currentTimeMillis();
		
		car = new Car(startTime, this);
		pendant = new Pendant(startTime);
		
		printAndSetReadedConstants(car, pendant);
		
		
		boolean crash = false;
		double actTime = System.currentTimeMillis();
		while (actTime - startTime <= 15000) {
			actTime = System.currentTimeMillis();
			
			car.actualize(actTime);
			car.ArtificialIntelligence();
			pendant.actualize(actTime);
			
			frame.drawObjects((int)car.returnX(), (int)car.returnY(), (int)pendant.returnX(), (int)pendant.returnY(), car.speedKM());
			
			if(isCrash(pendant, car)){
				echo("Crash!");
				crash = true;
				processCrash();
				break;
			}
		}
		
		if(!crash){
			car.speed = 0;
			pendant.speed = 0;
			
			echo("No crash!");
		}
		
		actTime = System.currentTimeMillis();
		double newTime = actTime;
		while (actTime - newTime <= 2500) {
			actTime = System.currentTimeMillis();
		}
		frame.close();
		
	}
	
	/**
	 * Outpus readed constants from and file and set them to objects.
	 * @param car
	 * @param p
	 */
	private void printAndSetReadedConstants(Car car, Pendant p) {
		car.speed = reader.speedCar / 3.6;
		car.maxSlowdown = reader.maxSlowDown;
		car.angle = reader.angle;
		p.speed = reader.speedPendant / 3.6;
		
		echo("Simulation was setuped to these constants:");
		echo("Speed of the car: " + car.speedKM());
		echo("Max. slowdown of the car: " + car.maxSlowdown);
		echo("Speed of the pendant: " + pendant.speed * 3.6);
		echo("Angle of the zone of the sensor: " + car.angle);
		
		car.originalSpeed = car.speed;
	
	}

	/**
	 * Check if a pendant is in zone seen by the sensor.
	 * If he is seen then it will return the distance between a car and him.
	 * Otherwise it return Infinity.
	 * @param angle
	 * @return
	 */
	public double isInZone(double angle){
		if(pendant == null || car == null) return -1;
		double minY = car.returnY() - intersection(pendant, car.returnX(), car.returnY(), angle);
		double maxY = car.returnY() - intersection(pendant, car.returnX(), car.returnY(), -angle);
			
		if(pendant.returnY() >= minY && pendant.returnY() <= maxY){
			return distanceBetween(pendant.returnX(), pendant.returnY(), car.returnX(), car.returnY());
		} else {
			return INF;
		}
	}
	
	/**
	 * After a crash it will stop pendant and also a car.
	 * Then it will print the speed of the car during the crash.
	 */
	private void processCrash() {
		double carSpeed = car.speed;
		frame.printSpeedInCrash(car.speedKM());
		car.speed = 0;
		pendant.speed = 0;
	}

	/**
	 * Check if a car hitted pendant.
	 * @return True if a car hitted, false otherwise.
	 */
	private boolean isCrash(Pendant pendant, Car car){
		if(pendant.returnX() >= car.returnX() - car.width / 2 
				&& pendant.returnY() <= car.returnY() + car.height / 2 
				&& pendant.returnX() <= car.returnX() + car.width / 2
				&& pendant.returnY() >= car.returnY() - car.height / 2
				) return true;
		return false;		
	}
	
	/**
	 * Computes distance to nearest object in given angle.
	 * @param x X coordinate of a car
	 * @param y Y coordinate of a car
	 * @param angle Angle in which is sensor used.
	 * @return Distance as an ultrasonic sensor in given angle.
	 */
	public double Distance(Pendant pendant, double x, double y, double angle){
		double deltaY = intersection(pendant, x, y, angle);
		double expectedY = y - deltaY;
		if(pendant.returnY() >= expectedY - 5 && pendant.returnY() <= expectedY + 5){
			return distanceBetween(x, y, pendant.returnX(), pendant.returnY());
		}
		return INF;
		
	}

	/**
	 * Computes Y-coordinate of intersection between a ray with given angle and pendant trajectory.
	 * @param x X coordinate of a car
	 * @param y Y coordinate of a car
	 * @param angle Angle in which is sensor used.
	 * @return Y-coordinate of intersection.
	 */
	private double intersection(Pendant pendant, double x, double y, double angle){
		double deltaX = pendant.returnX() - x;
	
		return deltaX * Math.tan(Math.toRadians(angle));
	}
	
	/**
	 * Computes distance between two points.
	 * @param x1 X coordinate of the first point.
	 * @param y1 Y coordinate of the first point.
	 * @param x2 X coordinate of the second point.
	 * @param y2 Y coordinate of second point.
	 * @return Distance between then first and the second point.
	 */
	private double distanceBetween(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1-y2,2));
	}
	
	/**
	 * Synonym to System.out.println - it is shorter variant.
	 * @param x
	 */
	public void echo(double x){
		System.out.println(x);
	}
	public void echo(String x){
		System.out.println(x);
	}
	

}
