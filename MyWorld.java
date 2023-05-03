import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        Elephant elephant = new Elephant();
        Apple apple = new Apple();
        
        addObject(elephant, 50, 250);
        addObject(apple, 300, 10);
    }
    
    public void createApple()
    {
        Apple apple2 = new Apple();
        int x = Greenfoot.getRandomNumber(600);
        int y = Greenfoot.getRandomNumber(10);
        addObject(apple2, x, y);
    }
}
