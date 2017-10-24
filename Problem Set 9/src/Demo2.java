
public class Demo2
{
	public static void main(String[] args)
	{
		MyLinkedList<String> t = new MyLinkedList<String>();
		System.out.println("isEmpty? " + t.isEmpty());
		t.add("Santa Maria");
		t.add("Los Angeles");
		t.add("Ventura");
		t.add("Thousand Oaks");
		System.out.println("isEmpty? " + t.isEmpty());
		System.out.println("Contains Santa Maria? " + t.contains("Santa Maria"));
		System.out.println("Contains Los Angeles? " + t.contains("Los Angeles"));
		System.out.println("Contains Junk data 75? " + t.contains("Junk data 75"));
		System.out.println("Contains Ventura? " + t.contains("Ventura"));
		System.out.println("Contains Thousand Oaks? " + t.contains("Thousand Oaks"));
		System.out.println("Contains Simi Valley? " + t.contains("Simi Valley"));
		System.out.println("Contains Westlake? " + t.contains("Westlake"));

		for (int x = 0; x < 500; x++)
		{
			t.add("Junk data " + x);
		}
		System.out.println("isEmpty? " + t.isEmpty());
		System.out.println("indexOf Ventura: " + t.indexOf("Ventura"));
		System.out.println("indexOf Junk data 75: " + t.indexOf("Junk data 75"));
		System.out.println("indexOf Santa Maria: " + t.indexOf("Santa Maria"));
		System.out.println("indexOf Thousand Oaks: " + t.indexOf("Thousand Oaks"));
		System.out.println("indexOf Junk data 499: " + t.indexOf("Junk data 499"));
		System.out.println("indexOf Los Angeles: " + t.indexOf("Los Angeles"));
		System.out.println("indexOf Junk data 123: " + t.indexOf("Junk data 123"));

		System.out.println("isEmpty? " + t.isEmpty());
		System.out.println("--------");
		System.out.println("Cool!  I didn't crash!");
	}
}
