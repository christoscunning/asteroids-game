package entities;

import processing.core.PShape;
import processing.core.PApplet;

/** The player controlled character: ship class
 * 
 * @author Christos Cunning
 *
 */

public class Ship {
	
	private float x,y; //position of ship
	private float dir; //direction of ship in radians
	private float spd; //speed of ship
	private float size;
	
	PShape ship;
	
	/** Constructor method for ship object
	 *  Player controlled character
	 * 
	 * @param x starting x position of the ship
	 * @param y starting y position of the ship
	 * @param dir starting direction of the ship in radians
	 * @param spd starting speed of the ship
	 * @param size size of the ship (pseudo radius)
	 */
	public Ship (float x, float y, float dir, float spd, float size) {
		this.x = x;
		this.y = y;
		this.dir = (float) (dir + (3*Math.PI)/2);
		this.spd = spd;
		this.size = size;
	}
	
	/** Move method for ship class
	 *  Go distance spd at direction dir
	 *  Change by x and y components
	 *  (Right triangle) dir is radians
	 *  
	 *  	3pi/2
	 *  pi			0
	 * 		 pi/2
	 * 
	 */
	public void move () {
		x += spd * PApplet.cos(dir);
		y += spd * PApplet.sin(dir);
		
		//Next check for edge of screen and wrap around
	}
	
	/* */
	public void draw(PApplet p) {
		p.shape(ship,x,y);
	}
	
	/* Run once at launch of application to create custom shape for ship*/
	public void setup(PApplet p) {
		ship = p.createShape();
		ship.beginShape();
		ship.stroke(255);
		ship.fill(0);
		
		ship.vertex(0,-size*2);
		ship.vertex(size,size);
		ship.vertex(0,0);
		ship.vertex(-size,size);
		ship.vertex(0, -size*2);
		
		ship.endShape();
	}
	
}
