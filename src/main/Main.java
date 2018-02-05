package main;

import processing.core.PApplet;
import entities.*;

public class Main extends PApplet {
	
	private final int SCREEN_W = 800;
	private final int SCREEN_H = 600;
	
	Ship player = new Ship(SCREEN_W/2,SCREEN_H/2,0,0,10);
	
	/* Run once for every frame */
	public void draw() {
		clear();
		
		
		// Move then draw the player sprite
		player.move();
		player.draw(this);
		
		
	}
	
	
	
	/* Run once after drawing stuff is available */
	public void setup() {
		
		// set background color to black
		background(0);
		
		// setup player sprite (draw custom shape to screen)
		player.setup(this);
	}
	
	/* Run once at very start */
	public void settings() {
		size(SCREEN_W,SCREEN_H);
	}
	
	
	public static void main(String[] args) {
		PApplet.main("main.Main");
	}
	
}
