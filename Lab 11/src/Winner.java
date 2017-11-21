import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Winner {
  public Map<String, Integer> scores = new HashMap<>();
  private Scanner k;
  public static void main(String[] args){
    new Winner();
  }
  public Winner(){
    k = new Scanner(System.in);
    for(int i = 0; i < 5; i++){
      System.out.println("Enter initials and score");
      String initials = k.next();
      int score = k.nextInt();
      scores.put(initials, score);
    }
    int max = 0;
    String winner = "";
    for(String key : scores.keySet()){
      int current = scores.get(key);
      if(current > max) {
        max = current;
        winner = key;
      }
    }
    System.out.println("Top player: " + winner + " : " + scores.get(winner));
  }
}
