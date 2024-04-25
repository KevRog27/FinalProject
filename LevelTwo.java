import mayflower.*;

public class LevelTwo extends MyWorld
{
    private HeroJet j;
    
    public LevelTwo()
    {
        super(0, 400, "img/levelTwo.png");
        j = getJet();
    }
    
    public void act(){
        if(j.getLives() <= 0)
            Mayflower.setWorld(new GameOver("LOSE"));
            
        if(j.getScore() >= 2000 )
            Mayflower.setWorld(new LevelTwo());
                
        updateText();
    }
    
        public void updateText(){
        removeText(0,30);
        showText("Level: 2 Score: " + j.getScore() + " Lives: " + j.getLives(), 0, 30, Color.WHITE);
    }
}