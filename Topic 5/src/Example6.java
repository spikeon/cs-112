import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Example6 extends JFrame {
  public static void main(String args[]){
    new Example6();
  }
  private String first = "Disagree";
  private String second = "Agree";
  public JButton next;
  public Example6(){
    setTitle("Terms and Conditions");
    setSize(500, 500);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel buttons = new JPanel();
    JTextArea tac = new JTextArea("You probably won't read this");

    JRadioButton firstButton = new JRadioButton(first);
    firstButton.setActionCommand(first);
    firstButton.setSelected(true);

    JRadioButton secondButton = new JRadioButton(second);
    secondButton.setActionCommand(second);

    // Group the radio buttons.
    ButtonGroup group = new ButtonGroup();
    group.add(firstButton);
    group.add(secondButton);

    RadioListener radioListener = new RadioListener();
    firstButton.addActionListener(radioListener);
    secondButton.addActionListener(radioListener);

    next = new JButton("Next");
    next.setEnabled(false);
    next.addActionListener(new ClickListener());

    buttons.add(firstButton);
    buttons.add(secondButton);
    buttons.add(next);

    add(buttons, BorderLayout.SOUTH);
    add(tac, BorderLayout.CENTER);

    setVisible(true);
  }
  private class ClickListener implements ActionListener {

    public ClickListener(){
      super();
    }

    public void actionPerformed(ActionEvent e){
        dispose();
    }
  }
  private class RadioListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      next.setEnabled(e.getActionCommand() != first);
    }
  }
}
