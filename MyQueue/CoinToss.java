
/**
 * class that uses coinType to do create an array of seven coins and run through its 
 * methods then display the results and a sum of the heads flips
 * moddified to use the QueueT class
 *
 * @author Calvin M Miner
 * @version 10/22/19
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
        Queue<Object> Queue = new Queue<Object>();
        coinType[] coins = new coinType[5];
        int TotalValue=0;
        for (int i=0; i<5; i++)
        {
            coins[i]=new coinType();
            coins[i].flipCoin();
            coins[i].generateType();
            if(coins[i].getFace()){
                TotalValue+=coins[i].getValue(); 
            }
            Queue.add(coins[i]);
        }
        
            System.out.println(Queue);
            System.out.println(Queue.size());
            System.out.println(Queue.peek());
            System.out.println(Queue.poll());
            System.out.println(Queue.isEmpty());
            System.out.println(Queue.poll());
            System.out.println(Queue.size());
            System.out.println(Queue.poll());
            System.out.println(Queue.poll());
            System.out.println(Queue.poll());
            System.out.println(Queue.poll());
            System.out.println(Queue.peek());

    }
}
