
/**
 * class that uses coinType to do create an array of seven coins and run through its 
 * methods then display the results and a sum of the heads flips
 *
 * @author Calvin M Miner
 * @version 9/18/19
 */
public class CoinToss
{
    /**
     * a main method that uses a for loop to demonstrate the 
     * methods in the coin and coin Type objects then
     * prints out the total value of all head side up flips
     * 
     */
    public static void Main()
    {
           System.out.println("\n\tstart of coin toss Demenstration\n");
           coinType[] coins = new coinType[7];
           int TotalValue=0;
           for (int i=0; i<7; i++) {
               coins[i]=new coinType();
               coins[i].flipCoin();
               coins[i].generateType();
               if(coins[i].getFace()){
                   TotalValue+=coins[i].getValue(); 
               }
               System.out.println(coins[i]);
           }
           System.out.println("\nthe total value of your head side up flips is "+TotalValue+
           " cents"+"\n\n\t end of Coin toss Demenstration"); 
    }
}
