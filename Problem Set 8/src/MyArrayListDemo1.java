
public class MyArrayListDemo1
{
	public static void main(String[] args)
	{
		MyArrayList<String> t = new MyArrayList<String>();
		t.add("Santa Maria");
		t.add("Los Angeles");
		t.add("Ventura");
		t.add("Thousand Oaks");

		for (int x = 0; x < t.size(); x++)
		{
			System.out.println(t.get(x));
		}

		t.add("Hollywood");

		System.out.println("--------");

		for (int x = 0; x < t.size(); x++)
		{
			System.out.println(t.get(x));
		}

		for (int x = 0; x < 500; x++)
		{
			t.add("Junk data " + x);
		}

		System.out.println(t.get(64));
		System.out.println(t.get(499));
		System.out.println(t.get(319));

		System.out.println("--------");
		System.out.println("Cool!  I didn't crash!");
	}
}
