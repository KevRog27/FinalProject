import mayflower.*;

/**
 * Runner class
 *
 * @author Paul Berend
 * @version (a version number or a date)
 */
public class Main extends Mayflower
{
    
    public Main(){
        super("Galagar", 640, 480);
    }
    
    public void init(){
        Mayflower.setFullScreen(false);
        World w = new DemoScene();

        Mayflower.setWorld(w);
    }
    
}
