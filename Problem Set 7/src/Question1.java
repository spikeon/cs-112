import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question1 {
  private static int current;
  private static List<Integer> l = new ArrayList<Integer>();
  private static Scanner k = new Scanner(System.in);
  public static void main (String[] args){
    do {
      System.out.println("Enter an integer (0 to exit)");
      current = k.nextInt();
      if(current != 0) l.add(current);
    } while(current != 0);
    System.out.println("Got it.  You entered:");
    for(Integer i : l){
      System.out.println(i);
    }
  }
}
