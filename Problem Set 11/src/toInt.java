import java.util.Scanner;

public class toInt {
  public static void main(String[] args){
    Scanner k = new Scanner(System.in);
    System.out.println("Enter some text:");
    String line = k.nextLine();
    System.out.println("Here are the digits in that text:");
    System.out.println(toInt.clean(line));
  }
  public static String clean(String s){
    String ret = "";
    for (int i = 0; i < s.length(); i++){
      char c = s.charAt(i);
      if(Character.isDigit(c)) ret += c;
    }
    return ret;
  }
}
