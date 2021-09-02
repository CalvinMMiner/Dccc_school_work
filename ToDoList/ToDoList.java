/** 
 * This program uses user input to create a task list then 
 * provides a simple menu the user can use to edit their list
 * 
 * @author Calvin M Miner
 * @version 9/19/2019
 */
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.Scanner;
public class ToDoList
{    
    /**
     * main method for this program
     * asks for the length of the array and creates a simple menu that lets the user select methods
     */
    public static void main()throws IOException
    {
        do
        {
            Scanner sc = new Scanner(System.in); 
            char choice;
            int length;
            try
            {
                System.out.println("how long do you want the list to be? ");
                String[] list= new String[sc.nextInt()];
                System.out.println("how many tasks do you wish to add now? ");
                length=sc.nextInt();
                if(length>list.length)
                {
                    throw new Exception();
                }
                else if(length==0)
                {
                    length++;
                }
                createFirstTasks(list,sc,length);
                do{
                    removeSpace(list,length);
                    System.out.print("\f");
                    printTasks(list,length);
                    choice = selectAction(sc);  
                    sc.nextLine();
                    try
                    {
                        if (choice == 'Q')
                        {
                            break;
                        }
                        switch(choice)
                        {
                            case 'A':System.out.print("\f");
                                     length=addTask(list,sc,length); 
                                     break;
                            case 'C':System.out.print("\f");
                                     printTasks(list,length);
                                     changeOrRemoveTask(list,sc,choice,length); 
                                     break;
                            case 'R':System.out.print("\f");
                                     printTasks(list,length);
                                     length=changeOrRemoveTask(list,sc,choice,length); 
                                     break;
                            default :System.out.print("please enter a letter on the list\n");
                                     pause();
                        }
                    }

                    catch(ArrayIndexOutOfBoundsException e)
                    {
                        System.out.print("please enter a number on the list\n");
                        pause();
                    }
                    catch(Exception e)
                    {
                        System.out.print("please enter a whole number\n");
                        pause();            
                    }
                }while (true);
                break;
            }
            catch(InputMismatchException e)
            {
                System.out.print("\f");
                System.out.println("please enter a whole number");
                pause();
            }
            catch(Exception e)
            {
                System.out.print("you cant add more tasks than the list can hold\n");
                pause();            
            }
            finally
            {
                sc.close();
            }
        }while(true);
        System.out.println("\nend of To do List program");
    }

    /**
     * this function prints the list array
     * 
     * @param list - the array being printed
     * @param lengh - how many tasks the method should check
     */
    private static void printTasks(String[] list,int length)
    {
        System.out.println("your to do list is: ");
        int a=0;
        for(int i=0;i<length;i++)
        {
            if (list[i].isEmpty())
            {
                break;
            }  
            else
            {
                System.out.println("\t"+(a+1)+")"+list[i]);
                a++;
            }
        }
    }

    /**
     * this functionis a select action method from example code
     * returns a character to the menu method
     * 
     * @param  sc - reads user input 
     * @return in.next() - returns char to menu method
     */
    private static char selectAction(Scanner in)
    {
        String menu = "\nSelect Activity below:\n" +
            "\t[A]dd a Task\n" +
            "\t[C]hange a Task\n" +
            "\t[R]emove a Task\n" +
            "\t[Q]uit\n" +
            "Enter the letter in the \"[ ]\": ";
        System.out.print(menu);
        return in.next().toUpperCase().charAt(0);
    }

    /**
     * a method that populates the inital task list
     * 
     * @param list - the list that the tasks are being added to
     * @param sc - the scanner that reads user input
     * @param length - int that tells the method how many items it needs to add
     */
    public static void createFirstTasks(String[] list,Scanner sc,int length)
    {        
        String Temp;
        sc.nextLine();
        int TempLength=0;
        for(int i=0;i<length;i++)
        {            
            System.out.println("what task do you want to add?\n"+"(you can quit eairly with Q)");
            Temp=sc.nextLine();
            if (Temp.toUpperCase().equals("Q"))
            {
                break;
            }            
            else
            {
                list[i]=Temp;
                TempLength++;
            }        
        }
        length=TempLength;
    }

    /**
     *  this function adds a task to the list
     *  
     *  @param list - the array that is having an element added
     *  @param  sc - reads user input into the list array
     *  @param length - gives the method the length of the current list
     *  @return length - returns the changes made to length
     */
    private static int addTask(String[] list,Scanner sc,int length) throws IOException
    {
        printTasks(list,length);
        if (list[length-1].isEmpty()||length!=list.length)
        {
            length+=1;
            System.out.print("what task do you want to add? ");
            list[length-1]=sc.nextLine();
        }
        else
        {
            System.out.print("the task list is currently full\n");
            pause();
        }
        return length;
    }

    /**
     * this function removes or changes an element in the list array
     * 
     * @param list - the array that is having an element removed
     * @param  sc - reads user input into the Task int
     * @param choice - tells the if statment wether to user want to change or remove an item in the list
     * @return length - returns the changes made to length
     * @throws IOException - throws IoExection so the pause method can be executed
     */
    private static int changeOrRemoveTask(String[] list,Scanner sc,char choice,int length) throws IOException
    {
        int Task;
        System.out.print("which task do you want to "+(choice=='R'?"remove?" : "change")+"(enter a # )");
        Task=sc.nextInt();
        sc.nextLine();
        if(Task>length)
        {
            System.out.println("please enter a number on your list");
            pause();
        }
        else if(choice=='R')
        {
            list[Task-1]="";
            length--;
        }
        else
        {
            System.out.print("what is the new task? ");
            list[Task-1]=sc.nextLine();
        }
        return length;
    }

    /**
     * a function that moves empty elements to the end of the list array
     * 
     * @param list - the array being moddified
     * @param length - the values that should be checked
     */
    private static void removeSpace(String[] list,int length)
    {
        String[] temp = list;
        int a=1,b=0,c=0;
        for(int i=0;i<length;i++)
        {
            if (temp[i].isEmpty())
            {
                c++;
            }
            else
            {
                list[b]=temp[i];
                b++;
            }
        }
        while(c!=0)
        {
            list[length-a]="";
            length--;
            a++;
            c--;
        }
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

