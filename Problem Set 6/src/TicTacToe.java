import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame {
  public static Grid grid;
  public static JMenu menu;
  public static JMenuBar menuBar;

  public static void main(String args[]){
    new TicTacToe();
  }
  private static String next = "X";
  private static String alt = "O";

  public static volatile boolean running = true;

  private static Item[][] items = new Item[3][3];

  public static String getNext(){
    String n = next;
    next = alt;
    alt = n;
    return n;
  }

  public TicTacToe(){
    setTitle("Tic Tac Toe");
    setSize(300,300);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    grid = new Grid();

    menuBar = new JMenuBar();
    menu = new JMenu("File");
    JMenuItem exit = new JMenuItem("Exit");
    menu.add(exit);
    menuBar.add(menu);
    setJMenuBar(menuBar);

    exit.addActionListener(new ExitListener());

    int xctr = 0;
    for(PositionX x : PositionX.values()) {
      int yctr = 0;
      for (PositionY y : PositionY.values()) {
        items[xctr][yctr] = new Item(x, y);
        grid.add(items[xctr][yctr]);
        yctr++;
      }
      xctr++;
    }

    add(grid);

    setVisible(true);

  }

  public static void reset(){
    for(Item[] y : items){
      for(Item x : y){
        x.reset();
      }
    }
    running = true;
  }

  private static void win(String user){
    System.out.println(user + "Wins");
    running = false;
    JOptionPane.showMessageDialog(null,"Winner: "+ user);
    reset();
  }

  private static void tie(){
    System.out.println("Tie");
    running = false;
    JOptionPane.showMessageDialog(null,"Tie!");
    reset();
  }


  public static void checkState(){

    int xctr = 0;
    String status[][] = new String[3][3];
    for(PositionX x : PositionX.values()) {
      int yctr = 0;
      for (PositionY y : PositionY.values()) {
        status[xctr][yctr] = items[xctr][yctr].getText();
        yctr++;
      }
      String[] ystatus = status[xctr];
      if(!ystatus[0].isEmpty() && ystatus[0].equals(ystatus[1]) && ystatus[0].equals(ystatus[2])){
        win(ystatus[1]);
        return;
      }
      xctr++;
    }

    for(int ys = 0; ys < 3; ys++){
      String xstatus[] = new String[3];
      for(int xs = 0; xs < 3; xs++){
        xstatus[xs] = status[xs][ys];
      }
      if(!xstatus[0].isEmpty() && xstatus[0].equals(xstatus[1]) && xstatus[0].equals(xstatus[2])){
        win(xstatus[0]);
        return;
      }
    }

    if(!status[0][0].isEmpty() && status[0][0].equals(status[1][1]) && status[0][0].equals(status[2][2])){
      win(status[0][0]);
      return;
    }

    if(!status[0][2].isEmpty() && status[0][2].equals(status[1][1]) && status[0][2].equals(status[2][0])){
      win(status[0][2]);
      return;
    }

    boolean full = true;
    for(String[] x : status){for(String y: x){if(y.isEmpty()) full = false; }}

    if(full) tie();
  }

  private class ExitListener implements ActionListener {
    public ExitListener(){
      super();
    }

    public void actionPerformed(ActionEvent actionEvent) {
      System.exit(0);
    }
  }
}
