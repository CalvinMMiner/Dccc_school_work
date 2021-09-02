import java.util.InputMismatchException;
import java.io.IOException;
import java.util.Arrays;
/**
 * a class that hold the logic for the menu, prompts the user to use 
 * the methods to modify an array
 *
 * @Calvin M Miner
 * @10/7/19
 */

public class SearchArray
{
    /**
     * main method of the searchArray creates the array and loops through the logic until 
     * the user terminates the program
     * 
     * @throws IOException - throws an exception so the pause method can be called
     * by proccesInput
     */
    public static void main() throws IOException
    {
        int[] array = {7,18,27,2,9,6,12,3,17,25,0,0,0,0,0};
        Arrays.sort(array,0,10);
        searchMethods.setHigh();
        int position=0;
        do
        {
            System.out.print("\f\nthe array is:"+ Arrays.toString(array)+
                "\nwhich value do you wish to modify? "+
                "\n(you may exit by inputing a non-number): ");
            if(searchMethods.proccesInput(array))
                break;
        }while(true);
        System.out.println("\n\nend of searchArray program");
    }
}