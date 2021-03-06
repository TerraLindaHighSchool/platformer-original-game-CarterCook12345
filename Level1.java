import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BrickWorld here.
 * 
 * Carter Cook
 * 9/16/21
 */
public class Level1 extends World
{
    private final float GRAVITY = 0.0667f;
    private final GreenfootSound MUSIC = new GreenfootSound("JazzButCooler.mp3");
    private final int SPEED = 3;
    private final float JUMP_FORCE = 5.6f;
    private final int MAX_HEALTH = 3;
    private final int MAX_POWERUP = 3;
    private final Class NEXT_LEVEL = Level2.class;
    /**
     * Constructor for objects of class BrickWorld.
     * 
     */
    public Level1()
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
        addObject(player, 96, 670);
        addObject(new Floor(), 600, 710);
        addObject(new Door (),1162,52);
        addObject(new BrickWall(), 380, 500);
        addObject(new BrickWall(), 780, 300);
        addObject(new BrickWall(), 960, 100);
        addObject(new SmBrickWall(), 1120, 600);
        addObject(new SmBrickWall(), 880, 600);
        addObject(new SmBrickWall(), 420, 160);
        addObject(new SmBrickWall(), 1000, 200);
        addObject(new SmBrickWall(), 220, 280);
        addObject(new TrapDoor(GRAVITY), 1000, 600);
        addObject(new TrapDoor(GRAVITY), 60, 400);
        addObject(new Cake(), 60, 350);
        addObject(new Bomb(GRAVITY), 465, 115);
        addObject(new Bomb(GRAVITY), 1000, 670);
        addObject(new Gem(), 975, 160);
        addObject(new Gem(), 1030, 160);
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