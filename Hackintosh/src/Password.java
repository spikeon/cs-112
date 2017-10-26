import javax.swing.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class Password {
  public JTextField field = new JTextField(10);
  public JTextField seconds = new JTextField(10);
  public int id;
  private String encrypted;
  private boolean found = false;
  private String unencrypted;

  public Password(int id, String encrypted) {
    this.id = id;
    this.encrypted = encrypted;
  }

  public static String encrypt(String potential) {
    // Encrypt to: sha256
    try {
      MessageDigest digest = MessageDigest.getInstance("SHA-256");
      digest.update(potential.getBytes());
      byte[] pre = digest.digest();
      StringBuilder fin = new StringBuilder();
      for (int i = 0; i < pre.length; ++i) {
        fin.append(Integer.toString((pre[i] & 255) + 256, 16).substring(1));
      }
      return fin.toString();
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
      return null;
    }
  }

  public boolean checkHash(String hash, String potential) {
    if (hash.equals(encrypted)) {
      found = true;
      unencrypted = potential;
      if(Core.gui) {
        this.field.setText(unencrypted);
        this.seconds.setText("" + Core.seconds);
      } else {
        System.out.println("Found Password: " + potential + " ( " + hash + " ) [seconds:" + Core.seconds + "]");
      }
      Core.found(unencrypted);
      return true;
    }
    return false;
  }

  public String getEncrypted() {
    return encrypted;
  }

  public boolean isFound() {
    return found;
  }
}
