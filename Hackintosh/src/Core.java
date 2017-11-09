import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class Core extends JFrame {
  public static Passwords passwords = new Passwords();

  public static volatile boolean run = false;

  public static int length = 1;
  public static int max = 10;
  public static boolean[] lengths = {false, false, false, false, false, false, false, false, false, false};

  public static boolean incrementMode = true;
  public static boolean alphaSort = true;

  public static long attempts = 0;
  public static long startTime;
  public static long prevSeconds = 0;
  public static long seconds;
  public static long instances = 0;

  public static JTextField currentTextField = new JTextField(10);
  public static JTextField testedTextField = new JTextField(20);
  public static JTextField totalTextField = new JTextField(20);
  public static JTextField secondsTextField = new JTextField(6);
  public static JTextField queueTextField = new JTextField(10);
  public static JTextField bufferTextField = new JTextField(20);
  public static JButton button;
  private static Thread t;

  public static boolean gui = true;

  public Core() {

    if(incrementMode) {
      length = 1;
    }
    else {
      length = max;
    }

    startTime = (int) (System.currentTimeMillis() / 1000L);

    t = new Thread(new CrackQueue());
    t.start();

//    passwords.add(1, "333e0a1e27815d0ceee55c473fe3dc93d56c63e3bee2b3b4aee8eed6d70191a3"); // G
//    passwords.add(2, "d50aade27375357f547cd56c324fc12e877bcaf9665988766d9697cbdc435160"); // 7D
//    passwords.add(3, "0039d3f9dd3066199d77988be208de99c9b1e3441836fab2196f6918bf7033ad"); // cP3
//    passwords.add(4, "251803649b3bf23cfb1d7c787c1fae9c56922b1cf464b09058a54f319ded1519"); // de38
//    passwords.add(5, "b7fb65a0e8cf832c6245a7a8fa2489b531085820b34cbd82ff0351f526348cf6"); // 69409
//    passwords.add(6, "ed8574126bbfe4264332111e435ca8f579004ee5c655f2190170333aa559bd41"); // REB52S
//    passwords.add(7, "5e5f502dba30cc2abca534fbb1b7464d5c77c9b24a67bea1b7454d66e65c04d6"); // 3qQaW29
//    passwords.add(8, "ed399f0818f6de944d3b08221a89f5049aca31a27459d670bd521d36ee70106a"); // b00Scar3
//    passwords.add(9, "68afef543c48dfd2679315c94676acc2111f988192b98bf4102f5ee24c3b4803"); // u48tgDF12
//    passwords.add(10, "69904d1f64b5bf321b5c01a066cf007728675ad72330be0ecd2c718e050dd2bf");//

    passwords.add(1,  "86be9a55762d316a3026c2836d044f5fc76e34da10e1b45feee5f18be7edb177","K");
    passwords.add(2,  "05bb5f0450bd7ae843ecf0b0a59698fd93d83a3930686eb7cfcf33fbb26edde4","x9");
    passwords.add(3,  "d6f0c71ef0c88e45e4b3a2118fcb83b0def392d759c901e9d755d0e879028727","143");
    passwords.add(4,  "1597c0c4a4ecda6621cecf176139577ef0e08a30f7b2d722cd9aca9b60ebe9b7","*%#!");
    passwords.add(5,  "99914592d33e5ad12d31e9dd4080fc6560b8395e7ce8e76e90824ce0c3b8cc9e","By3!!");
    passwords.add(6,  "5588556e423b12300798a21abd02130e477f72899cbd5d858929f9a769083ee7","L#t3R~");
    passwords.add(7,  "2b3194bf8211b36d91466501dbf70d1da3e7ab97b048db5e333287b05f2264ff","%@h8&mb");
    passwords.add(8,  "25df7e3069d3907ab93b2c12b0d588cf20db1f758744336bb9eaf5c359af42b4");
    passwords.add(9,  "555d536c422c9bb89f51fa299bcf323febe4d5d6eba36df47042a54f92027f10");
    passwords.add(10, "f1afeb300c88583c77c2f1e568d3a6013b42333f7e650b9a48d6364dd76e83de");


    if(gui) {
      setTitle("Cracker");
      setSize(1000, 1000);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JPanel passwordsPanel = new JPanel();
      passwordsPanel.setLayout(new GridLayout(passwords.list.size() + 1, 4));
      passwordsPanel.add(new JLabel("#"));
      passwordsPanel.add(new JLabel("Hash"));
      passwordsPanel.add(new JLabel("Found"));
      passwordsPanel.add(new JLabel("Seconds To Find"));
      for (Password p : passwords.list) {
        passwordsPanel.add(new JLabel("" + p.id));
        passwordsPanel.add(new JTextField(p.getEncrypted()));
        passwordsPanel.add(p.field);
        passwordsPanel.add(p.seconds);
      }
      JPanel statusPanel = new JPanel();
      statusPanel.setLayout(new GridLayout(2, 6));
      statusPanel.add(new JLabel("Current"));
      statusPanel.add(new JLabel("Tested"));
      statusPanel.add(new JLabel("Total"));
      statusPanel.add(new JLabel("Seconds"));
      statusPanel.add(new JLabel("Queue Size"));
      statusPanel.add(new JLabel("Buffer Size"));
      statusPanel.add(currentTextField);
      statusPanel.add(testedTextField);
      statusPanel.add(totalTextField);
      statusPanel.add(secondsTextField);
      statusPanel.add(queueTextField);
      statusPanel.add(bufferTextField);
      add(statusPanel, BorderLayout.NORTH);
      add(passwordsPanel, BorderLayout.CENTER);
      button = new JButton("Start");
      button.addActionListener(new ClickListener());
      add(button, BorderLayout.SOUTH);
      pack();
      setVisible(true);
    } else {
      run = true;
    }
  }


  public static void main(String[] args) {
    new Core();
  }

  public static boolean lengthFound(int length) {
    if (length == 0) return true;
    return lengths[(length - 1)];
  }

  public static boolean lengthFound(String s) {
    return lengthFound(s.length());
  }

  public static void found(String s) {

    lengths[s.length() - 1] = true;
    if(incrementMode) {
      if (length <= max) length++;
      t.interrupt();
      t = new Thread(new CrackQueue());
      t.start();
    }
  }

  private class ClickListener implements ActionListener {
    public ClickListener(){
      super();
    }

    public void actionPerformed(ActionEvent e){
      if(run){
        prevSeconds += seconds;
        run = false;
        button.setText("Start");
      }
      else{
        startTime = (int) (System.currentTimeMillis() / 1000L);
        run = true;
        button.setText("Stop");
      }
    }
  }

  public static String getSeconds(){
    return "" + (prevSeconds + seconds);
  }

}