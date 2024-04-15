import mayflower.*;
/**
 * Write a description of class Enemy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    // instance variables - replace the example below with your own
    private int health;
    private double fireRate; // default projectiles per second
    private int damage;
    private double movementMultiplier;
    private MayflowerImage a;
    private Timer t;
    
    /**
     * 
     */
    public Enemy(int h, double f, int d, double m, String s)
    {
        health = h;
        fireRate = f;
        damage = d;
        movementMultiplier = m;
        
        a = new MayflowerImage(("img/villian" + s + ".png"));
        setImage(a);
        
        t = new Timer((int)getFireRate(1));
    }
    
    public int getHealth(){ return health;}
    public int getDamage() { return damage;}
    public double getFireRate(int x) { 
        if(x == 0) return fireRate; // default return fireRate in Hz
        else if(x == 1) return 1/fireRate; // return how long between shots
        
        return -1;
    }
    public double getMovement() { return movementMultiplier;}

    public void act(){
        /*try{
            Thread.sleep((int)(getFireRate(1) * 1000));
            //new Missile(getX(), getY());
            System.out.println("boom");
        } catch(InterruptedException e) {
            e.printStackTrace(System.out);
        }
        */
        if(t.isDone()){
            System.out.println("boom");
            t.reset();
        }
            //new Missile(getX(), getY());
    }
}
