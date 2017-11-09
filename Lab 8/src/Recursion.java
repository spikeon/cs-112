import java.util.Scanner;

public class Recursion {

  private int number;

  public Recursion(int current) {
    this.number = current;
    doStuff();
  }

  private void doStuff(){
    if(number > 0) {
      if (number % 2 == 0) System.out.println("-" + number);
      else System.out.println(number);
      number--;
      doStuff();
    }
  }

  public static void main(String[] args){
    System.out.println("Enter a number");
    Scanner k = new Scanner(System.in);
    new Recursion(k.nextInt());
  }
}
