import mayflower.*;

public class Enemy extends Actor
{
    private float x;
    private float y;
    private float speed;
    private float angle;
    private float followDistance;
    private int id;
    private EnemyMode currentMode;
    private boolean inFormation;
    
    Enemy follow = null;
    
    public Enemy(World w){
        this(w, 0, 0, 0);
    }
    
    public Enemy(World w, float x, float y, int id){
        this.x = x;
        this.y = y;
        this.id = id;
        speed = 100;
        angle = 90;
        followDistance = 30;
        currentMode = EnemyMode.FLYING;
        inFormation = false;
        w.addObject(this, (int)x, (int)y);
    }
    
    public float getXPos() {return x;}
    public float getYPos() {return y;}
    
    public void act(){
        if(Mayflower.isKeyPressed(Keyboard.KEY_SPACE)) flipMode();
        
        float currentSpeed = speed;
        if(currentMode == EnemyMode.FLYING){
            if(follow != null){
                // Point at next in chain
                float tx = follow.getXPos();
                float ty = follow.getYPos();
                lookAt(tx, ty);
            
                // Change Speed for consistant follow distance
                currentSpeed = speed * getDistance(tx, ty) / followDistance;
            } else {
                float a = (float)Math.cos(Math.toRadians(System.currentTimeMillis()/100));
                angle += 90*a/60;
            }
            while(angle > 360) angle -= 360;
            while(angle < 0  ) angle += 360;
        
            
        } else if (currentMode == EnemyMode.FORMATION){
            int gSize = 30;
            int gWidth = 10;
            int gHeight = 5;
            
            int gY = id % gHeight;
            int gX = (int)(id/gHeight);
            
            float offX = (Mayflower.getWidth() - gWidth*gSize) / 2;
            float offY = (Mayflower.getHeight() - gHeight*gSize) / 2;
            
            offX += 50 * Math.sin(System.currentTimeMillis()/1000);
            
            float targetX = 30*gX + offX;
            float targetY = 30*gY + offY;
            lookAt(targetX, targetY);
            
            if(getDistance(targetX, targetY) < 1){
                currentSpeed = 0;
                x = targetX;
                y = targetY;
                angle = 90;
            }
        }
        
        x += Math.cos(Math.toRadians(angle))*currentSpeed/60;
        y += Math.sin(Math.toRadians(angle))*currentSpeed/60;
        
        setLocation(x, y);
        setRotation((int)angle);
    }
    
    private float getDistance(float x, float y){
        float dx = this.x - x;
        float dy = this.y - y;
        return (float)Math.sqrt(dx*dx+dy*dy);
    }
    
    private void flipMode(){
        if(currentMode == EnemyMode.FLYING) currentMode = EnemyMode.FORMATION;
        else currentMode = EnemyMode.FLYING;
    }
    
    private void lookAt(float px, float py){
        float dx = px - x;
        float dy = py - y;
        angle = (float)Math.toDegrees(Math.atan(dy/dx));
        if (dx < 0) angle += 180;
    }
    
    public float getAngle(){
        return angle;
    }
    
    public void setFollowTarget(Enemy e){
        follow = e;
    }
}
