import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * End screen which displays the final score at the end of the game
 * 
 * @author Jimmy Yip
 * @version May 29 2023
 */
public class EndScreen extends World
{
    // Initialize labels
    Label titleLabel = new Label ("Game Over", 75);
    Label scoreLabel = new Label ("Score: " + MyWorld.getScore(), 50);
    /**
     * Constructor for objects of class EndScreen.
     * 
     */
    public EndScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        // Adds labels to the world
        addObject(titleLabel, getWidth()/2, getHeight()/2);
        addObject(scoreLabel, getWidth()/2, getHeight()/2 + 75);
    }
}
