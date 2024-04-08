import mayflower.*;

public class DemoScene extends World
{
    public DemoScene(){
        new EnemyChain(this, 320, 240, 5);
    }
    public void act(){}
}
