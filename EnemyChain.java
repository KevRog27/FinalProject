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
    
    public EnemyChain(World w, float headX, float headY, int length){
        Enemy f = null;
        for(int i = 0; i < length; i++){
             Enemy e = new Enemy(w, headX, headY - i*20);
             if(f != null){
                 e.setFollowTarget(f);
             }
             f = e;
        }
    }
}
