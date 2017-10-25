import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Question2 {
  private static Set<String> s = new TreeSet<String>();
  private static Scanner k = new Scanner(System.in);
  public static void main(String[] args){
    System.out.println("Enter 10 words");
    for(int i = 1; i <= 10; i++){
      System.out.println("Enter word " + i);
      s.add(k.nextLine());
    }
    System.out.println("Here is that data without duplicates:");
    for(String i : s){
      System.out.println(i);
    }
  }
}
