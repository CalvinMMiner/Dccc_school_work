import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
/**
 * a  object that creates an register and the associated methods 
 */
public class Register
{
    private Queue<Integer> CheckOutTimes = new LinkedList<Integer>();
    private Random rnd = new Random();
    private int currentCheckOutTime;
    private int CustomersInLine;
    
    /**
     * sets the registers variables to their default values
     */
    public Register()
    {
        currentCheckOutTime=0;
        CheckOutTimes.add(0);
        CustomersInLine=0;  
    }
          
    /**
     * adds a new customer to the line and sets their uniqe checkout time,
     * which is then added to the line of current checkout times 
     */
    public void newCustomer(int checkoutTime)
    {
       CustomersInLine+=1; 
       CheckOutTimes.add(checkoutTime);
    }

    /**
     * method that procceses the "customers" removes 1 from the start of 
     * CheckOutTimes until it hit zero, then removes 1 from from CustomersInLine,
     * removes the firt value in CheckOutTimes, and adds one to the
     * CustomersCheckedOut variable
     */
    public void checkOutCustomers()
    {
        if (currentCheckOutTime==0 && CustomersInLine>0)
        {
            currentCheckOutTime = CheckOutTimes.poll();
            CustomersInLine--;
        }
        else if (CustomersInLine>0)
        {
            currentCheckOutTime--;
        }
    }

    /**
     * returns how many customers are in line at the register
     * 
     * @return CustomersInLine - returns the number of customers in line
     */
    public int getCustomersInLine()
    {
       return CustomersInLine; 
    }
}
