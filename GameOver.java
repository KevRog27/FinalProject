import mayflower.*;

public class GameOver extends World
{
    
    public GameOver(String outcome)
    {
        if(outcome.equals("LOSE")){
            setBackground("img/gameOverLose.png");
        }else{
            setBackground("img/gameOverWin.png");
        }
    }

    public void act(){
        if(Mayflower.isKeyDown(Keyboard.KEY_ENTER)){
            Mayflower.setWorld(new TitleScreen());
        }
    }
}
