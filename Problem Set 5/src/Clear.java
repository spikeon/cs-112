import javax.swing.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;

public class Clear extends JButton {
  public Clear(){
    super();
    setText("Clear");
    addActionListener(new ClearListener());
  }
  private class ClearListener implements ActionListener {

    public ClearListener(){
      super();
    }

    public void actionPerformed(ActionEvent e){
      FlameBay.receipt.reset();
    }
  }
}
