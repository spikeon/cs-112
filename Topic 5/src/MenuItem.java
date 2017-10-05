import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuItem extends JButton {
  private String name;
  private double price;

  public MenuItem(String name, double price){
    super(name);
    this.name = name;
    this.price = price;
    addActionListener(new ClickListener());
  }
  private class ClickListener implements ActionListener {

    public ClickListener(){
      super();
    }

    public void actionPerformed(ActionEvent e){
      Example5.receipt.addLine(name);
    }
  }
}
