/*
    Get one number from the user: x (that may have decimal points).
    If x is less than 30.5 output x is under 30.5.
    If x is greater than or equal to 30.5 output x is greater than or equal to 30.5.
    Use floating point precision.
 */

import java.util.Scanner;

public class Question4 {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a number");
        float x = keyboard.nextFloat();
        float y = 30.5f;
        if (x < y) {
            System.out.println("x is under " + y);
        } else {
            System.out.println("x is greater than or equal to " + y);
        }

    }
}
