import javax.swing.*;

public class Receipt extends JTextArea{
  private String header = "";
  private int ctr = 0;
  private int total = 0;
  public Receipt() {
    super();
    setText(header);
  }
  public void addLine(String line){
    ctr++;
    setText( getText() + (ctr > 1 ? "\r\n" : "" ) + line);
  }
  public void addMenuItem(String name, int price){
    total += price;
    addLine("Ordered " + name + ". Total: $" + total);
  }
  public void reset(){
    setText(header);
  }

}
