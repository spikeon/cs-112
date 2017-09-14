import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Crack implements Runnable{
  private String current;
  public static List<String> alphanumeric = new ArrayList(Arrays.asList("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","1","2","3","4","5","6","7","8","9","0"));

  public Crack(){
    current = "";
  }
  public Crack(String current){
    this.current = current;
  }
  public void run() {
    Core.instances++;

    if(!Core.lengthFound(current)) {
      Core.attempts++;
      Core.passwords.check(current);
    }

    if(current.length() + 1 <= Core.max) {
      for (String a : alphanumeric) {
        CrackQueue.add(current + a);
      }
    }
  }
}
