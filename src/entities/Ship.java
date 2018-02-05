package entities;

import processing.core.PShape;
import main.Main;
import processing.core.PApplet;

/** The player controlled character: ship class
 * 
 *  TODO: Fix controls
 * 
 * @author Christos Cunning
 *
 */

public class Ship {
	
	public static final float MAX_SPEED = 5;
	public static final float MAX_ACCELERATION = 0.5f;
	public static final float MAX_TURN_SPEED = 5; // in degrees
	
	private float x,y; //position of ship
	private float dir; //direction of ship in radians
	private float spd; //speed of ship
	private float size; // pseudo radius
	private float deltaX, deltaY; // to get 
	
	PShape ship;
	
	public boolean isAccelerating;
	public boolean isDecelerating;
	public boolean isTurningCW;
	public boolean isTurningCCW;
	
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
		
		isAccelerating = false;
		isDecelerating = false;
		isTurningCW = false;
		isTurningCCW = false;
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
		
		
		
		x += deltaX;
		y += deltaY;
		System.out.println(deltaX + " " + deltaY);
		System.out.println("speed" + spd);
		
		//drag 
		if(deltaX > 0) {
			deltaX -= 0.05;
		} else if(deltaX < 0) {
			deltaX += 0.05;
		}
		
		if(deltaY > 0) {
			deltaY -= 0.05;
		} else if (deltaY < 0) {
			deltaY += 0.05;
		}
			
		if(spd > 0) {
			spd -= 0.05;
		} else if (spd < 0) {
			spd += 0.05;
		}
		
		//Next check for edge of screen and wrap around
		if (x+size > Main.SCREEN_W) {
			x = 0+size;
		}
		if (x-size < 0) {
			x = Main.SCREEN_W-size;
		}
		if (y+size > Main.SCREEN_H) {
			y = 0 + size;
		}
		if (y-size < 0) {
			y = Main.SCREEN_H-size;
		}
	}
	
	/* */
	public void draw(PApplet p) {
		p.shape(ship,x,y);
	}
	
	public void delta (float speed, float direction) {
		deltaX = speed * PApplet.cos(direction);
		deltaY = speed * PApplet.sin(direction);
	}
	
	public void speedUp(float ammount) {
		spd += ammount;
	}
	
	public void speedDown(float ammount) {
		spd -= ammount;
	}
	
	/** Turns the player controlled ship sprite by a specified angle, given in degrees.
	 *  positive angles turn the ship clockwise and vice versa.
	 * 
	 * @param angle the angle to rotate by, given in degrees
	 */
	public void turn (float angle) {
		dir += Math.toRadians((double) angle);
		ship.rotate((float) Math.toRadians((double) angle));
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
	
	/* Getters and setters */
	public float getSpeed() {
		return spd;
	}
	
	public float getDirection() {
		return dir;
	}
	
}
