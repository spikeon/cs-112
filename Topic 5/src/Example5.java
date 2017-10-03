import javax.swing.*;
import java.awt.*;

public class Example5 extends JFrame {
  public static void main(String args[]){new Example5();}
  public Example5(){
    setTitle("In-N-Out Burger");
    setSize(500, 500);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel menu = new JPanel();
    menu.setLayout(new GridLayout(3, 2 ));

    Receipt receipt       = new Receipt();

    MenuItem hamburger    = new MenuItem("Hamburger", 1.00, receipt);
    MenuItem cheeseburger = new MenuItem("Cheeseburger", 1.50, receipt);
    MenuItem doubleDouble = new MenuItem("Double Double", 3.00, receipt);
    MenuItem fries        = new MenuItem("Fries", 1.00, receipt);
    MenuItem animalFries  = new MenuItem("Animal Fries", 2.00, receipt);
    MenuItem milkShake    = new MenuItem("Milkshake", 1.00, receipt);

    menu.add(hamburger);
    menu.add(cheeseburger);
    menu.add(doubleDouble);
    menu.add(fries);
    menu.add(animalFries);
    menu.add(milkShake);

    Checkout checkout = new Checkout(receipt);

    add(menu, BorderLayout.WEST);
    add(receipt, BorderLayout.CENTER);
    add(checkout, BorderLayout.SOUTH);

    setVisible(true);



  }
}
