import javax.activation.DataSource;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class Password {
    private String encrypted;
    private boolean found = false;
    private String unencrypted;

    private int id;

    public Password (int id, String encrypted){
        this.id = id;
        this.encrypted = encrypted;
    }

    private String simplify(String encrypted){
        // If we can reverse engineer the encrypted string to something that takes less steps to encrypt, do it here

        return encrypted;
    }

    public static String encrypt(String potential){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(potential.getBytes());
            byte[] pre = digest.digest();
            StringBuilder fin = new StringBuilder();
            for(int i = 0; i < pre.length; ++i) {
                fin.append(Integer.toString((pre[i] & 255) + 256, 16).substring(1));
            }
            return fin.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean check(String potential){
        return !found && checkHash(encrypt(potential), potential);
    }

    public boolean checkHash(String hash, String potential){
        if(hash.equals(encrypted)){
            found = true;
            this.unencrypted = potential;
            System.out.println("Found Password: " + potential + " ( " + hash + " ) ");
            Core.found(potential);
            try {
                PreparedStatement s = Core.conn.prepareStatement("UPDATE hashes SET password = ? WHERE id = ?");
                s.setString(1, potential);
                s.setInt(2, id);
                s.execute();
            } catch (SQLException e){ System.out.println("SQLException: " + e.getMessage());}
            return true;
        }
        return false;
    }

    public String getEncrypted() {
        return encrypted;
    }

    public void setEncrypted(String encrypted) {
        this.encrypted = encrypted;
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

    public String getUnencrypted() {
        return unencrypted;
    }

    public void setUnencrypted(String unencrypted) {
        this.unencrypted = unencrypted;
    }
}
