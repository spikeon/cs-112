import java.util.Scanner;

public class Example1 {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter your Name");
        String user_name = keyboard.nextLine();

        System.out.println("Enter your Age");
        double user_age = keyboard.nextDouble();

        if(user_age >= 35){
            System.out.println("Congratulations, " + user_name + ", You are old enough to run for president.");
        }
        else {
            System.out.println("Sorry, " + user_name + ", You are not old enough to run for president.");
        }

    }
}
