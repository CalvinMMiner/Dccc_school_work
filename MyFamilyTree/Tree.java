/**
 * This class represents a tree in which each node has an arbitrary number 
 * of children.
 * 
 * @author Cay Horstmann
 * Modifications by John Jurkiewicz
 * @version 5/27/2018
 */
import java.util.List;
import java.util.ArrayList;

public class Tree
{
    /** reference to the node at the root of the tree */
    public Node root;

    class Node
    {
        /** The node's data element */
        public Object data;
        /** List of the node's children */
        public List<Node> children;

        /**
         * This method computes the size of the subtree whose root is this node.         * 
         * @return the number of nodes in the subtree
         */
        public int size()
        {
            int sum = 0;         
            for (Node child : children)
                sum = sum + child.size();
            return 1 + sum;
        }

        /**
         * This method overrides Object's toString method 
         * @return str - string containing the tree root and its children
         */
        @Override
        public String toString()
        {
            String str = (String)data + "\n";
            for (Node child : children)
                str+=(String)child.data + " ";
            return str;
        }
    }

    /**
     * Constructs an empty tree.
     */
    public Tree()
    {
        root = null;
    }

    /**
     * Constructs a tree with one node and no children. 
     * @param rootData the data for the root
     */
    public Tree(Object rootData)
    {
        root = new Node();
        root.data = rootData;
        root.children = new ArrayList<Node>();
    }

    /**
     * This method adds a tree as a subtree child of the root.
     * @param subtree - reference to a tree to be added
     */
    public void addSubtree(Tree subtree)
    {
        root.children.add(subtree.root);
    }   

    /**
     * Computes the size of this tree.     * 
     * @return the number of nodes in the tree
     */
    public int size() 
    {
        if (root == null)
            return 0; 
        else 
            return root.size();
    }

    /**
     * This method overrides Object's toString method 
     * @return string containing the tree root and its children
     */
    @Override
    public String toString()
    {
        return root.toString();
    }
}
