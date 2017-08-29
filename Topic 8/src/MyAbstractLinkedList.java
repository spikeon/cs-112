
//A linked list is a collection
//A collection is a data type that stores lots of stuff (infinite storage)
//Each element in a linked list is scattered throughout memory
public abstract class MyAbstractLinkedList<E>
{
	//This class represents a single data item in memory
	protected class Node<E> 
	{
		public E content;
		public Node<E> next = null;
		
		public Node(E content)
		{
			this.content = content;
		}
	} //end of the Node class
	
	//the beginning of the linked list
	protected Node<E> head = null;
	
	//given a subscript, the method returns the corresponding node
	protected Node<E> getNode(int subscript)
	{
		//start at the beginning
		Node<E> cursor = head;
		//loop exactly "subscript" times
		for (int counter = 1; counter <= subscript; counter++)
		{
			//move to the next node
			cursor = cursor.next;
		}
		//return the Node that we landed on
		return cursor;
	}
	
	//adds an element to the end of the list
	public abstract void add(E element);
	//returns the number of elements in the list
	public abstract int size();
	//returns the data in the Node that's associated with subscript
	public abstract E get(int subscript);
	//delete the Node that's associated with subscript
	public abstract E remove(int subscript);
}
