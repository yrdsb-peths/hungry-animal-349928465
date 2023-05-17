import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elephant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elephant extends Actor
{
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    SimpleTimer aniTimer = new SimpleTimer();
    
    GreenfootSound elephantSound = new GreenfootSound("elephantnoise.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    
    String facing = "right";
    
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
    
    public void act()
    {
        moveAround();
        eat();
        animateElephant();
    }
    
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
    }
    
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
