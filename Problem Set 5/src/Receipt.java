import javax.swing.*;
import java.text.NumberFormat;

public class Receipt extends JTextArea{
  private String header;
  private double total;
  private int ctr;
  public Receipt(String header) {
    super(header);
    this.header = header;
    this.total = 0;
    ctr = 0;
  }

  private String formatTotal() {
    NumberFormat formatter = NumberFormat.getCurrencyInstance();
    formatter.setMinimumIntegerDigits(1);
    return formatter.format(total);
  }
  public void addLine(String line){
    if(ctr == 0 && header.equals("")) setText(line);
    else setText(getText() + "\r\n" + line);
    ctr++;
  }
  public void addMenuItem(MenuItem item){
    addLine(item.toString());
    total += item.getPrice();
  }
  public void reset(){
    total = 0;
    ctr = 0;
    setText(header);
  }
  public void total() {
    addLine("--- Cost: " + formatTotal());
  }

}
