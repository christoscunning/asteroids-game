package util;

public class LinePointCollision {
		
	private static float buffer = 1f;
	
	/** Method to check for collision between a line and a point
	 *  checks for whether point is on line (within buffer)
	 * 
	 * @param p Point to check collision for
	 * @param l Line to check to see if point is colliding with
	 * @return returns true if point is colliding with line (within buffer), false otherwise
	 */
	public static boolean isPointCollidingWithLine(Point p, Line l) {
		float d1 = l.distPointP1(p);   // d1 = distance between point and one end of line
		float d2 = l.distPointP2(p);   // d2 = distance between point and other end of line
		float linelen = l.getLineLength();   // length of line
		
		// if sum of distance between point and each end of line are equal 
		// to length of line (within buffer) then point is on line
		if (d1+d2 >= linelen-buffer && d1+d2 <= linelen+buffer) {
			return true;
		}
	    return false;
	}
}
