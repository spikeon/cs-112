import java.util.HashMap;
import java.util.Scanner;

public class phone {
  public static HashMap<Integer, String[]> pad = new HashMap<Integer, String[]>();
  public static void main(String[] args){
    pad.put(0, new String[]{"0"});
    pad.put(1, new String[]{"1"});
    pad.put(2, new String[]{"A", "B", "C"});
    pad.put(3, new String[]{"D", "E", "F"});
    pad.put(4, new String[]{"G", "H", "I"});
    pad.put(5, new String[]{"J", "K", "L"});
    pad.put(6, new String[]{"M", "N", "O"});
    pad.put(7, new String[]{"P", "Q", "R", "S"});
    pad.put(8, new String[]{"T", "U", "V"});
    pad.put(9, new String[]{"W", "X", "Y", "Z"});

    Scanner k = new Scanner(System.in);
    System.out.println("Enter a phone number (numbers only).");
    String number = k.nextLine();

    build(number, "");
  }

  public static void build(String remainder, String fin){
    if(remainder.length() != 0){
      for(String s : pad.get(Character.getNumericValue(remainder.charAt(0)))) {
        build(remainder.substring(1), fin + s);
      }
    }
    else {
      System.out.println(fin);
    }
  }



}
