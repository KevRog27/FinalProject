import mayflower.*;

public class LevelOne extends MyWorld
{
    private HeroJet j;
    public LevelOne()
    {
        super(0, 400, "img/levelOne.png");
    }
    
    public void act(){
        if(j.getLives() <= 0)
            Mayflower.setWorld(new GameOver("LOSE"));
            
        if(j.getScore() >= 1000 )
            Mayflower.setWorld(new LevelThree());
                
        updateText();
    }
    
        public void updateText(){
        removeText(0,30);
        showText("Level: 1 Score: " + jet.getScore() + " Lives: " + jet.getLives(), 0, 30, Color.WHITE);
    }
}