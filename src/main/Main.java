package main;

import processing.core.PApplet;

public class Main extends PApplet {
	
	/* Run once for every frame */
	public void draw() {
		rect(220,220,80,80);
	}
	
	
	/* Run once after drawing stuff is available */
	public void setup() {
		
	}
	
	/* Run once at very start */
	public void settings() {
		size(800,600);
	}
	
	public static void main(String[] args) {
		PApplet.main("main.Main");
	}
	
}
