@SuppressWarnings("unchecked")
//An array list is a collection
//A collection is a data type that stores lots of stuff (infinite storage)
//Elements in an array list are stored side-by-side (contiguous memory)
public abstract class MyAbstractArrayList<E>
{		
	//the array that will store all the data
	protected E[] data_store = (E[])new Object[3];
	
	//makes it so "data_store" is effectively larger
	//this method is slow
	protected void makeArrayBigger()
	{
		//make a new, larger array
		E[] bigger_data_store = (E[])new Object[data_store.length + 3];
		//copy over all old data
		for(int subscript = 0; subscript < data_store.length; subscript++)
		{
			bigger_data_store[subscript] = data_store[subscript];
		}
		//release old data_store, save new one
		data_store = bigger_data_store;
	}
		
	//adds an element to the end of the list
	public abstract void add(E element);
	//returns the number of elements in the list
	public abstract int size();
	//returns the data that's associated with subscript
	public abstract E get(int subscript);
	//delete the data that's associated with subscript
	public abstract E remove(int subscript);
}