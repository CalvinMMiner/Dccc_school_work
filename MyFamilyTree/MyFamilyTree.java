/**
 * This program creates a family tree and then prints it and the total size of the tree
 * 
 * @Calvin M Miner
 * @version 11/14/16
 */
public class MyFamilyTree
{
    /** uses the provided tree class to create a direct line from me
     * to my great grandfather and prints each root
     * followed by the total size of the tree
     */
    public static void main()
    {
        System.out.println("\n\tDisplay My Family Tree\n");

        Tree t1 = new Tree("cliff");

        Tree t2 = new Tree("Richard");
        t1.addSubtree(t2);
        t1.addSubtree(new Tree("Gene"));
        t1.addSubtree(new Tree("Edna"));
        t1.addSubtree(new Tree("Leo"));
        t1.addSubtree(new Tree("larrane"));
        System.out.println(t1+"\n");
        
        Tree t3 = new Tree("Mike");
        t2.addSubtree(t3);
        t2.addSubtree(new Tree("Debbie"));
        t2.addSubtree(new Tree("Denise"));
        t2.addSubtree(new Tree("kim"));
        System.out.println(t2+"\n");
        
        t3.addSubtree(new Tree("Calvin"));
        t3.addSubtree(new Tree("Chris"));
        System.out.println(t3);
        
        System.out.println("\nSize: " + t1.size()); 

        System.out.println("\n\tEnd of My Family Tree\n");
    }
}
