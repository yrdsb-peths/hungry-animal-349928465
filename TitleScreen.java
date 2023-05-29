import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title screen which displays the name of the game and basic controls
 * 
 * @author Jimmy Yip
 * @version May 29 2023
 */
public class TitleScreen extends World
{
    // Labels for name, instructions, and controls
    Label titleLabel = new Label ("Hungry Elephant", 75);
    Label instructions = new Label ("Press <space> to begin", 40);
    Label controls = new Label ("Use 'A' and 'D' to move", 40);
    /**
     * Constructor for labels of class TitleScreen.
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        // Adds all the labels to the world
        addObject(titleLabel, getWidth()/2, (getHeight()/2 - 50));
        addObject(controls, 300, 250);
        addObject(instructions, 300, 300);;
        
    }
    
    /**
     * Changes screen when the spacebar is pressed
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
}
