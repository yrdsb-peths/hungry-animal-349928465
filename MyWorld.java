import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Main world where the game is played
 * 
 * @author Jimmy Yip
 * @version May 29 2023
 */
public class MyWorld extends World
{
    public static int score = 0;
    Label scoreboard;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        
        // Initializes the objects
        Elephant elephant = new Elephant();
        scoreboard = new Label(0, 50);
        BadApple badApp = new BadApple();
        Apple apple = new Apple();
        
        // Adds elephant, apple, scoreboard, bad apple
        addObject(elephant, 50, 365);
        addObject(apple, 300, 10);
        addObject(scoreboard, 55, 55);
        addObject(badApp, 150, 10);
    }
    
    /**
     * Changes the world to the end screen
     */
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
        EndScreen endWorld = new EndScreen();
        Greenfoot.setWorld(endWorld);
    }
    
    /**
     * Increases score by 1
     */
    public void increaseScore()
    {
        score++;
        scoreboard.setValue(score);
    }
    
    /**
     * Decreases score by 1
     */
    public void decreaseScore()
    {
        score--;
        scoreboard.setValue(score);
    }
    
    /**
     * Creates a new apple
     */
    public void createApple()
    {
        Apple apple2 = new Apple();
        int x = Greenfoot.getRandomNumber(600);
        int y = Greenfoot.getRandomNumber(10);
        addObject(apple2, x, y);
    }
    
    /**
     * Creates a new bad apple
     */
    public void createBadApple()
    {
        BadApple apple = new BadApple();
        int x = Greenfoot.getRandomNumber(600);
        int y = Greenfoot.getRandomNumber(10);
        addObject(apple, x, y);
    }
    
    /**
     * Returns score then resets it back to 0
     */
    public static int getScore()
    {
        int prevScore = score;
        score = 0;
        return prevScore; 
    }
}
