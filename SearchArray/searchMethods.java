
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
/**
 * a seperat class that holds the methods the searchlogic calls
 * to modiffy the array
 */
public class searchMethods
{
    static int high;
    public static void setHigh()
    {
        high=9;
    }

    /**
     * a method that, shold the array have space, either adds a new value to the array,
     * or removes an old one
     * 
     * @param position - the position in the array that is being changed
     * @param value - the value that can be added to the array
     * @param array - the array being modified
     * @param high - the how many non zero integers are in the array 
     * @throws IOException - throws an exception so the pause method can be called
     */
    public static int addOrRemove(int position, int value, int[] array,int high) throws IOException
    {
        if (high==14 && array[high]!=0 && position<0)
        {
            System.out.println("your number can not be added because " +
                "the array is curently full");
            pause();
        }
        else if(position<0||(position<array[0] && value!=array[0]))
        {
            high++;
            array[high]=value;
        }
        else
        {
            array[position]=array[high];
            array[high]=0;
            high--;
        }
        if(high>14)
        {
            high=14;
        }
        return high;
    }

    /**
     * method that takes user input and puts it through a binarySearch, then runs the results
     * through logic and gives the user the appropriate prompts and methods
     * 
     * @param array - the array that the users input is potentaly modifying
     * @throws IOException - throws an exception so the pause method can be called
     */
    public static boolean proccesInput(int[] array) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int position=0;
        try
        {
            int input = sc.nextInt();
            if(input > 0)
            {
                if (input < array[0] && input != array[0])
                {
                    System.out.println("your input is not in the list"
                        + "\nif it were it would be the first number "
                        + "\ndo you want to add this value? (Y/N): ");
                }
                else if (input > array[high])
                {
                    System.out.println("your input is not in the list"
                        + "\nif it were it would be the last number "
                        + "\ndo you want to add this value? (Y/N): ");
                }
                else if(array[0]==0)
                {
                    System.out.println("the array is currently empty"
                        + "\ndo you want to add this value? (Y/N)");
                }
                else
                {
                    position=search(array,0,high,input);
                    if (position<0)
                    {
                        System.out.println("your input is not in the list"
                            + "\nif it were it would be at index: " + (-position)
                            + "\ndo you want to add this value? (Y/N): ");
                    }
                    else
                    {
                        System.out.println(array[position] + " is at the "+
                            (position) + " index on the list" +
                            "\ndo you want to remove this value? (Y/N): ");
                    }
                }
                if(sc.next().toUpperCase().equals("Y"))
                {
                    if(array[0]==0)
                    {
                        array[0]=input;
                        high++;
                    }
                    else
                        high = searchMethods.addOrRemove(position,input,array,high);
                }
            }
            else
            {
                System.out.println("please enter a number in the array");
                pause();
            }
            Arrays.sort(array,0,high+1);
        }
        catch(InputMismatchException e)
        {
            return true;
        }
        return false;
    }

    /**
     * Finds a value in a range of a sorted array, 
     * using the binary search algorithm.    * 
     * @param a the array in which to search
     * @param low the low index of the range
     * @param high the high index of the range
     * @param value the value to find
     * @return the index at which the value occurs, 
     *    or -high if it does not occur in the array
     */
    public static int search(int[] a, int low, int high, int value)
    {  
        if (low <= high)
        {
            int mid = (low + high) / 2;
            if (a[mid] == value) 
                return mid;
            if (a[mid] < value )
                return search(a, mid + 1, high, value);
            else
                return search(a, low, mid - 1, value);       
        }
        else 
            return -high;
    }

    /**
     * reused example function, pauses the program
     * 
     * @throws e - throws IoExection pausing the program
     */
    public static void pause() throws IOException
    {
        System.out.println("Press Enter key to continue: ");
        char c = (char) System.in.read();
    }
}
