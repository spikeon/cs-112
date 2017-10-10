import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class CollectionDemo3 {
  public static void main(String args[]){
    Map<String, Integer> stuff = new HashMap<String, Integer>();
    stuff.put("Los Angeles", 3884000);
    stuff.put("Ventura", 108817);
    stuff.put("Oxnard", 203007);
    stuff.put("Agoura Hills", 20681);
    stuff.put("Van Nuys", 136443);
    stuff.put("Ventura", 1100000);

    for(String key : stuff.keySet()){
      int value = stuff.get(key);
      System.out.println("Population of " + key + " is: "+ value);
    }
  }
}
