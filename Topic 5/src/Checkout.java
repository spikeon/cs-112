import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Checkout extends JButton {
  private Receipt receipt;
  public Checkout(Receipt receipt){
    super();
    setText("Checkout");
    this.receipt = receipt;
    addActionListener(new ClickListener());
  }
  private class ClickListener implements ActionListener {

    public ClickListener(){
      super();
    }

    public void actionPerformed(ActionEvent e){
      receipt.reset();
    }
  }
}
