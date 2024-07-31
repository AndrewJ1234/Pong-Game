package edu.nyu.cs;
import java.util.Random;

import processing.core.PApplet;
import processing.core.PImage;

public class Ball extends PApplet{
     private PApplet app; // will hold a reference to PApplet 
     private int xCoord; // will hold the x coordinate of this object on the screen
     private int yCoord; // will hold the y coordinate of this object on the screen
     private int width = 30;
     private int height = 30;
     private int velocityAtX = 2;
     private int velocityAtY = 2;
     Random random = new Random(); // creates a random object
     private int randomXCoord = random.nextInt(2) + 1;
     private int randomYCoord = random.nextInt(2) + 1;
     private int diameter = 30;
    public Ball(PApplet app, int xCoord, int yCoord){
        this.app = app;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        if(randomXCoord == 1){
            this.setVelocityAtX(-4);
            this.setVelocityAtY(-4);
        }
        else{
            this.setVelocityAtX(4);
            this.setVelocityAtY(4);
        }
        setXRandomly(); // sets the initial random velocity value that is in the x direction
        setYRandomly(); // sets the initial random velocity value that is in the y direction

    }
     /*
      * draws the ball and moves it
       */
    public void drawBall() {
        this.move();
        app.ellipse(this.getXCoord(), this.getYCoord(), this.getWidth(), this.getHeight());
    }

    /* sets the velocity and direction of an object in the x-axis randomly.
    */
    public void setXRandomly(){
        setVelocityAtX(this.getRandomXNumber() * this.getVelocityAtX());
    }

    /* sets the velocity and direction of an object in the y-axis randomly.
    validates the parameter
    */
    public void setYRandomly(){
        setVelocityAtY(this.getRandomYNumber() * this.getVelocityAtY());
    }

    /** returns the value of the width of the ball
     * @return ball's width
    */
    public int getWidth() {
        return this.width;
    }
    /** allows the ball to randomly move across the window
    */
    public void move(){
       setXCoord(this.getVelocityAtX() + this.getXCoord());
       setYCoord(this.getVelocityAtY() + this.getYCoord());
       if(this.getYCoord() < 0 || this.getYCoord() > 500 - this.getHeight()/2) {
        this.setVelocityAtY(-this.getVelocityAtY());
      }
    }

    /** returns the value of velocityAtX
     * @return ball's velocity at x axis
    */
    public int getVelocityAtX(){
        return this.velocityAtX;
    }

    /** returns the value of velocityAtY
     * @return ball's velocity at y axis
    */
    public int getVelocityAtY(){
        return this.velocityAtY;
    }

   /** returns a random x coordinate 
     * values are either 1 or 2 for the random x coordinate
     * @return a random number
    */
    public int getRandomXNumber(){
        return this.randomXCoord;
    }

    /** returns a random y coordinate 
     * values are either 1 or 2 for the random y coordinate
     * @return a random number
    */
    public int getRandomYNumber(){
        return this.randomYCoord;
    }

    /** sets the velocityAtX variable to a new velocity
     * @param veloictyX new value that will be assigned to velocityAtX
    */
    public void setVelocityAtX(int velocityX){
            this.velocityAtX = velocityX;
        }
        

    /** sets the velocityAtY variable to a new velocity
     * @param veloictyY new value that will be assigned to velocityAtY
    */
    public void setVelocityAtY(int velocityY){
            this.velocityAtY = velocityY;
    }

     /** returns the ball's height
      * @return the paddle's height
    */
    public int getHeight() {
        return this.height;
    }

     /**  sets the yCoord to a new value
     * @param coordinate new value that will be assigned to yCoord
     */
    public void setYCoord(int coordinate) {
            this.yCoord = coordinate;
    }

    /**  sets the xCoord to a new value
     * @param coordinate new value that will be assigned to xCoord
     */
    public void setXCoord(int coordinate) {
            this.xCoord = coordinate;
    }

    /**  returns the value of xCoord
     * @return x coordinate
     */
    public int getXCoord(){
        return this.xCoord;
    }

    /**  returns the value of xCoord
     * @return the y coordinate
     */
    public int getYCoord(){
        return this.yCoord;
    }
    /**
     * returns the value of the diameter
     * @return the integer value of diameter of the ball
     */
    public int getDiameter(){
        return this.diameter;
    }

    

}
