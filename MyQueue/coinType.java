
/**
 * an object that extends from coin, holds four additional methods,
 * a constructor and a toString
 * 
 * the additional methods add a type and value to the coin
 */
public class coinType extends coin
{
    private int Value;
    private String Type;

    /**
     * Constructor for objects of class coinTypesets the value and type to 1 and penny
     */
    public coinType()
    {
        Value = 1;
        Type = "penny";
    }

    /**
     * a method that generates a random type and value for the cointype object 
     */
    public void generateType(){
        String[] CoinTypes={"penny","nickel","Dime","Quarter","half-dollar"};
        Type=CoinTypes[rnd.nextInt(5)];
        switch(Type){
            case "penny"       : Value=1;   break;
            case "nickel"      : Value=5;   break;
            case "Dime"        : Value=10;  break;
            case "Quarter"     : Value=25;  break;
            case "half-dollar" : Value=50;  break;
        }
    }
    
    /**
     * method that gets the type String when called
     * 
     * @return Type  retuns the type Sting 
     */
    public String getType(){
        return Type;
    }
    
    /**
     * method that gets the Value int when called
     * 
     * @return Type  retuns the Value int 
     */
    public int getValue(){
        return Value;
    }
       
    /**
     * This method overrides the toString() method from the coin parent class     
     * 
     * @return a String with coins original toString text + the type of coin and its value
     * if the value is one it just prints cent, else wise it prints its type and value
     */
    @Override
    public String toString() 
    {
        return super.toString() + " and is a "+(getValue()==1 ? "cent": 
        Type+ " worth "+Value+" cents");
    }  
}
