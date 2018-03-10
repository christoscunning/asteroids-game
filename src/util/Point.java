package util;

/** Point class, holds x and y float values
 * 	Mainly used for checking collisions between objects
 * 
 * @author Christos Cunning
 */

import processing.core.PVector;

public class Point {
	public float x;
	public float y;
	
	/** Main constructor for Point class
	 * 
	 * @param x x coordinate of point
	 * @param y y coordinate of point 
	 */
	public Point(float x,float y) {
		this.x = x;
		this.y = y;
	}
	
	/** Creates a point from a PVector (Processing Library)
	 * 
	 * @param v
	 */
	public Point(PVector v) {
		this(v.x,v.y);
	}
 	
	/** For Debugging purposes will return a string nicely formatted
	 * 	with x and y value of point.
	 * 
	 * @return String containing x and y values of point
	 */
	public String printPoint () {
		return "Point (x: " + x + ", y: " + y + ")";
	}
}
