package Enviroment;

/**
 * @author janka
 *
 */
public class Enviroment{
	
	private Car car = new Car();
	private Pendant pendant = new Pendant();
	
	private double startTime;
	
	public final double INF = 9999;
	
	public Enviroment(){
		startTime = System.currentTimeMillis();
		System.out.println(Distance(20,100,60));
		
		Frame frame = new Frame();	
		frame.reDraw();
	}
	
	/**
	 * Check if a car hitted pendant.
	 * @return True if a car hitted, false otherwise.
	 */
	private boolean isCrash(){
		if(distanceBetween(pendant.returnX(), pendant.returnY(), car.returnX(), car.returnY()) 
			< 5) return true;
		return false;
		
	}
	
	/**
	 * Computes distance to nearest object in given angle.
	 * @param x X coordinate of a car
	 * @param y Y coordinate of a car
	 * @param angle Angle in which is sensor used.
	 * @return Distance as an ultrasonic sensor in given angle.
	 */
	public double Distance(int x, int y, double angle){
		double deltaY = intersection(x, y, angle);
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
	private double intersection(int x, int y, double angle){
		int deltaX = pendant.returnX() - x;
	
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
	

}
