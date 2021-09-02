/**
 * simple class with two constructors, six methods and a tostring
 *
 * @Calvin M Miner
 * @10/31/19
 */
public class Employee
{
    private int number;
    private String name;
    private double salary;
    
    /**
     * default Constructor for objects in Employee, sets variables
     * to their default values
     */
    public Employee()
    {
        number = 0;
        name = "";
        salary = 0.0;
    }
    
    /**
     * constructor with parameters, sets variables to the given values
     * 
     * @param Number - the given value for number
     * @param Name - the given value for name
     * @param Salary the given value for salary
     */
    public Employee(int Number, String Name, double Salary)
    {
        number = Number;
        name = Name;
        salary = Salary;
    }

    /**
     * sets number to the given value
     * 
     * @param Number - the new value for number
     */
    public void setNumber(int Number)
    {
        number = Number;
    }
    
    /**
     * sets name to the given value
     * 
     * @param Name - the new value for name
     */
    public void setName(String Name)
    {
        name = Name;
    }
    
    /**
     * sets salary to the given value
     * 
     * @param Salary - the new value for salary
     */
    public void setSalary(double Salary)
    {
        salary = Salary;
    }
    
    /**
     * gets the value for
     * 
     * @return number - returns the current value of number
     */
    public int getNumber()
    {
        return number;
    }
    
    /**
     * gets the value for
     * 
     * @return name - returns the current value of name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * gets the value for
     * 
     * @return salary - returns the current value of salary
     */
    public double getSalary()
    {
        return salary;
    }
    
    /**
     * the toString, lists out the private variables with some text 
     * to provide context to the meaning of each variable
     */
    public String toString() 
    {
        return "Employee number " + number + ", " + name +
        ", has a sallary of $" + salary;
    }
}
