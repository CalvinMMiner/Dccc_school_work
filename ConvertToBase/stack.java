/**
 * a class that emulates the functions of a stack
 *
 * @Calvin M Miner
 * @10/24/19
 */
public class stack
{
    private int[] stack;
    private int currentSize;

    /**
     * default Constructor for stack, sets the variables to their defaults
     */
    public stack(int currentSize)
    {
        stack = new int[currentSize];
        currentSize=0;
    }

    /**
     * empties the array
     */
    public void empty()
    {
        currentSize=0;
        stack[currentSize]=0;
    }
    
    /**
     * adds a new value to the top of the stack
     */
    public void push(int value)
    {
        stack[currentSize] = value;
        currentSize++;
    }
    
    /**
     * removes a int from the top of the stack
     * 
     * @return stack[currentSize] - returns the int on the top of the stack
     */
    public int pop()
    {
        try
        {
            currentSize--;
            return stack[currentSize];
        }
        catch(Exception e)
        {
            return 0;
        }
    }
}
