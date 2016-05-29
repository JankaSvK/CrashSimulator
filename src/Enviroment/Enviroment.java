package Enviroment;

/**
 * @author Jana Bátoryová
 *
 */
public class Enviroment{
	
	private Car car;
	private Pendant pendant;
	private Frame frame;
	ReadingFromAFile reader;
	
	private double startTime;
	
	public final double INF = 9999;
	
	public Enviroment(){
		
		startTime = System.currentTimeMillis();
		
		car = new Car(startTime, this);
		pendant = new Pendant(startTime);
		frame = new Frame();	
		
		reader = new ReadingFromAFile("in2.txt");
		printAndSetReadedConstants(car, pendant);
	
		
		double actTime = System.currentTimeMillis();
		while (actTime - startTime <= 15000) {
			actTime = System.currentTimeMillis();
			
			car.actualize(actTime);
			car.ArtificialIntelligence();
			pendant.actualize(actTime);
			
			frame.drawObjects((int)car.returnX(), (int)car.returnY(), (int)pendant.returnX(), (int)pendant.returnY(), car.speedKM());
			
			if(isCrash(pendant, car)){
				echo("Havarka sa stala");
				processCrash();
				
				break;
			}
		}
		
	}
	
	private void printAndSetReadedConstants(Car car, Pendant p) {
		car.speed = reader.speedCar / 3.6;
		car.maxSlowdown = reader.maxSlowDown;
		car.angle = reader.angle;
		p.speed = reader.speedPendant;
		
		echo("Simulation was setuped to these constants:");
		echo("Speed of the car: " + car.speedKM());
		echo("Max. slowdown of the car: " + car.maxSlowdown);
		echo("Speed of the pendant: " + pendant.speed);
		echo("Angle of the zone of the sensor: " + car.angle);
		
		car.originalSpeed = car.speed;
	
	}

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
	
	
	public double Distance(double angle){
		if(pendant == null || car == null) return -1;
		return Distance(pendant, car.returnX(), car.returnY(), angle);
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
	
	public void echo(double x){
		System.out.println(x);
	}
	public void echo(String x){
		System.out.println(x);
	}
	

}
