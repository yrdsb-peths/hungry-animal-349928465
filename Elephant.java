import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The elephant which the user controls
 * 
 * @author Jimmy Yip
 * @version May 29 2023
 */
public class Elephant extends Actor
{
    // Create simple timer
    SimpleTimer aniTimer = new SimpleTimer();
    
    // Load elephant sounds from file
    GreenfootSound elephantSound = new GreenfootSound("elephantnoise.mp3");
    
    // Load idle images
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    
    String facing = "right";
    
    
    /**
     * Constructor which initializes idle images and timer
     */
    public Elephant()
    {
        for (int x = 0; x < idleRight.length; x++)
        {
            idleRight[x] = new GreenfootImage("images/elephant_idle/idle" + x + ".png");
            idleRight[x].scale(65, 65);
        }
        
        for (int x = 0; x < idleLeft.length; x++)
        {
            idleLeft[x] = new GreenfootImage("images/elephant_idle/idle" + x + ".png");
            idleLeft[x].mirrorHorizontally();
            idleLeft[x].scale(65, 65);
        }
        aniTimer.mark();
        setImage(idleRight[0]);
    }
    
    int imageIndex = 0;
    /**
     * Animates the 8 elephant idle images
     */
    public void animateElephant()
    {
        if (aniTimer.millisElapsed() > 50)
        {  
            if (facing.equals("right"))
            {
                setImage(idleRight[imageIndex]);
                imageIndex = (imageIndex + 1) % idleRight.length;
            }
            else
            {
                setImage(idleLeft[imageIndex]);
                imageIndex = (imageIndex + 1) % idleLeft.length;
            }
            aniTimer.mark();
        }
    }
    
    /**
     * Runs the other methods
     */
    public void act()
    {
        moveAround();
        eat();
        animateElephant();
    }
    
    /**
     * Eats the apple and bad apple when it is touching
     */
    public void eat()
    {
        if (isTouching(Apple.class))
        {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.createApple();
            world.increaseScore();
            elephantSound.play();
        }
        if (isTouching(BadApple.class))
        {
            removeTouching(BadApple.class);
            MyWorld world = (MyWorld) getWorld();
            world.createBadApple();
            world.decreaseScore();
            elephantSound.play();
        }
    }
    
    /**
     * Moves the elephant with left and right with 'A' and 'D' keys
     */
    public void moveAround()
    {
        if (Greenfoot.isKeyDown("A"))
        {
            move(-2);
            facing = "left";
        }
        if (Greenfoot.isKeyDown("D"))
        {
            move(2);
            facing = "right";
        }
    }
}
