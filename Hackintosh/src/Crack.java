import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Crack implements Runnable {
  private String current = "";
  private boolean propagate;
  public static String last;

  public Crack() {
    current = "";
    propagate = true;
  }

  public Crack(boolean propagate) {
    current = "";
    this.propagate = propagate;
  }

  public Crack(String current) {
    this.current = current;
    this.propagate = true;
  }

  public Crack(String current, boolean propagate) {
    this.current = current;
    this.propagate = propagate;
  }

  public Crack(String current[]) {
    for (String c : current) {
      if (this.current.equals("")) this.current = c;
      else CrackQueue.add(c);
    }
    this.propagate = true;
  }

  public Crack(String current[], boolean propagate) {
    for (String c : current) {
      if (this.current.equals("")) this.current = c;
      else CrackQueue.add(c);
    }
    this.propagate = propagate;
  }

  public void run() {
    while(!Core.run){}

    Core.instances++;
    last = current;

    if (!Core.lengthFound(current)) {
      Core.attempts++;
      Core.passwords.check(current);
    }

    if (propagate) {
      if (current.length() + 1 <= Core.length) {
        for( int i = 32; i <= 126; i++ ) CrackQueue.add(current + (char) i);
      }
    }
  }
}
