import mayflower.*;


public class Animation 
{
    private MayflowerImage[] images;
    private int frameRate;
    private int currentFrame = 0;
    
    public Animation(String[] fileNames, int x){
       images = new MayflowerImage[fileNames.length];
       
       for(int i = 0; i < images.length; i++){
           images[i] = new MayflowerImage(fileNames[i]);
       }
       
       frameRate = x;
    }
    
    public int getFrameRate(){
        return frameRate;
    }
    
    public MayflowerImage getNextFrame(){
        return images[currentFrame++ % images.length];
    }
   
    public void resize(int x, int y){
        for(int i = 0; i < images.length; i++)
            images[i].scale(x, y);
    }
    
    public void setTransparency(int x){
        for(int i = 0; i < images.length; i++)
            images[i].setTransparency(x);
    }
    
    public void mirror(){
        for(int i = 0; i < images.length; i++)
            images[i].mirrorHorizontally();
    }
    
    public void setBounds(int x, int y, int w, int h){
        for(int i = 0; i < images.length; i++)
            images[i].crop(x, y, w, h);
    }
}