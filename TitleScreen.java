import mayflower.*;

public class TitleScreen extends World
{

    public TitleScreen()
    {
       setBackground("newImg/titleScreenFinal.png");
    }

    public void act(){
        if(Mayflower.isKeyDown(Keyboard.KEY_ENTER))
            Mayflower.setWorld(new LevelOne());
        
    }
}
