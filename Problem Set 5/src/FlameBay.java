import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/*
Write a class which represents a Mongolian BBQ Restaurant. Call this class FlameBay. Match the given GUI as closely as possible. It must also operate in the same manner.

The GUI is here: https://drive.google.com/file/d/0B3ewMEWBgrMkX2hrQjh1TGhSa1k/view?usp=sharing

The GUI will have the following components:
Nine buttons representing different menu options and the associated prices
A text area which display the items currently ordered and the associated price
A clear button which clears the text area
A check out button which totals the meal and display the cost (assume no tax)
A title of "Flame Bay"
 */
public class FlameBay extends JFrame {
  public static Receipt receipt;
  public static void main(String args[]){
    new FlameBay();
  }
  public FlameBay(){
    receipt = new Receipt("");


    setTitle("Flame Bay");
    setSize(1200, 700);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel menu = new JPanel();
    menu.setLayout(new GridLayout(3, 3 ));

    ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();

    menuItems.add(new MenuItem("Egg Noodles", 1.00, "egg_noodles.jpg"));
    menuItems.add(new MenuItem("Spaghetti", .95, "spaghetti.jpeg"));
    menuItems.add(new MenuItem("Ramen", .50, "ramen.jpg"));
    menuItems.add(new MenuItem("Beef", 2.00, "beef.jpg"));
    menuItems.add(new MenuItem("Chicken", 1.50, "chicken.jpg"));
    menuItems.add(new MenuItem("Pork", 1.25, "pork.jpg"));
    menuItems.add(new MenuItem("Kung Pao", .50, "kung_pao.png"));
    menuItems.add(new MenuItem("Teriyaki", .25, "teriyaki.jpg"));
    menuItems.add(new MenuItem("Curry", 0.45, "curry.jpg"));

    for(MenuItem i : menuItems){ menu.add(i); }

    Checkout checkout = new Checkout();
    Clear clear = new Clear();
    add(clear, BorderLayout.NORTH);
    add(menu, BorderLayout.WEST);
    add(receipt, BorderLayout.CENTER);
    add(checkout, BorderLayout.SOUTH);

    setVisible(true);

  }
}
