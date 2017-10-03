import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuItem extends JButton {
  private String name;
  private double price;
  private Receipt receipt;
  public MenuItem(String name, double price, Receipt receipt){
    super(name);
    this.name = name;
    this.price = price;
    this.receipt = receipt;
    addActionListener(new ClickListener());
  }
  private class ClickListener implements ActionListener {

    public ClickListener(){
      super();
    }

    public void actionPerformed(ActionEvent e){
      receipt.addLine(name);
    }
  }
}
