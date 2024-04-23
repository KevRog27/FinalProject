import mayflower.*;

/**
 * Write a description of class Explosion here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Explosion extends AnimatedActor
{
    private Animation boom;
    
    
    
    public Explosion()
    {
        String[] pics = new String[6];
        
        for(int i = 1; i <= pics.length; i++){
            pics[i - 1] = "img/E" + i + ".png";
        }
        
        boom = new Animation(pics, 500);
        boom.resize(25, 25);
        
        setAnimation(boom);
    }

    public void act(){
        super.act();
    }
    
}
