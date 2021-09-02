import java.util.Scanner;
/**
 * takes a user input number and converts it into a diffrent base
 *
 * @Calvin M Miner
 * @10/29/19
 */
public class ConvertToBase
{
    /**
     * the main method, contains the programs core logic, which uses do loop
     * to continuously prompt the user for a number and a base, which is then
     * sent to ConvertToBase as parameters. a for loop then iterates through
     * Stack to print the results. this continues until the user enters 0
     * 
     */
    public static void main()
    {
        Scanner sc = new Scanner(System.in);
        stack Stack = new stack(20);
        int number = 0;
        int base = 0;
        int length;
        System.out.println("\fthis program takes a number and a base and " +
            "\nconverts the number into the given base."+
            "\nthe program will loop through this process until\nyou enter 0");
        do
        {
            try
            {
                System.out.print("\n\nplease enter the number you want converted: ");
                number = sc.nextInt();

                if(number==0)
                    break;

                do
                {
                    System.out.print("please enter a base between 2 and 9: ");
                    base = sc.nextInt();
                }while(2 > base || base > 9);

                length = ConvertToBase(number, base, Stack);
                System.out.print(number + " in base " + base + " is: ");
                for(int i = 0; i <length; i++)
                {
                    System.out.print(Stack.pop());
                }
            } 
            catch(Exception E)
            {
                System.out.println("please enter a whole number\n");
                Stack.empty();
                sc.nextLine();
            }
        }while(true);
        System.out.println("\n\n\tend of ConvertToBase");
    }

    /**
     * a method that converts a given number from base 10 to a diffrent base
     * 
     * @param Num - the number that will be converted
     * @param Base - the number that Num will be converted to
     * @param Stack - the Stack that will hold the results of the conversion
     * @return length - the length of the new number
     */
    public static int ConvertToBase(int Num, int Base,stack Stack)
    {
        int length=0;
        while(Num!=0)
        {
            Stack.push(Num % Base);
            Num /= Base;
            length++;
        }
        return length;
    }
}
