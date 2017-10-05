import java.util.Scanner;
import java.util.Vector;

public class sol
{
	public static void main(String[] args)
	{
		/* Read from keyboard */
		Scanner keys = new Scanner(System.in);
		/* Create dynamic list */
		Vector<MenuItem> list = new Vector<MenuItem>();
		/* While there is input waiting */
		while (keys.hasNext())
		{
			/* Prompt the user */
			System.out.println("Enter product name and price");
			/* Test the constructor */
			list.add(new MenuItem(keys.next(), keys.nextDouble()));
		}
		/* Test toString (implicitly called when passed to println) */
		System.out.println("Testing toString");
		for (MenuItem mi : list)		
			System.out.println(mi);
		/* Test getters */
		System.out.println("Testing getters");
		for (MenuItem mi : list)		
			System.out.println("Item: " + mi.getName() + " Price: " + mi.getPrice());	
		/* Close keyboard stream */
		keys.close();
	}

}
