import java.lang.StringBuilder;
import java.util.ArrayList;
/**
 * class made to emulate a queue 
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Queue<T>
{
    private ArrayList<T> queue;
    private T t;
    /**
     * Constructor for objects of class QueueT
     */
    public Queue()
    {
        queue = new ArrayList<T>();
    }

    /**
     * returns true if the array is empty
     * 
     * @return queue.isEmpty() - returns true or false baises on the queue length
     */
    public boolean isEmpty()
    {
        return queue.isEmpty();
    }

    /**
     * gives the size of the array
     * 
     * @return queue.size() - returns the size of the array
     */
    public int size()
    {
        return queue.size();
    }

    /**
     * adds and object the the end of the queue
     * 
     * @param i - the object that will be added to the queue
     */
    public void add(T i)
    {
        this.t=i;
        queue.add(i);
    }

    /**
     * removes and returns the first item in the queue
     * 
     * @return - queue.remove(0) - removes and returns the first item in the queue
     * @return null - retun null if there is nothing in the queue
     */
    public T poll()
    {
        try
        {
            return queue.remove(0);
        }
        catch(IndexOutOfBoundsException E)
        {
            return null;
        }
    }

    /**
     *  returns the first item in the queue
     * 
     * @return - queue.get(0) - returns the first item in the queue
     * @return false - retun false if there is nothing in the queue
     */
    public T peek()
    {
        try
        {
            return queue.get(0);
        }
        catch(IndexOutOfBoundsException E)
        {
            return null;
        }
    }
    
    public String toString()
    {
        if (isEmpty()) {
            return " ";
        }
        int i=0;
        StringBuilder ToSting = new StringBuilder();
        while(i<size())
        {
            ToSting.append(" \n").append(queue.get(i));
            i++;
        }
            return "the Queue contains " +queue.size() +" objects: "
            +ToSting.toString();
    }
}
