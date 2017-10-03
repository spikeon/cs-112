import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Example4 extends JFrame {

  public JButton button1;
  public int ctr = 0;

  public static void main(String[] args) {
    new Example4();
  }

  public Example4() {

    setTitle("My Window");
    setSize(300, 300);

    button1 = new JButton("No Clicks Yet!");
    button1.addActionListener(new ClickListener());

    add(button1, BorderLayout.CENTER);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setVisible(true);
  }

  private class ClickListener implements ActionListener {

    public ClickListener(){
      super();
    }

    public void actionPerformed(ActionEvent e){
      ctr++;
      button1.setText(ctr + " Clicks!");
    }
  }
}