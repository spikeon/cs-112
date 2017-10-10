import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CollectionDemo2 {
  public static void main(String args[]){
    Set<String> stuff = new TreeSet<String>();
    stuff.add("Los Angeles");
    stuff.add("Ventura");
    stuff.add("Oxnard");
    stuff.add("Agoura Hills");
    stuff.add("Van Nuys");
    stuff.add("Ventura");
    stuff.add("Ventura");

    for(String thing : stuff){
      System.out.println(thing);
    }
  }
}
