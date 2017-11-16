import java.util.Scanner;

public class Exploder {
  public static void main(String[] args){
    new Exploder();
  }
  public Exploder(){
    System.out.println("Enter a String");
    Scanner k = new Scanner(System.in);
    explode(k.nextLine());
  }
  public void explode(String remainder){
    if(remainder.length() == 0) return;
    System.out.println(remainder.charAt(remainder.length() - 1 ));
    explode(remainder.substring(0, remainder.length() - 1));
  }
}
