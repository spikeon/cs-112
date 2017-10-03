import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuItem extends JButton {
  private String name;
  private int price;
  public MenuItem(String name, int price){
    super(name + " $" + price);
    this.name = name;
    this.price = price;
    addActionListener(new ClickListener());
  }
  private class ClickListener implements ActionListener {

    public ClickListener(){
      super();
    }

    public void actionPerformed(ActionEvent e){
      Terminal.receipt.addMenuItem(name, price);
    }
  }
}
