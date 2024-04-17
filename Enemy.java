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
    private boolean active;
    private boolean onScreen;
    
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
        setImage("./img/testsprite.png");
        setActive(false);
        onScreen = false;
        w.addObject(this, (int)x, (int)y);
    }
    /**
     * Gets the enemies current position.
     */
    public float getXPos() {return x;}
    public float getYPos() {return y;}
    /**
     * Returns whether a point is 'out of bounds'
     */
    private boolean isPointOOB(float x, float y){
        if (x < 0 || y < 0) return true;
        if (x > Mayflower.getWidth() || y > Mayflower.getHeight()) return true;
        return false;
    }
    /**
     * Activate Enemy for waves
     */
    public void setActive(boolean active){
        this.active = active;
        if(active) {
            setLocation(x, y);
            getImage().setTransparency(0);
        }
        else {
            setLocation(-30, -30);
            getImage().setTransparency(100);
        }
    }
    public boolean getActive() {return active;}
    
    public void act(){
        // DEBUG STATEMENT REMOVE L8R
        if(Mayflower.isKeyPressed(Keyboard.KEY_SPACE)) flipMode();
        if(!active) return;
        
        float currentSpeed = speed;
        if(currentMode == EnemyMode.FLYING){
            if (inFormation) inFormation = false;
            if(follow != null){
                // Point at next in chain
                float tx = follow.getXPos();
                float ty = follow.getYPos();
                lookAt(tx, ty);
            
                // Change Speed for consistant follow distance
                currentSpeed = speed * getDistance(tx, ty) / followDistance;
            } else {
                float a = (float)Math.cos(Math.toRadians(System.currentTimeMillis()/100*id));
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
            float offY = (Mayflower.getHeight() - gHeight*gSize) / 3;
            
            //offX += 50 * Math.sin(System.currentTimeMillis()/1000);
            
            float targetX = 30 * gX + offX;
            targetX += 50*Math.sin(System.currentTimeMillis()/1000.0);
            
            float targetY = 30 * gY + offY;
            
            if(getDistance(targetX, targetY) < 1 || inFormation){
                if (!inFormation) inFormation = true;
                currentSpeed = 0;
                x = targetX;
                y = targetY;
                lookAt(x, y + 10);
            } else {
                lookAt(targetX, targetY);
            }
        }
        
        x += Math.cos(Math.toRadians(angle))*currentSpeed/60;
        y += Math.sin(Math.toRadians(angle))*currentSpeed/60;
        
        // Simple Fencing
        if(!isPointOOB(x, y)) onScreen = true;
        if(onScreen){
            if (x < 0) x = 0;
            if (y < 0) y = 0;
            if (x > Mayflower.getWidth()      - 20) x = Mayflower.getWidth()      - 20;
            if (y > Mayflower.getHeight()*2/3 - 20) y = Mayflower.getHeight()*2/3 - 20;
        }
        
        
        
        setLocation(x, y);
        setRotation((int)angle+90);
        
        // Fire once per every 5 seconds (on average).
        if((int)(Math.random()*60*5)==0) fire();
    }
    
    /**
     * Gets the distance of the enemy to the given point.
     */
    private float getDistance(float x, float y){
        float dx = this.x - x;
        float dy = this.y - y;
        return (float)Math.sqrt(dx*dx+dy*dy);
    }
    /**
     * Changes the mode of the enemy. If its currently in flight mode, change to formation
     * and vice versa
     */
    private void flipMode(){
        if(currentMode == EnemyMode.FLYING) currentMode = EnemyMode.FORMATION;
        else currentMode = EnemyMode.FLYING;
    }
    
    /**
     * Points the enemy at the given point.
     */
    private void lookAt(float px, float py){
        float dx = px - x;
        float dy = py - y;
        angle = (float)Math.toDegrees(Math.atan(dy/dx));
        if (dx < 0) angle += 180;
    }
    /**
     * Turns the enemy toward the given point at turnSpeed, in degrees/second.
     */
    private void turnTowards(float px, float py,float turnSpeed){
        float dx = px - x;
        float dy = py - y;
        float targetAngle = (float)Math.toDegrees(Math.atan(dy/dx));
        if (dx < 0) targetAngle += 180;
        turnTowards(targetAngle, turnSpeed);
    }
    /**
     * Turns the enemy toward the given angle at turnSpeed, in degrees/second.
     */
    private void turnTowards(float a, float turnSpeed){
        float targetAngle = a;
        while(targetAngle > 360) targetAngle -= 360;
        while(targetAngle < 0  ) targetAngle += 360;

        if (targetAngle - angle > 180) angle -= turnSpeed/60;
        if (targetAngle - angle < 180) angle += turnSpeed/60;
        if(Math.abs(targetAngle - angle) < 5) angle = targetAngle;
    }
    
    /**
     * Get the enemies current facing angle.
     */
    public float getAngle(){
        return angle;
    }
    
    /**
     * Set the enemy an enemy is following.
     */
    public void setFollowTarget(Enemy e){
        follow = e;
    }
    /**
     * Spawns a bullet that targets the player.
     */
    
    private void fire(){
        new Bullet(getWorld(), x, y, 90, 250);
    }
}
