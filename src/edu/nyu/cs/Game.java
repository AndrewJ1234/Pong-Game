package edu.nyu.cs;

import java.nio.file.Paths;
import java.util.ArrayList;

import org.apache.commons.lang3.SystemUtils;

import processing.core.*; // import the base Processing library
import processing.sound.*; // import the processing sound library

/**
 * Describe your game succinctly here, and update the author info below.
 * Some starter code has been included for your reference - feel free to delete or modify it.
 * 
 * This game is pong. First one to reach 5 wins and then the game quits or else u can automatically quit the game.  
 *  
 * 
 * @author Andrew Jiang
 * @version 0.1
 */
public class Game extends PApplet {
  
  private SoundFile soundStartup; // will refer to a sound file to play when the program first starts
  private SoundFile soundClick; // will refer to a sound file to play when the user clicks the mouse
  private PImage imgMe; // will hold a photo of me
  private Paddle player1 = new Paddle(this, 0, 250);
  private Paddle player2 = new Paddle(this, 950, 250, 0,0,255);
  private Ball ball = new Ball(this, this.width/2, this.height/2);
  private int player1ScoreCount = 0;
  private int player2ScoreCount = 0;
	/**
	 * This method will be automatically called by Processing when the program runs.
   * - Use it to set up the initial state of any instance properties you may use in the draw method.
	 */
	public void setup() {
    // set the cursor to crosshairs
    this.cursor(PApplet.CROSS);

    // load up a sound file and play it once when program starts up
		String cwd = Paths.get("").toAbsolutePath().toString(); // the current working directory as an absolute path

    // some basic settings for when we draw shapes
    // this.ellipseMode(PApplet.CENTER); // setting so ellipses radiate away from the x and y coordinates we specify.
    this.imageMode(PApplet.CENTER); // setting so the ellipse radiates away from the x and y coordinates we specify.
    
  }

	/**
	 * This method is called automatically by Processing every 1/60th of a second by default.
   * - Use it to modify what is drawn to the screen.
   * - There are methods for drawing various shapes, including `ellipse()`, `circle()`, `rect()`, `square()`, `triangle()`, `line()`, `point()`, etc.
	 */
	public void draw() 
  {
    
    this.background(0, 0, 0); // fill the background with the specified r, g, b color.
    this.fill(255,255,255);
    ball.drawBall();
    player1.drawRect(player1.getXCoord(), player1.getYCoord());
    player2.drawRect(player2.getXCoord(), player2.getYCoord(), player2.getRedValue(), player2.getBlueValue(), player2.getGreenValue());
    
    String instructions1 = String.format("press w and s for player 1 ");
    String instructions2 = String.format("press o and l for player 2 ");
    String instructionsForQuit = String.format("Press q to quit");
    
    text(instructions1, this.width/2-65, 120);
    text(instructions2, this.width/2-65, 140);
    text(instructionsForQuit, this.width/2-45, 160);
    text(instructionsForScore, this.width/2-45, 180);
    text(player1Score, this.width/2-45, 200);
    text(player2Score, this.width/2-45, 220);

    hitBoundaries();
	}
    
  // }
	/**
	 * This method is automatically called by Processing every time the user presses a key while viewing the map.
	 * - The `key` variable (type char) is automatically is assigned the value of the key that was pressed.
	 * - The `keyCode` variable (type int) is automatically is assigned the numeric ASCII/Unicode code of the key that was pressed.
	 */
	public void keyPressed() {
    // the `key` variable holds the char of the key that was pressed, the `keyCode` variable holds the ASCII/Unicode numeric code for that key.
		System.out.println(String.format("Key pressed: %s, key code: %d.", this.key, this.keyCode));
    if(this.keyCode == 83){
      player1.setDirectionOfY((player1.getSpeed()));
      player1.move();
      player1.drawRect(player1.getXCoord(), player1.getYCoord());
      hitBoundaries();
  }
    if(this.keyCode == 87){
      player1.setDirectionOfY(-(player1.getSpeed()));
      player1.move();
      player1.drawRect(player1.getXCoord(), player1.getYCoord());
      hitBoundaries();
    }

    if(this.keyCode == 76){
      player2.setDirectionOfY((player2.getSpeed()));
      player2.move();
      player2.drawRect(player2.getXCoord(), player2.getYCoord());
      hitBoundaries();
  }
    if(this.keyCode == 79){
      player2.setDirectionOfY(-(player2.getSpeed()));
      player2.move();
      player2.drawRect(player2.getXCoord(), player2.getYCoord());
      hitBoundaries();
    }

    if(this.keyCode == 81){
      exit();
    }

    if(this.keyCode == 84){
      player1ScoreCount++;
    }
    if(this.keyCode == 89){
      player2ScoreCount++;
    }
  }

