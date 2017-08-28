import java.util.Scanner;

/*
    Prompt the user for an entire line of text.
    Output that line in uppercase.
    Hint: See the String class.
 */
public class Question11 {
    public static void main(String[] args){
        System.out.println("Enter a line of text:");
        Scanner keyboard = new Scanner(System.in);
        String line = keyboard.nextLine();
        System.out.println(line.toUpperCase());
    }

}
