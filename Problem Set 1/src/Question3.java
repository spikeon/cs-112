import java.util.Scanner;

/*
    Get two numbers from the user (which may have decimal points).
    Output the product.
    Use floating point precision.
 */

public class Question3 {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter the first number:");
        float a = keyboard.nextFloat();

        System.out.println("Enter the second number:");
        float b = keyboard.nextFloat();

        System.out.println("Product: " + (a * b));
    }
}
