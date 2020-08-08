import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Player here.
 * 
 * @author Joe Degiovanni
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * line of comment
     */
    
    int speed = 7; // move 7 units
    int time = 0;
    public Player()
    {
        // this next line of code sets the player image
        setImage("sprite_character.png");
        getImage().mirrorHorizontally();
    }

    public void turnAround()
    {
        //getNeighbours​(int distance, boolean diagonal, java.lang.Class<A> cls)
        List<Zombee> zombiesNearMe = getNeighbours(200, true, Zombee.class);
        if(zombiesNearMe.size() > 0) {
            Zombee zombeeToShoot = zombiesNearMe.get(0);
            turnTowards(zombeeToShoot.getX(), zombeeToShoot.getY());
        }
    }
    
    public void moveAround()
    {
        if(Greenfoot.isKeyDown("w")) {
          setLocation(getX(), getY()-speed);
        }
        if(Greenfoot.isKeyDown("s")) {
          setLocation(getX(), getY()+speed);
        }
        if(Greenfoot.isKeyDown("a")) {
          setLocation(getX()-speed, getY());
        }
        if(Greenfoot.isKeyDown("d")) {
          setLocation(getX()+speed, getY());
        }
    }
    
    public void boomBoom()
    {
        if(Greenfoot.isKeyDown("space"))
        {
        Projectile projectile = new Projectile();
        getWorld().addObject(projectile, getX(), getY());
        projectile.setRotation(getRotation());
        //projectile.setRotation(getRotation()+randomRecoil); //randomRecoil
        //if(randomRecoil > 10)
        //randomRecoil = 0;
        }
    }
    
    public void youLose()
    {
        if(isTouching(Zombee.class))
        {
            getWorld().showText("You Lose! - You Lasted " + (time/60) + " seconds", getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
        }
    }
    
    public void act() 
    {
        time ++;
        turnAround();
        moveAround();
        boomBoom();
        youLose();
    }    
}
