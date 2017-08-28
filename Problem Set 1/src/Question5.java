import java.util.Scanner;

/*
    Get three numbers from the user: left, right, and x.
    If left <= x <= right output x is within the range [left, right].
    Otherwise, output x is outside the range [left, right].
    Use floating point precision.
 */

public class Question5 {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter three numbers: left right x");
        float left, right, x;
        left = keyboard.nextFloat();
        right = keyboard.nextFloat();
        x = keyboard.nextFloat();
        String status = "outside";
        if(x >= left && x <= right) status = "within";
        System.out.println( x + " is "+status+" the range ["+left+", "+right+"]");

    }
}
