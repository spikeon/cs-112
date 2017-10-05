import javax.swing.*;

public class TicTacToe extends JFrame {
  public static Grid grid;
  public static void main(String args[]){
    new TicTacToe();
  }
  public TicTacToe(){
    setTitle("Tic Tac Toe");
    setSize(300,300);
    grid = new Grid();
    grid.add(new Item(PositionX.TOP, PositionY.LEFT));

  }
}
