import mayflower.*;
import java.util.*;
public class HeroJet extends Actor
{
    private int score;
    private int health;
    private int lives;
    private int fireRate;

    public HeroJet()
    {
        score = 0;
        health = 20;
        lives = 3;
        fireRate = 1;
    }

    public boolean loseLife()
    {
        if(health <= 0){
            lives--;
            health = 20;
        }
        return true;
    }
    
    public void act(){
        int x = getX();
        int y = getY();
        int w = Mayflower.getWidth();
        int h = Mayflower.getHeight();
        if(Mayflower.isKeyDown(Keyboard.KEY_LEFT) && x > 0 && x < w){  
                    setLocation(x - 1, y);
        }
        if(Mayflower.isKeyDown(Keyboard.KEY_RIGHT) && x > 0 && x < w){  
                    setLocation(x + 1, y);
        }
    }
}