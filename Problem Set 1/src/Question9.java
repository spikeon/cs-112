import java.util.Scanner;

/*
    Prompt the user for a number and output the factorial.
    If the number entered is less than zero, output an error message.
 */
public class Question9 {
    public static void main(String[] args){
        System.out.println("Enter a number:");
        Scanner keyboard = new Scanner(System.in);
        int x = keyboard.nextInt();
        if(x >= 0) System.out.println(x + "! = " + factorial(x));
        else System.out.println("Input must be greater than zero.");
    }

    public static int factorial(int i){
        if(i <= 1) return 1;
        else return i * factorial(i - 1);
    }
}
