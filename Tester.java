
/**
 * Write a description of class Tester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tester
{
    // instance variables - replace the example below with your own
    public static void main(String[] args){
        Jet j = new Jet();
        System.out.println(j.getHealth());
        
        Fighter f = new Fighter();
        System.out.println(f.getMovement());
        
        Bomber b = new Bomber();
        System.out.println(b.getFireRate(1));
    }
}
