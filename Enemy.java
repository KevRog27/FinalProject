import mayflower.*;
/**
 * Write a description of class Enemy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Enemy
{
    // instance variables - replace the example below with your own
    private int health;
    private double fireRate; // default projectiles per second
    private int damage;
    private double movementMultiplier;
    private Animation a;
    
    /**
     * 
     */
    public Enemy(int h, double f, int d, double m, String s)
    {
        health = h;
        fireRate = f;
        damage = d;
        movementMultiplier = m;
        a = new Animation("img/villain" + s + ".png");
    }
    
    public int getHealth(){ return health;}
    public int getDamage() { return damage;}
    public double getFireRate(int x) { 
        if(x == 0) return fireRate; // default return fireRate in Hz
        else if(x == 1) return 1/fireRate; // return how long between shots
        
        return -1;
    }
    public double getMovement() { return movementMultiplier;}


}
