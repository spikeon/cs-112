import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Server {
    public Server() {
    }

    public static String hash(String var0) {
        try {
            MessageDigest var1 = MessageDigest.getInstance("SHA-256");
            var1.update(var0.getBytes());
            byte[] var2 = var1.digest();
            StringBuilder var3 = new StringBuilder();

            for(int var4 = 0; var4 < var2.length; ++var4) {
                var3.append(Integer.toString((var2[var4] & 255) + 256, 16).substring(1));
            }

            return var3.toString();
        } catch (NoSuchAlgorithmException var5) {
            var5.printStackTrace();
            return null;
        }
    }

    public static void main(String[] var0) throws IOException {
        char var1 = '\ue677';
        ServerSocket var2 = new ServerSocket(var1);

        while(true) {
            while(true) {
                try {
                    System.out.println("Waiting for password attempts");
                    Socket var3 = var2.accept();
                    System.out.println("Someone is breaking in!");
                    PrintWriter var4 = new PrintWriter(var3.getOutputStream(), true);

                    String var6;
                    for(BufferedReader var5 = new BufferedReader(new InputStreamReader(var3.getInputStream())); (var6 = var5.readLine()) != null; var4.flush()) {
                        if (!hash(var6).equals("333e0a1e27815d0ceee55c473fe3dc93d56c63e3bee2b3b4aee8eed6d70191a3") && !hash(var6).equals("d50aade27375357f547cd56c324fc12e877bcaf9665988766d9697cbdc435160") && !hash(var6).equals("0039d3f9dd3066199d77988be208de99c9b1e3441836fab2196f6918bf7033ad") && !hash(var6).equals("251803649b3bf23cfb1d7c787c1fae9c56922b1cf464b09058a54f319ded1519") && !hash(var6).equals("b7fb65a0e8cf832c6245a7a8fa2489b531085820b34cbd82ff0351f526348cf6") && !hash(var6).equals("ed8574126bbfe4264332111e435ca8f579004ee5c655f2190170333aa559bd41") && !hash(var6).equals("5e5f502dba30cc2abca534fbb1b7464d5c77c9b24a67bea1b7454d66e65c04d6") && !hash(var6).equals("ed399f0818f6de944d3b08221a89f5049aca31a27459d670bd521d36ee70106a") && !hash(var6).equals("68afef543c48dfd2679315c94676acc2111f988192b98bf4102f5ee24c3b4803") && !hash(var6).equals("69904d1f64b5bf321b5c01a066cf007728675ad72330be0ecd2c718e050dd2bf")) {
                            var4.println("no");
                        } else {
                            var4.println("yes");
                        }
                    }
                } catch (IOException var7) {
                    System.out.println("Connection terminated.");
                }
            }
        }
    }
}
