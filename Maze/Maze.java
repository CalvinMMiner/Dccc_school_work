import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
/**
 * creates and stores a maze within a two dimensional array, contains five methods that allow for the
 * editing and veiwing of the maze data
 *
 * @11/12/19
 */
public class Maze
{
    private static Scanner in;
    private static int[][] Maze;
    private static int mazeDimensions;
    /**
     * Default constructor for objects in class maze
     */
    public Maze() throws FileNotFoundException
    {
       in  = new Scanner(new File("mazetest"));
       mazeDimensions = in.nextInt();
       Maze = new int[mazeDimensions][in.nextInt()];
    }

    /**
     * constructor for objects in class maze that accepts outside paramiters
     * 
     * @param Maze - a user provided text file containing the maze and its Dimensions 
     */
    public Maze(String maze) throws FileNotFoundException
    {
       in  = new Scanner(new File(maze));
       mazeDimensions = in.nextInt();
       Maze = new int[mazeDimensions][in.nextInt()];
    }
    
    /**
     * method that creates the maze by using the provided file and maze dimentions
     */
    public void createBaseMaze()
    {
        for(int a = 0; a < mazeDimensions; a++)
        {
            for(int b = 0; b < mazeDimensions; b++)
            {
                Maze[a][b] = in.nextInt();
            }
        }
    }
    
    /**
     * returns the entire maze when called 
     * 
     * @return maze - the maze being stored by this object
     */
    public int[][] getMaze()
    {
        return Maze;
    }
    
    /**
     * returns a single tile from the maze when called 
     * 
     * @param y - the y index of the requested tile
     * @param x - the x index of the requested tile
     * @return maze[y][x] - single tile from the maze being requested
     */
    public static int getMazeTile(int y, int x)
    {
        return Maze[y][x];
    }
    
    /**
     * changes a single specified tile from the maze when called 
     * 
     * @param y - the y index of the requested tile
     * @param x - the x index of the requested tile
     * @param x - the new value for the requested tile
     */
    public static void setMazeTile(int y, int x,int a)
    {
         Maze[y][x] = a;
    }

    /**
     * returns the Dimensions of the maze when called 
     * 
     * @return mazeDimensions - the Dimensions of the maze being stored by this object
     */
    public int getMazeDimensions()
    {
        return mazeDimensions;
    }
}
