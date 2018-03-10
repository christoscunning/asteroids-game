package util;

import processing.core.PVector;

public class Point {
	public float x;
	public float y;
	
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
 	
	public String printPoint () {
		return "Point (x: " + x + ", y: " + y + ")";
	}
}
