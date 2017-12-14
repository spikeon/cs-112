import javax.swing.*;
import java.awt.*;

public class Adder extends JFrame {

  private int num = 0;
  private JTextField number;
  private JPanel form;
  private JButton add10;
  private JButton add50;

  public Adder(){
    setTitle("Adder");
    setSize(500, 100);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    form = new JPanel();
    number = new JTextField(40);
    add10 = new JButton("Add 10");
    add50 = new JButton("Add 50");

    add10.addActionListener(s -> changeNum(10));
    add50.addActionListener(s -> changeNum(50));

    form.setLayout(new FlowLayout());
    form.add(number);
    form.add(add10);
    form.add(add50);

    add(form);
    updateForm();
    setVisible(true);

  }

  public void changeNum(int amt){
    num += amt;
    updateForm();
  }

  public void updateForm(){
    number.setText(num + "");
  }

  public static void main(String[] args){
    new Adder();
  }
}
