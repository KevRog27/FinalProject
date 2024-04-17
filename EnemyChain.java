import java.util.*;
import mayflower.*;

/**
 * Controls Enemies in the chain-like structure as seen in Galaga (19XX)
 *
 * @author Paul Berend
 * @version (a version number or a date)
 */
public class EnemyChain
{
    List<Enemy> enemies;
    boolean active;
    
    public boolean getActive(){return active;}
    public EnemyChain(World w, float headX, float headY, int length){
        Enemy f = null;
        enemies = new ArrayList<Enemy>();
        for(int i = 0; i < length; i++){
             Enemy e = new Enemy(w, headX, headY - i*20, i);
             enemies.add(e);
             if(f != null){
                 e.setFollowTarget(f);
             }
             f = e;
        }
    }
    
    public void setActive(boolean active){
        for(Enemy e: enemies) e.setActive(active);
        this.active = active;
    }
    /**
     * Get the length of the enemy chain.
     */
    public int size(){
        return enemies.size();
    }
    /**
     * Enemies should already exist in the world;
     */
    public EnemyChain(ArrayList<Enemy> enemies){
        this.enemies = enemies;
        Enemy follow = null;
        for(Enemy e : enemies){
            e.setFollowTarget(follow);
            follow = e;
        }
    }
    
    /**
     * Creates two new enemy chains, with even enemies on one and odd on the other
     * Returns the two in an array.
     */
    public EnemyChain[] split(){
        ArrayList<Enemy> a1 = new ArrayList<Enemy>();
        ArrayList<Enemy> a2 = new ArrayList<Enemy>();
        for(int i = 0; i < enemies.size(); i++){
            if(i%2==0) a1.add(enemies.get(i));
            else a2.add(enemies.get(i));
        }
        EnemyChain a = new EnemyChain(a1);
        EnemyChain b = new EnemyChain(a2);
        a.setActive(active);
        b.setActive(active);
        return new EnemyChain[]{a, b};
    }
}
