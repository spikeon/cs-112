import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Item extends JButton {
  private PositionX x;
  private PositionY y;
  private boolean set = false;

  public Item(PositionX x, PositionY y) {
    super("");
    addActionListener(new ClickListener());
    this.x = x;
    this.y = y;
  }

  public void reset(){
    this.set = false;
    setText("");
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
      if(set) return;
      if(!TicTacToe.running) return;
      set = true;
      setText(TicTacToe.getNext());
      TicTacToe.checkState();
    }
  }}
