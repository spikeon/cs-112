
public class Demo4
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
		t.set(1, "London");
		t.set(0, "San Diego");
		t.set(6, "Tokyo");
		t.add("Westlake");

		t.remove("Santa Maria");
		System.out.println("was Tokyo found? " + t.remove("Tokyo"));
		t.remove("Westlake");
		System.out.println("was Dubai found? " + t.remove("Dubai"));
		t.remove("Pismo");

		System.out.println("Remove index 5. It contained: " + t.remove(5));
		System.out.println("Remove index 0. It contained: " + t.remove(0));
		System.out.println("Remove index 2. It contained: " + t.remove(2));
		System.out.println("Here's what's left over");
		for (int x = 0; x < t.size(); x++)
		{
			System.out.println(t.get(x));
		}

		System.out.println("--------");
		System.out.println("Cool!  I didn't crash!");
	}
}
