import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Crack implements Runnable{
  private String current;
  public static String last;
  public static List<String> alphanumeric = new ArrayList(Arrays.asList("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","1","2","3","4","5","6","7","8","9","0"));

  public Crack(){
    current = "";
  }
  public Crack(String current){
    this.current = current;
  }
  public void run() {
    Core.instances++;
    last = current;

    if(!Core.lengthFound(current)) {
      Core.attempts++;
      Core.passwords.check(current);
    }

    if(current.length() + 1 <= Core.max) {

      //while(CrackQueue.incoming.size() > 30000000){
      //  try {
      //    Thread.sleep(100);                 //1000 milliseconds is one second.
      //  } catch(InterruptedException ex) {
      //    Thread.currentThread().interrupt();
      //  }
      //}

      for (String a : alphanumeric) {
        CrackQueue.add(current + a);
      }

    }
  }
}
