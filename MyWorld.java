import mayflower.*;

public class MyWorld extends World {
    HeroJet jet;
    public MyWorld(int jetX, int jetY, String background) 
    {
        Mayflower.setFullScreen(false);
        jet = new HeroJet(0, 50, 3, 10);
        addObject(jet, jetX, jetY);

    }
    
    public HeroJet getJet(){
        return jet;
    }
    
    public void act()
    {
        //ERROR HERE - NEED TO CREATE getx AND gety OBJECTS IN NinjaAnimatedObject
        //if (Mayflower.isKeyDown(Keyboard.KEY_SHIFT)) {
        //    addObject(new NinjaStarAnimatedActor(), NinjaAnimatedActor.getx(), NinjaAnimatedActor.gety());
        //}
    }
    
    
    
    
}