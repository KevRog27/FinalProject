import mayflower.*;

public class LevelThree extends MyWorld
{
    private HeroJet j;
    
    public LevelThree()
    {
        super(0, 400, "img/levelThree.png");
        j = getJet();
    }
    
    public void act(){
        if(j.getLives() <= 0)
            Mayflower.setWorld(new GameOver("LOSE"));
            
        if(j.getScore() >= 3000 )
            Mayflower.setWorld(new GameOver("WIN"));
                
        updateText();
    }
    
        public void updateText(){
        removeText(0,30);
        showText("Level: 3 Score: " + j.getScore() + " Lives: " + j.getLives(), 0, 30, Color.WHITE);
    }
}