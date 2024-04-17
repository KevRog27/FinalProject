import mayflower.*;

/**
 * Bullet Class
 *
 * @author Paul Berend
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    float x;
    float y;
    float speed;
    float angle;
    float lifetime;
    public Bullet(World w, float x, float y, float angle, float speed){
        this.x = x;
        this.y = y;
        w.addObject(this, (int)x,(int)y);
        this.angle = angle;
        this.speed = speed;
        this.lifetime = 5*60;
    }
    
    public void act(){
        lifetime -= 1;
        if (lifetime <= 0) getWorld().removeObject(this);
        
        x += (float)Math.cos(Math.toRadians(angle))*speed/60;
        y += (float)Math.sin(Math.toRadians(angle))*speed/60;
        
        setLocation((int)x,(int)y);
    }
}
