import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Checkout extends JButton {
  public Checkout(){
    super();
    setText("Check Out");
    addActionListener(new CheckoutListener());
  }
  private class CheckoutListener implements ActionListener {

    public CheckoutListener(){
      super();
    }

    public void actionPerformed(ActionEvent e){
      // FlameBay.receipt.reset();
      FlameBay.receipt.total();
    }
  }
}
