import javax.swing.*;

public class Slide9 {
    public static void main(String[] args){
        String input = JOptionPane.showInputDialog("Enter your favorite movie");
        if(input == null) System.out.println("You clicked cancel.");
        else System.out.println("I give that movie a 9/10");
    }
}
