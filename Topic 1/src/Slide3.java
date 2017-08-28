import java.util.Scanner;

public class Slide3 {
    public static void main(String[] args){
        System.out.println("Welcome to Java!");

        double user_input1, user_input2, result;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter two numbers");
        user_input1 = keyboard.nextDouble();
        user_input2 = keyboard.nextDouble();

        result = user_input1 + user_input2;

        System.out.println("Sum: " + result);
    }
}
