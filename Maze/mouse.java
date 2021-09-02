import java.util.EmptyStackException;
import java.util.ArrayList;
import java.util.Stack;
/**
 * Write a description of class mouse here.
 *
 * @version 11/19/19
 */
public class mouse
{
    private static int currentX ;
    private static int currentY;
    private static int OutOfBounds;

    /**
     * default Constructor for the mouse object
     */
    public mouse()
    {
        currentX = 0;
        currentY = 0;
        OutOfBounds = 0;
    }

    /**
     * Constructor for the mouse object that sets current x&y to user input values
     * 
     * @param startX - the start value for currentX
     * @param startY - the start value for currentY
     */
    public mouse(int startX, int startY)
    {
        currentX = startX;
        currentY = startY;
        OutOfBounds = 0;
    }

    /**
     * method that loops through a set of logic desined to move the "mouse" forwards through the maze until the mouse either finds the end, or 
     * returns to the entrance. once the mouse reaches the end a second loop is used to remove unnecessary modifications made to the maze 
     * during traversal
     * 
     * @param maze - the maze the "mouse" is in
     * @param steps - Stack that holds the steps teken by the mouse
     * 
     * @return false - returns false if the mouse returned to the entance
     * @return true - returns true if the mouse found the exit
     */
    public static boolean traverseMaze(Maze maze,Stack<Integer> steps)
    {
        Stack<Integer> intersectionCoordinates = new Stack<Integer>();
        ArrayList<String> directions = new ArrayList<String>(); 
        int StartX = currentX;
        int StartY = currentY;
        do
        {
            directions = CheckDirections(maze);
            maze.setMazeTile(currentY,currentX,5);
            
            if(OutOfBounds==2)
            {
                steps.push(currentX);
                steps.push(currentY);
                break;
            }
            if(directions.size()==0)
            {
                backTrack(intersectionCoordinates,steps,maze,StartX,StartY);
            }
            else
            {
                steps.push(currentX);
                steps.push(currentY);
                if(directions.size()>1)
                {
                    intersectionCoordinates.push(currentX);
                    intersectionCoordinates.push(currentY);
                }
                switch(directions.remove(0))
                {
                    case "U": currentY = currentY-1;
                    break;
                    case "D": currentY = currentY+1;
                    break;
                    case "L": currentX = currentX-1;
                    break;
                    case "R": currentX = currentX+1;
                    break;
                }
            }
        }while(OutOfBounds<2);
        //cleanup logic, returns false if the mouse returned to the entrance, elsewise it removes modifications made to the maze during traversal 
        if(currentY==StartY&&currentX==StartX)
        {
            return false;
        }
        else
        {
            while(!steps.empty())
            {
                maze.setMazeTile(steps.pop(),steps.pop(),9);
            }
            for(int a = 0; a < maze.getMazeDimensions(); a++)
            {
                for(int b = 0; b < maze.getMazeDimensions(); b++)
                {
                    if(maze.getMazeTile(a,b) == 5)
                        maze.setMazeTile(a,b,0);
                }
            }
            return true;
        }
    }

    /**
     * calls checkDirection to check the tiles surrounding the mouse, returns a string containing the valid directions found
     * 
     * @param Maze - the array that holds the positions being checked
     * 
     * @return Directions - returns the valid paths found by the method
     */
    public static ArrayList<String> CheckDirections(Maze Maze)
    {
        ArrayList<String> directions = new ArrayList<String>(); 
        int checkDirections = 0;

        switch(checkDirections)
        {
            case 0: String A = checkDirection(currentY-1,currentX,Maze);
            if( A !=null)
                directions.add("U");
            checkDirections++;
            case 1: A = checkDirection(currentY+1,currentX,Maze);
            if( A !=null)
                directions.add("D");
            checkDirections++;
            case 2: A = checkDirection(currentY,currentX+1,Maze);
            if( A !=null)
                directions.add("R");
            checkDirections++;
            case 3: A = checkDirection(currentY,currentX-1,Maze);
            if( A !=null)
                directions.add("L");
            checkDirections++;
        }
        return directions;
    }

    /**
     * checks the given position for 0, successful returns S, and null if not, if the x or y go out of 
     * bounds it incriments OutOfBounds by 1
     * 
     * @param x - the x cordinate of the position being checked
     * @param Y _ the y cordinate of the position being checked
     * @param Maze - the maze that containes the position
     * 
     * @return "S" - returns S if the position is 0
     * @return "null" - returns null if the position is not 0
     */
    public static String checkDirection(int y, int x,Maze maze)
    {
        try
        {
            if(maze.getMazeTile(y,x)==0)
                return "S";
        }
        catch(IndexOutOfBoundsException e )
        {
            OutOfBounds++;
        }
        return null;
    }

    /**
     * method that iterates through steps to return the mouse to the last intersection, returns any 
     * marked positions to 0 by calling the setMazeTile method, excluding the position adjacent to the intersection
     * 
     * @param intersectionCoordinates - the location of the last valid intersection for the method to 
     * return to
     * @param steps - the X and Y locations of the steps the mouse took to get where it is, replayed in
     * reverse to return to the intersection
     * @param Maze - the array that holds the maze being changed
     */
    public static void backTrack(Stack<Integer> intersectionCoordinates,Stack<Integer> steps,Maze maze,int StartX, int StartY)
    {
        try
        {
            int targetY = intersectionCoordinates.pop();
            int targetX = intersectionCoordinates.pop();
            do
            {
                int pastY = steps.pop();
                int pastX = steps.pop();

                if(targetY==pastY && targetX==pastX)
                {
                    currentX = targetX;
                    currentY = targetY;
                    break;
                }
                else
                {
                    Maze.setMazeTile(currentY, currentX, 0);
                    currentX = pastX;
                    currentY = pastY;
                }
            }while(true);
        }
        catch(EmptyStackException e)
        {
            currentX = StartX;
            currentY = StartY;
            OutOfBounds++;
        }
    }
}
