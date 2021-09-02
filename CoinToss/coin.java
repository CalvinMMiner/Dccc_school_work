import java.util.Random;
/**
 * coin object, holds two methods, the default constructor and a toString
 * 
 * the methods assigne a face to the coin and 
 * allow it to be changed via random boolean generation
 */
public class coin
{
    public Random rnd = new Random();
    private boolean face;
    /**
     * default constructor that makes a coin thats "face up"
     */
    public coin()
    {
        face = true;
    }

    /**
     * method that randomly sets the value stored in face
     */
    public void flipCoin(){
        face=rnd.nextBoolean();
    }
    
    /**
     * method that gets the value of face
     * 
     * @return face  returns face
     */
    public boolean getFace(){
        return face;
    }

    /**
     * This method creates the toString() method for the coin object 
     * @return a String with coins face
     */
    @Override
    public String toString()
    {
        return String.format("the coin landed as: "+ (getFace() ? "heads": "tails"));
    }
}
