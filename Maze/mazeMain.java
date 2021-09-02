import java.util.InputMismatchException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
import java.io.File;
/**
 * creates a maze from a txt file, then uses a simulated mouse to travers the 
 * maze. the final successful route is printed to the console
 *
 * @Calvin M Miner
 * @11/12/19
 */
public class mazeMain
{
    /**
     * uses a scanner to read in the dimentions  of a text based square maze and calls a 
     * method to  store its contents in a two dimensional array then print the results. a
     * user is then asked to choose the entrance of the maze, after which the "mouse" goes
     * through the maze. the final path to the exit is then printed
     */
    public static void main() 
    {
        Scanner sc = new Scanner(System.in);
        do
        {
            System.out.println("\n\twhat maze do you want to load? (enter N to exit)");
            String MazeTxt = sc.next();
            if(!MazeTxt.equalsIgnoreCase("N"))
                try
                {
                    Stack<Integer> steps = new Stack<Integer>(); 
                    Maze maze = new Maze(MazeTxt);
                    maze.createBaseMaze();
                    printBaseMaze(maze);

                    steps = entrance(maze,sc);

                    mouse Mouse = new mouse(steps.pop(),steps.pop());
                    if(Mouse.traverseMaze(maze,steps))
                        printBaseMaze(maze);
                    else
                        System.out.println("the maze has no exit");
                }
                catch(FileNotFoundException E)
                {
                    System.out.println("\fplease enter a valid File Name\n\n");
                }
            else
                break;
            sc.nextLine();
        }while(true);
        System.out.println("\t\tend of Maze Program");
    }

    /**
     * method that creates and prints the maze with boarder numbers for the user, anditonal 
     * prints give the maze dimensions and ask the user for the starting position of the mouse
     * update: modified the x/y markers to properly display double didgets
     * @param maze - the object that contains the maze and its methods, allows this method to get the Dimensions of the
     * maze and print the contents of maze
     */
    public static void printBaseMaze(Maze maze) 
    {
        System.out.println("\f\tthe mazes dimensions are: "+ maze.getMazeDimensions()
            + " X " + maze.getMazeDimensions());
        System.out.print("  X");
        int c = -1;
        for(int a = 0; a < maze.getMazeDimensions(); a++)
        {
            if(a%10==0) 
                c++;
            System.out.print(" "+(a<=9 ?a:c));
        }
        c=0;
        System.out.print("\n Y ");
        for(int a = 0; a < maze.getMazeDimensions(); a++)
        {
            System.out.print(a<=9 ?"__":"_"+c);
            if(c!=9)
                c++;
            else
                c=0;
        }
        for(int a = 0; a < maze.getMazeDimensions(); a++)
        {
            System.out.print("\n" + (a<10 ? "0":"")+ (a) + " |");
            for(int b = 0; b < maze.getMazeDimensions(); b++)
            {
                if(maze.getMazeTile(a,b)==9)
                    System.out.print("  ");
                else
                    System.out.print(maze.getMazeTile(a,b) + " ");
            }
        }
    }

    /**
     * a method that allows the user to choose the start of the maze from an open space on an edge
     * will loop throughthe selection procces if the user inputs an invalid entrance
     * 
     * @param Maze - the object that hold the maze and its methods, what the method usees to check for entrances 
     * 
     * @return steps - returns the location of the exit chosen by the user
     */
    public static Stack entrance(Maze maze,Scanner sc)
    {
        Stack<Integer> steps = new Stack<Integer>();
        int xPos = 0;
        int yPos = 0;
        System.out.println("\nplease choose where the mouse will start at, the entrance must be on an edge");
        do
        {
            System.out.print("what is the X of the enrance? ");
            try
            {
                xPos = sc.nextInt();
                System.out.print("what is the Y of the enrance? ");
                yPos = sc.nextInt();

                if(maze.getMazeTile(yPos,xPos)==0 && ((yPos==0||yPos==maze.getMazeDimensions()-1)||(xPos==0
                ||xPos==maze.getMazeDimensions()-1)))
                {
                    steps.push(yPos);
                    steps.push(xPos);
                    return steps;
                }
                System.out.println("\nthat is not a valid entrance");
            }
            catch(InputMismatchException e)
            {
                System.out.println("please enter a number");
                sc.nextLine();
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                System.out.println("please enter a number on the maze");
                sc.nextLine();
            }

        }while(true);
    }

}
