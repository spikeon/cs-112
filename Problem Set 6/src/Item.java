import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Item extends JButton {
  private PositionX x;
  private PositionY y;
  private boolean set = false;

  public Item(PositionX x, PositionY y) {
    this.x = x;
    this.y = y;
  }

  public PositionX getPositionX(){
    return x;
  }

  public PositionY getPositionY(){
    return y;
  }

  private class ClickListener implements ActionListener {
    public ClickListener(){ super(); }
    public void actionPerformed(ActionEvent e){
      set = true;

    }
  }}
