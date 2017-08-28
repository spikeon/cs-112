import java.util.Scanner;

public class Slide4 {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter your full name");
        String user_input = keyboard.nextLine();
        if(user_input.equals("no")){
            System.out.println("Fine then.  Goodbye.");
        }
        else {
            System.out.println("Thanks " + user_input + ". You rock!");
            System.out.println("You entered " + user_input.length() + " characters");
        }
    }
}
