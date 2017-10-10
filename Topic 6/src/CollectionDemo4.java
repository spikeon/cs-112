import java.util.*;

public class CollectionDemo4 {
  public static void main(String args[]){
    Stack<String> stuff = new Stack<String>();
    stuff.push("Los Angeles");
    stuff.push("Ventura");
    stuff.push("Oxnard");
    stuff.push("Agoura Hills");
    stuff.push("Van Nuys");
    stuff.push("Ventura");
    stuff.push("Ventura");

    while(!stuff.isEmpty()){
      System.out.println(stuff.pop());
    }

  }
}
