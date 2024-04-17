import mayflower.*;
import java.util.*;

public class DemoScene extends World
{
    ArrayList<EnemyChain> enemyChains;
    public boolean DEBUG = true;
    
    public DemoScene(){
        enemyChains = new ArrayList<EnemyChain>();
        enemyChains.add(new EnemyChain(this, 320, 240, 50));
        enemyChains.get(0).setActive(true);
    }
    public void act(){
        if(DEBUG&&Mayflower.isKeyPressed(Keyboard.KEY_P)) {
            for(EnemyChain e : enemyChains.toArray(new EnemyChain[0])){
                EnemyChain[] newChains = e.split();
                if(newChains[0].size() > 0) enemyChains.add(newChains[0]);
                if(newChains[1].size() > 0) enemyChains.add(newChains[1]);
            }
        }
        if(DEBUG&&Mayflower.isKeyPressed(Keyboard.KEY_L)) {
            for(EnemyChain e : enemyChains) e.setActive(!e.getActive());
        }
    }
}
