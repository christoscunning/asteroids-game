package main;

import processing.core.PApplet;
import entities.*;

public class Main extends PApplet {
	
	public static final int SCREEN_W = 800;
	public static final int SCREEN_H = 600;
	
	Ship player = new Ship(SCREEN_W/2,SCREEN_H/2,0,0,10);
	
	/* Run once for every frame */
	public void draw() {
		clear();
		
		// Run keyPressed function to check for user input
		
		
		
		
		// Move then draw the player sprite
		if(player.isAccelerating) {
			if(player.getSpeed() < Ship.MAX_SPEED) {
				player.speedUp(Ship.MAX_ACCELERATION);
				player.delta(player.getSpeed(), player.getDirection());
			}
		} else if (player.isDecelerating) {
			if(player.getSpeed() > -Ship.MAX_SPEED/2) {
				player.speedDown(Ship.MAX_ACCELERATION);
				player.delta(player.getSpeed(), player.getDirection());
			}
		}
		if(player.isTurningCW) {
			player.turn(Ship.MAX_TURN_SPEED);
		} else if (player.isTurningCCW) {
			player.turn(-Ship.MAX_TURN_SPEED);
		}
		player.move();
		player.draw(this);
		
		
	}
	
	/* Checking for keyboard input from user */
	public void keyPressed() {
		if (key == 'w' || key == 'W') {
			player.isAccelerating = true;
		}
		if (key == 's' || key == 'S') {
			player.isDecelerating = true;
		}
		if (key == 'd' || key == 'D') {
			player.isTurningCW = true;
		}
		if (key == 'a' || key == 'A') {
			player.isTurningCCW = true;
		}
	}
	
	public void keyReleased() {
		if (key == 'w' || key == 'W') {
			player.isAccelerating = false;
		}
		if (key == 's' || key == 'S') {
			player.isDecelerating = false;
		}
		if (key == 'd' || key == 'D') {
			player.isTurningCW = false;
		}
		if (key == 'a' || key == 'A') {
			player.isTurningCCW = false;
		}
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
