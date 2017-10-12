import java.util.ArrayList;
import java.util.List;

public class Passwords {
  public List<Password> list = new ArrayList<Password>();

  public void add(int id, Password p) {
    list.add(p);
  }

  public void add(int id, String hash) {
    list.add(new Password(id, hash));
  }

  public boolean check(String pw) {
    boolean flag = false;
    String hash = Password.encrypt(pw);
    for (Password p : list) {
      if (p.checkHash(hash, pw)) flag = true;
    }
    return flag;
  }

  public int found() {
    int ctr = 0;
    for (Password p : list) {
      if (p.isFound()) ctr++;
    }
    return ctr;
  }

  public boolean isDone() {
    return found() >= list.size();
  }

}
