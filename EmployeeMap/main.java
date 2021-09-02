/**
 * main method that creates a map of five Employee objects and uses two methods
 * and a keySet to display the data
 *
 * @Calvin M Miner
 * @11/5/19
 */
import java.util.HashMap;
import java.util.Set;
import java.util.Map;
public class main
{
    /**
     * main method, creates the map, fills the map with Unique employee objects
     * runs the keySet, runs a successful and un-successful data retrieval,and 
     * then displays the to string of employees earning over 60,000
     */
    public static void main()
    {
        System.out.println("\f\n\tBegin EmployeeMap\n"); 

        Map<Integer, Employee> EmployeeMap = new HashMap<Integer, Employee>();
        double[] salary = {60789.29, 75156.26, 55894.36, 40259.97,49587.26};
        String[] names = {"Joe", "Calvin", "Mike", "Lex", "Reb"};
        int[] numbers = {16, 79, 50, 12, 26};

        for(int i =0;i<5;i++)
        {
            Employee e = new Employee(numbers[i], names[i],salary[i]);
            EmployeeMap.put(e.getNumber(), e);
        }

        Set<Integer> keySet = EmployeeMap.keySet();
        System.out.println("EmployeeMap currently contains: ");
        for (Integer key : keySet)
        {
            Employee e = EmployeeMap.get(key);
            System.out.println(e);
        }
        
        int SearchNumber[] = {50, 3};
        System.out.println("\nSearching for Employee numbers 50 and 3: ");
        for(int i =0;i<2;i++) 
        {
            Employee e = EmployeeMap.get(SearchNumber[i]);
            if (e == null)
                System.out.println("Employee Number " + SearchNumber[i] + " not found");
            else
                System.out.println(e);
        }

        System.out.println("\nThe Employees who make over 60000 a year are: ");
        for (Integer key : keySet)
        {
            Employee e = EmployeeMap.get(key);
            if(e.getSalary()>60000) 
                System.out.println(e);
        }
        System.out.println("\n\tend EmployeeMap\n"); 
    }

}
