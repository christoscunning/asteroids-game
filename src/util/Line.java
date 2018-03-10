package util;

/** Line class
 *  Holds Point object for each point that makes up the line
 *  Mainly used for collisions
 * 
 *  @author Christos Cunning
 */

import processing.core.PVector;

public class Line {
	public Point p1;
	public Point p2;
	
	/** Main Constructor for Line Class
	 *  Creates a Line from two Points
	 * 
	 * @param p1 First Point of Line
	 * @param p2 Second Point of Line
	 */
	public Line (Point p1, Point p2) {	
		this.p1 = p1;
		this.p2 = p2;
	}
	
	/** Constructor for Line from PVectors (from Processing Library)
	 * 
	 * @param v1 First PVector
	 * @param v2 Second PVector
	 */
	public Line (PVector v1, PVector v2) {
		this(new Point(v1), new Point(v2));
	}
	
	/** Method to get distance from a given point
	 *  to first end of Line.
	 * 
	 * @param p Point to get distance to
	 * @return Returns a float value that is the distance between given point and first end of Line.
	 */
	public float distPointP1 (Point p) {
		float x2x1 = p.x - p1.x;
		float y2y1 = p.y - p1.y;
		float rDist = (float)Math.sqrt(( x2x1*x2x1 ) + ( y2y1*y2y1 ));
		return rDist;
	}
	
	/** Method to get distance from a given point
	 *  to second end of Line.
	 * 
	 * @param p Point to get distance to
	 * @return Returns a float value that is the distance between given point and second end of Line.
	 */
	public float distPointP2 (Point p) {
		float x2x1 = p.x - p2.x;
		float y2y1 = p.y - p2.y;
		float rDist = (float)Math.sqrt(( x2x1*x2x1 ) + ( y2y1*y2y1 ));
		return rDist;
	}
	
	/** Method to get Length of Line
	 * 
	 * @return returns float value that is length of Line.
	 */
	public float getLineLength () {
		float dx = p2.x - p1.x;
		float dy = p2.y - p1.y;
		float rDist = (float)Math.sqrt((dx*dx) + (dy*dy));
		return rDist;
	}
	
	/** Method to print both x and y coordinates of Line neatly.
	 *  Mainly used for debugging.
	 * 
	 * @return Returns a String neatly formatted with x1,y1,x2,y2 coordinates of Line.
	 */
	public String printLine () {
		return "Line: x1: " + p1.x + " y1: " + p1.y + " x2: " + p2.x + " y2: " + p2.y;
	}
}
