import java.util.ArrayList;
import java.util.List;

public class Passwords {

  public List<Password> list = new ArrayList<Password>();

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

}