import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Password {
    private String encrypted;
    private boolean found = false;
    private String unencrypted;

    public Password (String encrypted){
        this.encrypted = encrypted;
    }

    private String simplify(String encrypted){
        // If we can reverse engineer the encrypted string to something that takes less steps to encrypt, do it here

        return encrypted;
    }

    private String encrypt(String potential){
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
        if(found) return false;
        if(encrypt(potential).equals(encrypted)){
            found = true;
            this.unencrypted = potential;
            System.out.println("Found Password: "+ potential );
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