  /* This method is automatically called by Processing every time the user releases a key while viewing the map.
	 * - The `key` variable (type char) is automatically is assigned the value of the key that was released.
	 * - it prevents the paddles from moving, when you press no buttons.
	 */
  public void keyReleased(){
    if(this.keyCode == 87){
      player1.setDirectionOfY(0);
      player1.move();
     
  }
    if(this.keyCode == 83){
      player1.setDirectionOfY(0);
      player1.move();
    }

    if(this.keyCode == 76){
      player2.setDirectionOfY(0);
      player2.move();
  }

    if(this.keyCode == 79){
      player2.setDirectionOfY(0);
      player2.move();
    }
  }
  /**
	 * it prevents the paddle from going off the window
	 * additionally, it also prevents the ball from going off the window
   * also allows the paddle to hit the ball
	 */
  public void hitBoundaries(){
   
// prevents paddle from going off the window
if(player1.getYCoord() <= 0){
  player1.setYCoord(0);
}
if(player1.getYCoord() >= 500 - player1.getHeight()){
  player1.setYCoord(500 - player1.getHeight());
}
if(player2.getYCoord() <= 0){
  player2.setYCoord(0);
}
if(player2.getYCoord() >= 500 - player2.getHeight()){
  player2.setYCoord(500 - player2.getHeight());
}

// // the ball will be able to bounce off the paddle on player 1
// if (ball.getXCoord() + ball.getWidth()/2 > player1.getXCoord() && ball.getXCoord() < player1.getXCoord() + player1.getWidth() && ball.getYCoord() + ball.getWidth() > player1.getYCoord() && ball.getYCoord() < player1.getYCoord() + player1.getHeight()) {
//   ball.setVelocityAtX(Math.abs(ball.getVelocityAtX()));
//   // ball.setVelocityAtX(ball.getVelocityAtX()+ 1);
//   if (ball.getVelocityAtY() > 0) {
//     ball.setVelocityAtY(ball.getVelocityAtY() + 1);
//   } 
//   else {
//     ball.setVelocityAtY(ball.getVelocityAtY() - 1);
//   }
//   ball.setVelocityAtX(ball.getVelocityAtX());
//   ball.setVelocityAtY(ball.getVelocityAtY());


// ball collides with paddle
if ((ball.getXCoord() <= player1.getWidth() && ball.getYCoord() >= player1.getYCoord() && ball.getYCoord() <= player1.getYCoord() + player1.getHeight()) ||
        (ball.getXCoord() >= 1000 - player2.getWidth() && ball.getYCoord() >= player2.getYCoord() && ball.getYCoord() <= player2.getYCoord() + player2.getHeight())) {
          ball.setVelocityAtX(-ball.getVelocityAtX());
    }

}

  

	/**
	 * This method is automatically called by Processing every time the user clicks a mouse button.
	 * - The `mouseX` and `mouseY` variables are automatically is assigned the coordinates on the screen when the mouse was clicked.
   * - The `mouseButton` variable is automatically assigned the value of either the PApplet.LEFT or PApplet.RIGHT constants, depending upon which button was pressed.
   */
	public void mouseClicked() {
		System.out.println(String.format("Mouse clicked at: %d:%d.", this.mouseX, this.mouseY));
   
	}

	/**
	 * This method is automatically called by Processing every time the user presses down and drags the mouse.
	 * The `mouseX` and `mouseY` variables are automatically is assigned the coordinates on the screen when the mouse was clicked.
   */
	public void mouseDragged() {
		System.out.println(String.format("Mouse dragging at: %d:%d.", mouseX, mouseY));
	}

  /**
   * A method that can be used to modify settings of the window, such as set its size.
   * This method shouldn't really be used for anything else.  
   * Use the setup() method for most other tasks to perform when the program first runs.
   */
  public void settings() {
		size(1000, 500); // set the map window size, using the OpenGL 2D rendering engine
		System.out.println(String.format("Set up the window size: %d, %d.", width, height));    
  }

  /**
   * The main function is automatically called first in a Java program.
   * When using the Processing library, this method must call PApplet's main method and pass it the full class name, including package.
   * You shouldn't need to modify this method.
   * 
   * @param args An array of any command-line arguments.
   */
  public static void main(String[] args) {
    // make sure we're using Java 1.8
		System.out.printf("\n###  JDK IN USE ###\n- Version: %s\n- Location: %s\n### ^JDK IN USE ###\n\n", SystemUtils.JAVA_VERSION, SystemUtils.getJavaHome());
		boolean isGoodJDK = SystemUtils.IS_JAVA_1_8;
		if (!isGoodJDK) {
			System.out.printf("Fatal Error: YOU MUST USE JAVA 1.8, not %s!!!\n", SystemUtils.JAVA_VERSION);
		}
		else {
			PApplet.main("edu.nyu.cs.Game"); // do not modify this!
		}
  }

}




	