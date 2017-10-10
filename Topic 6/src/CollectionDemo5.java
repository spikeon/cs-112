import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class CollectionDemo5 {
  public static void main(String args[]){
    Queue<City> stuff = new PriorityQueue<City>();
    stuff.add(new City("Los Angeles", 3884000));
    stuff.add(new City("Ventura", 108817));
    stuff.add(new City("Oxnard", 203007));
    stuff.add(new City("Agoura Hills", 20681));
    stuff.add(new City("Van Nuys", 136443));
    stuff.add(new City("Ventura", 110000));

    while(!stuff.isEmpty()){
      City current = stuff.poll();
      System.out.println(current);
    }

  }
}
