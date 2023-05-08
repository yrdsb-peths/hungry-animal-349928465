import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public int score = 0;
    Label scoreboard;
    
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
        scoreboard = new Label(0, 50);
        
        addObject(elephant, 50, 365);
        addObject(apple, 300, 10);
        addObject(scoreboard, 55, 55);
    }
    
    
    public void increaseScore()
    {
        score++;
        scoreboard.setValue(score);
    }
    
    public void createApple()
    {
        Apple apple2 = new Apple();
        int x = Greenfoot.getRandomNumber(600);
        int y = Greenfoot.getRandomNumber(10);
        addObject(apple2, x, y);
    }
}
