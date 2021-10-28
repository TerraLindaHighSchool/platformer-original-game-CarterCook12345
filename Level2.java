import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BrickWorld here.
 * 
 * Carter Cook
 * 9/16/21
 */
public class Level2 extends World
{
    private final float GRAVITY = 0.0667f;
    private final GreenfootSound MUSIC = new GreenfootSound("incompetech_tribal.mp3");
    private final int SPEED = 3;
    private final float JUMP_FORCE = 5.6f;
    private final int MAX_HEALTH = 3;
    private final int MAX_POWERUP = 3;
    private final Class NEXT_LEVEL = Level3.class;
    /**
     * Constructor for objects of class BrickWorld.
     * 
     */
    public Level2()
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
        setPaintOrder(Player.class, Platform.class, Obstacle.class, Collectable.class,
            Door.class, HUD.class);
        Player player = new Player(SPEED, JUMP_FORCE, GRAVITY, MAX_HEALTH, MAX_POWERUP, NEXT_LEVEL, MUSIC);
        addObject(player, 96, 670);
        addObject(new Floor(), 600, 710);
        addObject(new Door (),10, 200);
        addObject(new BrickWall(), 0, 250);
        addObject(new BrickWall(), 650, 600);
        addObject(new BrickWall(), 650, 300);
        addObject(new SmBrickWall(), 950, 450);
        addObject(new SmBrickWall(), 1050, 450);
        addObject(new Cake(), 275, 375);
        addObject(new TrapDoor(GRAVITY), 210, 425);
        addObject(new TrapDoor(GRAVITY), 325, 425);
        addObject(new Bomb(GRAVITY), 275, 670);
        addObject(new Gem(), 1000, 750);
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
    }
}
