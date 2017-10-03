import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Example3 extends JFrame {

    public JButton button1;
    public JButton button2;
    public JButton button3;
    public JTextArea textarea1;


    public static void main(String[] args) {
        new Example3();
    }

    public Example3() {

        setTitle("My Window");
        setSize(800, 800);

        JPanel buttons = new JPanel();

        textarea1 = new JTextArea();

        button1 = new JButton("Compliment 1");
        button2 = new JButton("Compliment 2");
        button3 = new JButton("Compliment 3");

        button1.addActionListener(new ComplimentListener(0));
        button2.addActionListener(new ComplimentListener(1));
        button3.addActionListener(new ComplimentListener(2));

        add(textarea1, BorderLayout.NORTH);
        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);
        add(buttons, BorderLayout.SOUTH);

        setVisible(true);
    }

    private class ComplimentListener implements ActionListener {
        private int compliment;
        private String[] compliments = {"You are Awesome", "That was a great click!", "I like your face!"};

        public ComplimentListener(int compliment){
            super();
            this.compliment = compliment;
        }

        public void actionPerformed(ActionEvent e){
            textarea1.setText(textarea1.getText() + "\r\n" + compliments[compliment]);
        }
    }


}
