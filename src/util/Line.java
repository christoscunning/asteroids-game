package util;

import processing.core.PVector;

public class Line {
	public Point p1;
	public Point p2;
	
	public Line (Point p1, Point p2) {	
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public Line (PVector v1, PVector v2) {
		this(new Point(v1), new Point(v2));
	}
	
	public float distPointP1 (Point p) {
		float x2x1 = p.x - p1.x;
		float y2y1 = p.y - p1.y;
		float rDist = (float)Math.sqrt(( x2x1*x2x1 ) + ( y2y1*y2y1 ));
		return rDist;
	}
	
	public float distPointP2 (Point p) {
		float x2x1 = p.x - p2.x;
		float y2y1 = p.y - p2.y;
		float rDist = (float)Math.sqrt(( x2x1*x2x1 ) + ( y2y1*y2y1 ));
		return rDist;
	}
	
	public float getLineLength () {
		float dx = p2.x - p1.x;
		float dy = p2.y - p1.y;
		float rDist = (float)Math.sqrt((dx*dx) + (dy*dy));
		return rDist;
	}
	
	public String printLine () {
		return "Line: x1: " + p1.x + " y1: " + p1.y + " x2: " + p2.x + " y2: " + p2.y;
	}
}
