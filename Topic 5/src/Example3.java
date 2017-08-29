import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Example3 extends Window {

    public JButton button1;
    public JButton button2;
    public JButton button3;
    public JLabel label1;


    public static void main(String[] args) {
        new Example3();
    }

    public Example3() {
        super("My Window", 800, 100);
    }

    public void buildPanel(){
        label1 = new JLabel();

        button1 = new JButton("Compliment 1");
        button2 = new JButton("Compliment 2");
        button3 = new JButton("Compliment 3");

        button1.addActionListener(new ComplimentListener(0));
        button2.addActionListener(new ComplimentListener(1));
        button3.addActionListener(new ComplimentListener(2));

        panel.add(label1);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
    }

    private class ComplimentListener implements ActionListener {
        private int compliment;
        private String[] compliments = {"1", "2", "3"};

        public ComplimentListener(int compliment){
            super();
            this.compliment = compliment;
        }

        public void actionPerformed(ActionEvent e){
            label1.setText(label1.getText() + " " + compliments[compliment]);
        }
    }


}
