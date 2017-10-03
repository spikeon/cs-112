import javax.swing.*;

public class Receipt extends JTextArea{
  private String header = "In-N-Out Burger\r\n-------------------------------";
  public Receipt() {
    super();
    setText(header);

  }
  public void addLine(String line){
    setText(getText() + "\r\n" + line);
  }
  public void reset(){
    setText(header);
  }

}
