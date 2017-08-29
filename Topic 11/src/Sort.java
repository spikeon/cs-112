public class Sort 
{
	public static void selectionSort(String[] haystack)
	{
		for (int change = 0; change < haystack.length; change++)
		{
			int least_subscript = change;
			for (int subscript = change + 1; subscript < haystack.length; subscript++)
			{
				int compare = haystack[subscript].compareTo(haystack[least_subscript]);
				if (compare < 0)
				{
					least_subscript = subscript;
				}
			}
			String temp = haystack[change];
			haystack[change] = haystack[least_subscript];
			haystack[least_subscript] = temp;
		}
	}
	
	public static void bubbleSort(String[] haystack)
	{
		boolean swapped;
		
		do
		{
			swapped = false;
			for (int subscript = 0; subscript < haystack.length - 1; subscript++)
			{			
				int compare = haystack[subscript + 1].compareTo(haystack[subscript]);
				if (compare < 0)
				{
					String temp = haystack[subscript];
					haystack[subscript] = haystack[subscript + 1];
					haystack[subscript + 1] = temp;
					swapped = true;
				}
			}
		} while (swapped);
	}
	
	public static void main(String[] args) 
	{
		String[] haystack = {"China", "Japan", "Korea", "Norway", "England", "Germany"};
		
		//bubbleSort(haystack);
		//selectionSort(haystack);						
		
		for (String current : haystack)
		{
			System.out.println(current);
		}
	}
}