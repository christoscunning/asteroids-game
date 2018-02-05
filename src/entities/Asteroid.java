package entities;

import processing.core.PApplet;
import processing.core.PShape;

/** The asteroid class
 * 
 * @author Christos Cunning
 *
 */

public class Asteroid {

	public static final float SPEED = 3;
	
	private float x,y; //position of ship
	private float dir; //direction of ship in radians
	private float radius; // pseudo radius
	
	PShape asteroid;
	
	/** Constructor for Asteroid class
	 *  
	 * 
	 * @param x initial x position of the asteroid
	 * @param y initial y position of the asteroid
	 * @param dir initial direction of asteroid (in radians) (random between 0,2pi)
	 * @param radius radius of the asteroid
	 */
	public Asteroid (float x, float y, float radius) {
		this.x = x;
		this.y = y;
		this.dir = getRandNumBetween((float)Math.PI*2);
		this.radius = radius;
	}
	
	public void draw (PApplet p) {
		p.shape(asteroid,x,y);
	}
	
	public void move () {
		
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
