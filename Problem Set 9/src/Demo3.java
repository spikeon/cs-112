
public class Demo3
{
	public static void main(String[] args)
	{
		MyLinkedList<String> t = new MyLinkedList<String>();

		t.add("Santa Maria");
		t.add("Los Angeles");
		t.add("Ventura");
		t.add("Thousand Oaks");

		t.add(0, "Orcutt");
		t.add(5, "Pismo");
		t.add(3, "San Luis Obispo");

		for (int x = 0; x < t.size(); x++)
		{
			System.out.println(t.get(x));
		}

		System.out.println("--------");

		t.set(1, "London");
		t.set(0, "San Diego");
		t.set(6, "Tokyo");

		for (int x = 0; x < t.size(); x++)
		{
			System.out.println(t.get(x));
		}

		for (int x = 0; x < 20; x++)
		{
			t.add("Junk data " + x);
		}

		t.add("Westlake");
		t.set(25, "TEST");
		System.out.println("indexOf TEST: " + t.indexOf("TEST"));

		System.out.println("--------");
		System.out.println("Cool!  I didn't crash!");
	}
}
