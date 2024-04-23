import mayflower.*;


public class AnimatedActor extends Actor
{
    private Animation animation;
    private Timer t;

    public AnimatedActor(){
        t = new Timer(1000000000);
    }

    public void setAnimation(Animation a){
        animation = a;
    }

    public void act(){
        

        if(animation == null){
            return;
        }

        if(t.isDone()){
            t.reset();
            MayflowerImage nextImage = new MayflowerImage(animation.getNextFrame());
            setImage(nextImage);
        }
    }


}