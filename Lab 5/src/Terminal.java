import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Terminal extends JFrame {

  public static Receipt receipt;

  public static void main(String[] args) {
    new Terminal();
  }

  public Terminal() {

    setTitle("Ordering Terminal");
    setSize(500, 300);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    receipt = new Receipt();


    JPanel menu = new JPanel();
    menu.add(new MenuItem("Burger", 3));
    menu.add(new MenuItem("Salad", 2));
    menu.add(new MenuItem("Soda", 1));

    add(receipt, BorderLayout.CENTER);
    add(menu, BorderLayout.SOUTH);

    setVisible(true);
  }

}