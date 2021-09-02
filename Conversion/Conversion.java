import java.text.DecimalFormat;
import java.util.Scanner;
/**
 * takes  string inputs and passes it to a method that 
 * turns them into an int, these values are sumed and averaged 
 *
 * @author Calvin M Miner
 * @version 9/19/19
 */
public class Conversion
{
    private static int count=0;
    private static int convertedNumber=0;
    /**
     * main method for the conversion program, initilizes variables and creates new classes
     * uses a do loop to repeatedly call the stringToInt method until the user inputs a 
     * non-number. it will subtract from the sum if you submit a negitive number
     * once a non-number is input tthe sum and average of the input numbers is printed
     */
    public static void main()
    {
        DecimalFormat df = new DecimalFormat("#.0");
        Scanner sc = new Scanner(System.in);
        double sum=0;
        System.out.println("\f\nstart of conversion program"+
        "\n\nthis program will display the sum and average of all numbers you input\n"+ 
        "entering Q will display the sum and average  \n");
        do
        {
            boolean negitive = false;
            convertedNumber=0;
            String Number;
            try
            {
                System.out.print("\nplease enter a number: ");
                stringToInt(Number=sc.nextLine());
                if(Number.charAt(0) =='-')
                {
                    sum-=convertedNumber;
                }
                else
                {
                    sum+=convertedNumber;
                }
                count++;
            }
            catch (Exception e)
            {
                break;
            }
        }
        while(true);
        System.out.println("\nthe sum of your numbers is "+sum 
            +"\nthe average is "+df.format(sum/count)
            +"\n\nend of conversion program");
    }

    /**
     * method that uses recursion to create and int baised off of a string
     * has an if statment to skip the first char if the user inputs a negitive number
     * 
     * @param Number - string that is used to make the int
     * @return stringToInt - returns the number made from the string
     */
    public static int stringToInt(String Number)
    { 
        if(Number.length()==1)
        {
            return convertedNumber = (convertedNumber*10)
            + Integer.parseInt(Number.substring(0,1));
        }
        if(Number.charAt(0) =='-'){}
        else
        {
            convertedNumber = (convertedNumber*10)
            + Integer.parseInt(Number.substring(0,1));
        }
        return stringToInt(Number.substring(1,Number.length()));
    }
}
