import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An apple that falls and increases score when eaten
 * 
 * @author Jimmy Yip 
 * @version May 29 2023
 */
public class Apple extends Actor
{
    /**
     * Act - falls from the sky and ends game if it touches the ground
     */
    public void act()
    {
        setLocation(getX(), getY() + 1);
        
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight())
        {
            world.gameOver();
            world.removeObject(this);
        }
    }
}
