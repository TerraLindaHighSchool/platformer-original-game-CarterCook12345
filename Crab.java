import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Crab here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
abstract class Crab extends Obstacle
{
    /**
     * Act - do whatever the Crab wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(3);
        turnAtEdge();
    }
    private void turnAtEdge()
    {
        if (isAtEdge())
        {
            turn(180);
        }
    }
}
