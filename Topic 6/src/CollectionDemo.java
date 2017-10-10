import java.util.ArrayList;
import java.util.List;

public class CollectionDemo {
  public static void main(String args[]){
    List<String> stuff = new ArrayList<String>();
    stuff.add("Los Angeles");
    stuff.add("Ventura");
    stuff.add("Oxnard");
    stuff.add("Agoura Hills");
    stuff.add("Van Nuys");
    stuff.add("Ventura");
    for(String thing : stuff){
      System.out.println(thing);
    }
  }
}
