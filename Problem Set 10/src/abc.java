import java.util.Scanner;

public class abc {
  public static String[] ss = {"A","B","C"};
  public static void main(String[] args){
    Scanner k = new Scanner(System.in);
    System.out.println("Enter the maximum number of characters");
    int max = k.nextInt();

    build(max);
  }

  public static void build(int length){
    build(length, "");
  }

  public static void build(int length, String cur){
    if(length != 0){
      for(String s : ss){
        build(length-1, cur + s);
      }
    }
    else {
      System.out.println(cur);
    }
  }



}
