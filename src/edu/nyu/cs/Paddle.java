package edu.nyu.cs;
import processing.core.PApplet;
import processing.core.PImage;
public class Paddle extends PApplet{
    private int width = 50;
    private int height = 100;
    private PApplet app; // will hold a reference to PAplet
    private int coordX;
    private int coordY;
    private int velocity = 10;
    private int distance = 10;
    private int speed = 70;
    private int redIntegerValue;
    private int blueIntegerValue;
    private int greenIntegerValue;
    public Paddle(PApplet app, int xCoord, int yCoord){
        this.app = app;
        this.coordX = xCoord;
        this.coordY = yCoord;
    }
    // overload constructor, with the ability for the paddle to change colors
    public Paddle(PApplet app, int xCoord, int yCoord, int r, int b, int g){
        this.app = app;
        this.coordX = xCoord;
        this.coordY = yCoord;
        redIntegerValue = r;
        blueIntegerValue = b;
        greenIntegerValue = g;
    }

    /**  returns the value of xCoord
     * @return xCoord
     */
    public int getXCoord(){
        return this.coordX;
    }

    /**  returns the value of yCoord
     * @return yCoord
     */ 
    public int getYCoord(){
        return this.coordY;
    }

    /**  sets the xCoord to a new value
     * @param coordinate new value that will be assigned to xCoord
     */
    public void setXCoord(int coordinate){
            this.coordX = coordinate;
       
    }

    /**  sets the yCoord to a new value
     * @param coordinate new value that will be assigned to yCoord
     */
    public void setYCoord(int coordinate){
            this.coordY = coordinate;
        
    }

    /**  draws the paddle out using the rect() method in PAplet
     * @param coordX the x coordinate of this object on the screen
     * @param coordY the y coordinate of this object on the screen
     */
    public void drawRect(int coordX, int coordY) {
        app.fill(255,255,255);
        app.rect(coordX, coordY , this.getWidth(), this.getHeight());
    }

    /**  draws the paddle out using the rect() method in PAplet
     * @param coordX the x coordinate of this object on the screen
     * @param coordY the y coordinate of this object on the screen
     * @param redIntegerVal integer value of the red component
     * @param greenIntegerVal integer value of the green component
     * @param blueIntegerVal integer value of the blue component
     */
    public void drawRect(int xWindow, int yWindow, int redIntegerVal, int greenIntegerVal, int blueIntegerVal) {
        app.fill(redIntegerVal, blueIntegerVal, greenIntegerVal);
        app.rect(xWindow, yWindow , this.getWidth(), this.getHeight());
    }

    /**  returns the value of the redIntegerVal as an int
     * @return redIntegerValue
     */ 
    public int getRedValue(){
        return this.redIntegerValue;
    }

    /**  returns the value of the blueIntegerVal as an int
     * @return blueIntegerValue
     */ 
    public int getBlueValue(){
        return this.blueIntegerValue;
    }

    /**  returns the value of the greenIntegerVal as an int
     * @return greenIntegerValue
     */ 
    public int getGreenValue(){
        return this.greenIntegerValue;
    }

    /**  returns the value of the paddle's width as an int
     * @return width
     */ 
    public int getWidth(){
        return this.width;
    }

    /**  returns the value of the paddle's height as an int
     * @return height
     */ 
    public int getHeight(){
        return this.height;
    }

    /**  sets the velocity of the paddle
     *  @param newVelocity is the new value that will be assigned velocity
     */ 
    public void setVelocity(int newVelocity){
        this.velocity = newVelocity;
    }

    /**  sets the velocity of an object in the y-axis to a certain value.
     *  @param yCoordinate new y coordinate that 
     */ 
    public void setDirectionOfY(int yCoordinate){ 
        setVelocity(yCoordinate);
    }
    
    /**  allows the paddle to move by updating the position of the paddle based on its current velocity.
     */ 
    public void move(){
        setYCoord(this.getYCoord() + this.getVelocity());
    }

    /**  returns the value of speed
     * @return speed
     */ 
    public int getSpeed(){
        return this.speed; 
    }

    /**  returns the value of velocity
     * @return veloicty
     */
    public int getVelocity(){
        return this.velocity;
    }

    /**  updates the height of the paddle by adding the value of the tall parameter to the paddle's current height
     * @param tall the new value that will be assigned to the paddle's height
     */ 
    public void setHeight(int tall){
        this.height += tall;
    }


}
