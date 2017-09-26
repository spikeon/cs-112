import javax.swing.*;

public class Example1 extends JFrame {
    public Example1(){

        // Set the title
        setTitle("Example 1");

        // Set size: X, Y
        setSize(400, 300);

        // Apps keep running even after you click close
        // This will exit the program when you close it
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make this the last call in the constructor
        // Components added to the JFrame after this call won't be visible
        setVisible(true);
    }
    public static void main(String[] args){
        new Example1();
    }
}