import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    int count = 0;
    int spawnSpeed = 25;
    int randomSpawn;
    boolean isSpawnEnabled = true;
    public Player mainPlayer = new Player();
    Counter counter = new Counter();
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(512, 512, 1); 
        //getBackground().setColor(Color.GRAY);
        //getBackground().fill();
        addObject(mainPlayer, getWidth()/2, getHeight()/2);
        addObject(counter, 100,100);
        
        // add obstacles
        addObject(new Obstacle(), 175, 175);
        addObject(new Obstacle(), 270, 113);
        addObject(new Obstacle(), 334, 175);
        addObject(new Obstacle(), 111, 240);
        addObject(new Obstacle(), 430, 271);
        addObject(new Obstacle(), 177, 335);
        addObject(new Obstacle(), 239, 368);
        addObject(new Obstacle(), 336, 336);
    }
    public void spawnZombees()
    {
        if(count % spawnSpeed ==0 && isSpawnEnabled)
        {
            randomSpawn = Greenfoot.getRandomNumber(4);
            switch(randomSpawn)
            {
                case 0 : addObject(new Zombee(mainPlayer, counter), getWidth()/2, 0); break;
                case 1 : addObject(new Zombee(mainPlayer, counter), 0, getHeight()/2); break;
                case 2 : addObject(new Zombee(mainPlayer, counter), getWidth(), getHeight()/2); break;
                case 3 : addObject(new Zombee(mainPlayer, counter), getWidth()/2, getHeight()); break;
            }    
        }
    }
    public void act()
    {
        count ++;
        spawnZombees();
    }
}
