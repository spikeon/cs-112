import java.util.*;

public class AlphaList {

  private Scanner k;
  String input;
  String sentinel = "exit";
  HashSet<String> set;
  ArrayList<String> list;

  public AlphaList() {
    set = new HashSet<String>();
    k = new Scanner(System.in);
    System.out.println("Enter some strings (exit to end)");
    do {
      input = k.nextLine();
      if(!input.equals(sentinel)) set.add(input);
    } while(!input.equals(sentinel));

    list = new ArrayList<>(set);

    Collections.sort(list);

    System.out.println("Here are those string in alphabetical order, without duplicates");

    int ctr = 0;
    for(String s : list){
      ctr++;
      System.out.println(ctr + ": " + s);
    }

  }

  public static void main(String[] args){
    new AlphaList();
  }
}
