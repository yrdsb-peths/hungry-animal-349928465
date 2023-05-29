import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A bad apple that falls and decreases score when eaten
 * 
 * @author Jimmy Yip
 * @version May 29 2023
 */
public class BadApple extends Actor
{
    /**
     * Act - falls from the sky
     */
    public void act()
    {
        // Add your action code here.
        setLocation(getX(), getY() + 2);
        
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight())
        {
            world.removeObject(this);
            world.createBadApple();
        }
    }
}
