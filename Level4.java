import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BrickWorld here.
 * 
 * Carter Cook
 * 9/16/21
 */
public class Level4 extends World
{
    private final float GRAVITY = 0.0667f;
    private final GreenfootSound MUSIC = new GreenfootSound("BrazilOST.mp3");
    private final int SPEED = 3;
    private final float JUMP_FORCE = 5.6f;
    private final int MAX_HEALTH = 3;
    private final int MAX_POWERUP = 3;
    private final Class NEXT_LEVEL = WinSplash.class;
    /**
     * Constructor for objects of class BrickWorld.
     * 
     */
    public Level4()
    {    
        // Create a new world with 1200x800 cells with a cell size of 1x1 pixels.
        super(1200, 710, 1, false); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Player player = new Player(SPEED, JUMP_FORCE, GRAVITY, MAX_HEALTH, MAX_POWERUP, NEXT_LEVEL, MUSIC);
        setPaintOrder(Player.class, Platform.class, Obstacle.class, Collectable.class,
            Door.class, HUD.class);
        addObject(player, 1000, 670);
        addObject(new Floor(), 600, 710);
        addObject(new Level4DoorVerySpecial (),1162,52);
        addObject(new SmBrickWall (), 1162, 104);
        addObject(new SmBrickWall (), 1062, 104);
        addObject(new SmBrickWall (), 850, 650);
        addObject(new SmBrickWall (), 1000, 500);
        addObject(new SmBrickWall (), 675, 450);
        addObject(new SmBrickWall (), 675, 250);
        addObject(new SmBrickWall (), 775, 150);
        addObject(new BrickWall(), 300, 400);
        addObject(new Gem(), 100, 350);
    }
    public void act()
    {
        spawn();
    }
    private void spawn()
    {
        if(Math.random() < 0.005)
        {
            addObject(new Rock(GRAVITY), Greenfoot.getRandomNumber(1000), 1);
        }
        if(Math.random() < 0.005)
        {
            addObject(new AcidRain(GRAVITY), Greenfoot.getRandomNumber(1000), 1);
        }
        if(Math.random() < 0.025)
        {
            addObject(new EvilCrab(GRAVITY), Greenfoot.getRandomNumber(300), 1);
        }
    }
}