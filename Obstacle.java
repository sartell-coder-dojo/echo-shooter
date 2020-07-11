import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Obstacle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obstacle extends Actor
{
    
    public Obstacle() {
       getImage().scale(35,35);
    }
    
    /**
     * Act - do whatever the Obstacle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        for(Actor intersectingActor: getIntersectingObjects(Actor.class)) {
            moveToNearestEdge(intersectingActor);
        }
    }
    
    public int getWestEdge(Actor actor) {
        return actor.getX() - (actor.getImage().getWidth() / 2);   
    }
    
    public int getEastEdge(Actor actor) {
        return actor.getX() + (actor.getImage().getWidth() / 2);   
    }
    
    public int getNorthEdge(Actor actor) {
        return actor.getY() + (actor.getImage().getHeight() / 2);   
    }
    
    public int getSouthEdge(Actor actor) {
        return actor.getY() - (actor.getImage().getHeight() / 2);   
    }
    
    public boolean isTouchingWestEdge(Actor actor) {
         return getWestEdge(actor) < getWestEdge(this) && 
                getEastEdge(actor) >= getWestEdge(this); 
    }
    
    public boolean isTouchingEastEdge(Actor actor) {
         return getWestEdge(actor) < getEastEdge(this) && 
                getEastEdge(actor) >= getEastEdge(this); 
    }
    
    public boolean isTouchingNorthEdge(Actor actor) {
         return getNorthEdge(actor) >= getNorthEdge(this) && 
                getSouthEdge(actor) < getNorthEdge(this); 
    }
    
    public boolean isTouchingSouthEdge(Actor actor) {
         return getNorthEdge(actor) >= getSouthEdge(this) && 
                getSouthEdge(actor) < getSouthEdge(this); 
    }
    
    private void moveToNearestEdge(Actor intersectingActor) {
        int newX = intersectingActor.getX();
        int newY = intersectingActor.getY();
        
        if (isTouchingWestEdge(intersectingActor)){
            newX = getWestEdge(this) - (intersectingActor.getImage().getWidth() / 2);
        } else if (isTouchingEastEdge(intersectingActor)) {
            newX = getEastEdge(this) + (intersectingActor.getImage().getWidth() / 2);
        }
        
        if (isTouchingNorthEdge(intersectingActor)){
            newY = getNorthEdge(this) + (intersectingActor.getImage().getHeight() / 2);
        } else if (isTouchingSouthEdge(intersectingActor)) {
            newY = getSouthEdge(this) - (intersectingActor.getImage().getHeight() / 2);
        }
        
        intersectingActor.setLocation(newX, newY);
    }
    
}
