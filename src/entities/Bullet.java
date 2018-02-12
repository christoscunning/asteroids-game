package entities;

import processing.core.PShape;
import processing.core.PApplet;
import processing.core.PConstants;
import main.Main;

public class Bullet {
	public static final float SPD = 10;
	public static final float bWIDTH = 3;
	public static final float bHEIGHT = 8;
	
	private float x,y;
	private float dir; // value in rads
	private static int bcount = 0;
	private PShape b;
	
	/** Constructor for bullet object
	 *  Also preform setup in constructor
	 * 
	 * @param x initial x position of bullet
	 * @param y initial y position of bullet 
	 * @param dir initial direction of bullet
	 */
	public Bullet (float x, float y, float dir, PApplet p) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		bcount++;
	}
	

	public void move () {
		x += SPD * PApplet.cos(dir);
		y += SPD * PApplet.sin(dir);
		
		//Next check for edge of screen and wrap around
		if (x > Main.SCREEN_W) {
			x = 0;
		}
		if (x < 0) {
			x = Main.SCREEN_W;
		}
		if (y > Main.SCREEN_H) {
			y = 0;
		}
		if (y < 0) {
			y = Main.SCREEN_H;
		}
	}
	
	public void draw (PApplet p) {
		p.shape(b,x,y);
	}
	
	public void setup (PApplet p) {
		// RECT: x,y,w,h
		b = p.createShape(PConstants.RECT,0,0,bWIDTH,bHEIGHT);
		b.setFill(255);
		b.rotate(dir - (float)(3*Math.PI)/2);
	}
	
	
	public void close () {
		bcount--;
	}
	
	public static int getBCount () {
		return bcount;
	}
	
}
