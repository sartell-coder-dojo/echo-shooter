import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombee here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zombee extends Actor
{
    /**
     * Act - do whatever the Zombee wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    int health = 1;
    Player player;
    Counter counter;
    public Zombee(Player mainPlayer, Counter counter)
    {
        this.counter = counter;
        player = mainPlayer;
        setImage("sprite_enemy.png");
    }
    public void act() 
    {
        moveAround();
        hitByGun();
    }    
    public void moveAround()
    {
        if(isTouching(Obstacle.class)) {
            move(0);
        } else {
            move(1);
        }
        turnTowards(player.getX(), player.getY());
    }
    public void hitByGun()
    {
        Actor projectile = getOneIntersectingObject(Projectile.class);
        if(projectile != null)
        {
            health--;
            getWorld().removeObject(projectile);
            if(counter.score % 5 == 4) {
                health += 50;
                getImage().scale(50, 50);
                counter.score++;
            }
        }
        if(health == 0)
        {
            counter.score++;
            getWorld().removeObject(this);
        }    
    }
}
