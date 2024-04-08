import mayflower.*;

public class Enemy extends Actor
{
    private float x;
    private float y;
    private float speed;
    private float angle;
    
    Enemy follow = null;
    
    public Enemy(World w){
        x = 0;
        y = 0;
        speed = 50;
        angle = 90;
        w.addObject(this, (int)x, (int)y);
    }
    
    public Enemy(World w, float x, float y){
        this.x = x;
        this.y = y;
        speed = 50;
        angle = 90;
        w.addObject(this, (int)x, (int)y);
    }
    
    public void act(){
        if(follow != null){
            
            
        } else {
            angle += 180/60;
        }
        while(angle > 360) angle -= 360;
        while(angle < 0  ) angle += 360;

        x += Math.cos(Math.toRadians(angle))*speed/60;
        y += Math.sin(Math.toRadians(angle))*speed/60;
        
        setLocation(x, y);
        setRotation((int)angle);
    }
    
    public float getAngle(){
        return angle;
    }
    
    public void setFollowTarget(Enemy e){
        follow = e;
    }
}
