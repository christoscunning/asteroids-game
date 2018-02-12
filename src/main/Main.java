package main;

import processing.core.PApplet;

import java.util.ArrayList;

import entities.*;

public class Main extends PApplet {
	
	public static final int SCREEN_W = 800;
	public static final int SCREEN_H = 600;
	
	Ship player = new Ship(SCREEN_W/2,SCREEN_H/2,0,0,10);
	
	// ArrayList of Asteroids
	ArrayList<Asteroid> astList = new ArrayList<Asteroid>();
	// ArrayList of Bullets
	ArrayList<Bullet> bList = new ArrayList<Bullet>();
	
	/* Run once for every frame */
	public void draw() {
		// Clear the screen
		clear();
		
		// check input then move the player
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
		// Move and Draw player
		player.move();
		player.draw(this);
		
		// Move and Draw all asteroids
		for(int i = 0;i<astList.size();i++) {
			astList.get(i).move();
			astList.get(i).draw(this);
			//temp.draw(this);
		}
		
		// Move and Draw all bullets
		for (int i = 0; i<bList.size();i++) {
			bList.get(i).move();
			bList.get(i).draw(this);
		}
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
		if (key == 32) {
			System.out.println("space");
			newB();
		}
	}
	
	private void newB () {
		System.out.println(Bullet.getBCount());
		if(Bullet.getBCount()<5) {
			System.out.println("constructing");
			Bullet b = new Bullet(player.getX(), player.getY(), player.getDirection(), this);
			b.setup(this);
			bList.add(b);
		}
		System.out.println("x:"+player.getX()+" y:"+player.getY()+" dir:"+player.getDirection());
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
		
		// add asteroids to the astList
		for(int i=0; i<5;i++) {
			float x = 50f + Asteroid.getRandNumBetween(SCREEN_W-50);
			float y = 50f + Asteroid.getRandNumBetween(SCREEN_H-50);
			Asteroid a = new Asteroid(x,y,30);
			astList.add(a);
			a.setup(this);
		}
	}
	
	/* Run once at very start */
	public void settings() {
		size(SCREEN_W,SCREEN_H);
	}
	
	
	public static void main(String[] args) {
		PApplet.main("main.Main");
	}
	
}
