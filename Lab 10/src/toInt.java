import java.util.Scanner;

public class toInt {
  public static void main(String[] args){
    Scanner k = new Scanner(System.in);
    System.out.println("Enter some text:");
    String line = k.nextLine();
    System.out.println("Here are the digits in that text:");
    for (int i = 0; i < line.length(); i++){
      char c = line.charAt(i);
      if(Character.isDigit(c)) System.out.print(c);
    }
    System.out.println("");
  }
}
