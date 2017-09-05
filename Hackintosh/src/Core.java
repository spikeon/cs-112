import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Core implements Runnable {
    private static Passwords passwords = new Passwords();

    public static int max = 10;
    public static boolean[] lengths = {false, false, false, false, false, false, false, false, false, false};
    // public static Core me;
    public static String[] alphanumeric = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","1","2","3","4","5","6","7","8","9","0"};
    private String current;
    public static long attempts = 0;
    public static long seconds = 0;
    public static long instances = 0;

    private static ExecutorService service;
    public static Connection conn = null;

    public static void main(String[] args){

        service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        if(conn == null){
            try{
                conn = DriverManager.getConnection("jdbc:mysql://flynndev.us/hackintosh?user=root&password=7e8983abd51a92fb4249fa644bc359bf3aba7eb13d6222bb");
                Statement stmt = conn.createStatement();
                ResultSet resultSet = stmt.executeQuery("SELECT * FROM hashes");
                while(resultSet.next()){
                    if(resultSet.getString("password") == null){
                        passwords.add(resultSet.getInt("id"), resultSet.getString("hash"));
                        System.out.println("Loaded Hash: " + resultSet.getString("hash"));
                    } else {
                        found(resultSet.getString("password"));
                        System.out.println("Password length already found: " + resultSet.getString("password").length());
                    }
                }
                stmt.close();

            }
            catch (SQLException e){
                System.out.println("SQLException: " + e.getMessage());
            }
        }

        service.submit(new Core());

        new Log();

    }


    public Core () {
        this.current = "";
    }

    public Core (String current){
        this.current = current;
    }

    public boolean lengthFound(int length){
        if(length == 0) return true;
        return lengths[(length-1)];
    }
    public boolean lengthFound(String s){
        return lengthFound(s.length());
    }

    public static void found(String s){
        lengths[s.length()-1] = true;
    }

    public void run() {
        instances++;

        if(!lengthFound(current)) {
            attempts++;
            passwords.check(current);
        }

        if(current.length() + 1 <= max) {
            for (String a : alphanumeric) {
                service.submit(new Core(current + a));
            }
        }

    }
}