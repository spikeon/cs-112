import javax.swing.*;

public class Example2 extends Window {

    public JButton button1;
    public JButton button2;
    public JButton button3;
    public JTextField textField;

    public static void main(String[] args) {
        new Example2();
    }

    public Example2() {
        super("My Window", 800, 100);
    }

    public void buildPanel(){
        textField = new JTextField(50);
        button1 = new JButton("Button 1");
        button2 = new JButton("Button 2");
        button3 = new JButton("Button 3");

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(textField);
    }

}
