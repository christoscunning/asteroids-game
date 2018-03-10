package entities;

import processing.core.PApplet;
import processing.core.PShape;
import util.*;
import main.Main;

/** The asteroid class
 * 
 * @author Christos Cunning
 *
 */

public class Asteroid {

	public static final float SPEED = 2;
	
	private float x,y; //position of ship
	private float dir; //direction of ship in radians
	private float radius; // pseudo radius
	
	PShape asteroid;
	
	/** Constructor for Asteroid class
	 *  
	 * 
	 * @param x initial x position of the asteroid
	 * @param y initial y position of the asteroid
	 * @param radius radius of the asteroid
	 */
	public Asteroid (float x, float y, float radius) {
		this.x = x;
		this.y = y;
		this.dir = getRandNumBetween((float)Math.PI*2);
		this.radius = radius;
	}
	
	public void move () {
		x += SPEED * PApplet.cos(dir);
		y += SPEED * PApplet.sin(dir);
		
		//Next check for edge of screen and wrap around
				if (x+radius > Main.SCREEN_W) {
					x = 0+radius;
				}
				if (x-radius < 0) {
					x = Main.SCREEN_W-radius;
				}
				if (y+radius > Main.SCREEN_H) {
					y = 0 + radius;
				}
				if (y-radius < 0) {
					y = Main.SCREEN_H-radius;
				}
	}
	
	public void draw (PApplet p) {
		p.shape(asteroid,x,y);
	}
	
	public boolean isCollidingWithBullet (Bullet b, Main m) {
		int numVertex = asteroid.getVertexCount();
		boolean colliding = false;
		Line l;
		for (int i = 0; i < numVertex; i++) {
			// to avoid out of bounds exception
			if(i == numVertex-1) {
				// if last vertex, get line between last vertex and first vertex
				l = new Line(asteroid.getVertex(i), asteroid.getVertex(0));
			} else {
				// else just get line between vertex and next vertex
				//l = new Line(asteroid.getVertex(i), asteroid.getVertex(i+1));
				l = new Line(new Point(x + asteroid.getVertex(i).x, y+asteroid.getVertex(i).y), new Point(x+asteroid.getVertex(i+1).x, y+asteroid.getVertex(i+1).y));
				m.drawLine(l);
				//System.out.println("vertex i: "+asteroid.getVertex(i) + " vertex next: "+ asteroid.getVertex(i+1));
				
			}
			// debugging
			if(LinePointCollision.isPointCollidingWithLine(new Point(b.getXCenter(), b.getYCenter()), l)) colliding = true;
		}
		//System.out.println("is colliding: " + colliding);
		return colliding;
	}
	
	public void setup (PApplet p) {
		//draw custom asteroid shape
		asteroid = p.createShape();
		asteroid.beginShape();
		asteroid.stroke(200);
		asteroid.fill(0);
		// random vertices
		float firstX = radius+getRandNumBetween(radius);
		float firstY = getRandNumBetween(radius);
		asteroid.vertex(firstX, firstY);
		asteroid.vertex(getRandNumBetween(radius), radius+getRandNumBetween(radius));
		asteroid.vertex(-getRandNumBetween(radius), radius+getRandNumBetween(radius));
		asteroid.vertex(-radius-getRandNumBetween(radius), getRandNumBetween(radius));
		asteroid.vertex(-radius-getRandNumBetween(radius), -getRandNumBetween(radius));
		asteroid.vertex(-getRandNumBetween(radius), -radius-getRandNumBetween(radius));
		asteroid.vertex(getRandNumBetween(radius), -radius-getRandNumBetween(radius));
		asteroid.vertex(radius+getRandNumBetween(radius), -getRandNumBetween(radius));
		asteroid.vertex(firstX, firstY);
		
		asteroid.endShape();
	}
	
	/** Method to get random number between 0 and n (inclusive). To get position of vertices of randomly generated asteroid.
	 * 
	 * @param n upper limit of random range
	 * @return returns a random int between 0 and n.
	 */
	public static float getRandNumBetween (float n) {
		float ranr = ( ((float)Math.random() * n ) + 1);
		return ranr;
	}
	
}
