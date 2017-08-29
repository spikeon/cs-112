
//this class represents a Binary Search Tree
//the BST here is a set
//the BST keeps all data sorted
//"lesser" elements are on left part of tree
//"greater" element are on right part of tree
public abstract class MyAbstractTreeSet
{	
	//a node to hold the content and points
	public class Node
	{
		public String content;
		public Node left = null;
		public Node right = null;
		
		public Node(String content)
		{
			this.content = content;
		}
	}
	
	//the beginning of the tree (no parents)
	protected Node root = null;
	//how many elements are in tree
	protected int size = 0;
	
	//adds elements recursively	
	public Node add(String content, Node cursor)
	{
		//base case: if we've fallen off the end of the tree,
		//           then we've found where this new node is going
		//           to go
		if (cursor == null)
		{
			//increment size
			size++;
			//make new node
			return new Node(content);
		}
		else //recursive case: still trying to find where this content should go
		{
			//do comparison
			int result = content.compareTo(cursor.content);
			//if content < cursor.content (compareTo returns negative number)
			if (result < 0)
			{
				cursor.left = add(content, cursor.left); //move left
			}
			else if (result > 0) //if (content > cursor.content (compareTo return positive number)
			{
				cursor.right = add(content, cursor.right); //move right
			}
			//return the modified node
			return cursor;
		}				
	}
	
	//convenience method to simplify call to add
	public void add(String element)
	{
		root = add(element, root);
	}
	
	public int size()
	{
		return size;
	}
	
	//returns true if the given content is within the tree
	public abstract boolean contains(String content);	
	//DEBUG: prints out all elements in tree
	//(printing stuff from a method isn't typical)
	public abstract void printAll();
}
