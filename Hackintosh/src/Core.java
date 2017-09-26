import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Core  extends JFrame {
    public static Passwords passwords = new Passwords();

    public static int max = 10;
    public static boolean[] lengths = {false, false, false, false, false, false, false, false, false, false};

    public static long attempts = 0;
    public static long seconds = 0;
    public static long instances = 0;

    public static JTextField currentTextField = new JTextField(10);
    public static JTextField testedTextField = new JTextField(20);
    public static JTextField totalTextField = new JTextField(20);
    public static JTextField secondsTextField = new JTextField(6);
    public static JTextField queueTextField = new JTextField(10);
    public static JTextField bufferTextField = new JTextField(20);

    public static Connection conn = null;

    public static void main(String[] args){
        new Core();
    }

    /*
333e0a1e27815d0ceee55c473fe3dc93d56c63e3bee2b3b4aee8eed6d70191a3
d50aade27375357f547cd56c324fc12e877bcaf9665988766d9697cbdc435160
0039d3f9dd3066199d77988be208de99c9b1e3441836fab2196f6918bf7033ad
251803649b3bf23cfb1d7c787c1fae9c56922b1cf464b09058a54f319ded1519
b7fb65a0e8cf832c6245a7a8fa2489b531085820b34cbd82ff0351f526348cf6
ed8574126bbfe4264332111e435ca8f579004ee5c655f2190170333aa559bd41
5e5f502dba30cc2abca534fbb1b7464d5c77c9b24a67bea1b7454d66e65c04d6
ed399f0818f6de944d3b08221a89f5049aca31a27459d670bd521d36ee70106a
68afef543c48dfd2679315c94676acc2111f988192b98bf4102f5ee24c3b4803
69904d1f64b5bf321b5c01a066cf007728675ad72330be0ecd2c718e050dd2bf
     */

    public static void noMysql(){
        System.out.println("No MySql Connection, loading all hashes");
        passwords.add( 1,"333e0a1e27815d0ceee55c473fe3dc93d56c63e3bee2b3b4aee8eed6d70191a3"); // G
        passwords.add( 2,"d50aade27375357f547cd56c324fc12e877bcaf9665988766d9697cbdc435160"); // 7D
        passwords.add( 3,"0039d3f9dd3066199d77988be208de99c9b1e3441836fab2196f6918bf7033ad"); // cP3
        passwords.add( 4,"251803649b3bf23cfb1d7c787c1fae9c56922b1cf464b09058a54f319ded1519"); // de38
        passwords.add( 5,"b7fb65a0e8cf832c6245a7a8fa2489b531085820b34cbd82ff0351f526348cf6"); // 69409
        passwords.add( 6,"ed8574126bbfe4264332111e435ca8f579004ee5c655f2190170333aa559bd41"); // REB52S
        passwords.add( 7,"5e5f502dba30cc2abca534fbb1b7464d5c77c9b24a67bea1b7454d66e65c04d6"); // 3qQaW29
        passwords.add( 8,"ed399f0818f6de944d3b08221a89f5049aca31a27459d670bd521d36ee70106a"); // b00Scar3
        passwords.add( 9,"68afef543c48dfd2679315c94676acc2111f988192b98bf4102f5ee24c3b4803"); // 
        passwords.add( 10,"69904d1f64b5bf321b5c01a066cf007728675ad72330be0ecd2c718e050dd2bf");//
    }


    public static boolean lengthFound(int length){
        if(length == 0) return true;
        return lengths[(length-1)];
    }

    public static boolean lengthFound(String s){
        return lengthFound(s.length());
    }

    public static void found(String s){

        lengths[s.length()-1] = true;
        //refresh();
    }

    public Core(){
/*
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
                noMysql();
            }
        }
*/
        noMysql();

        //new Thread(new Log());

        Thread t = new Thread(new CrackQueue());
        t.start();


        // Set the title
        setTitle("Cracker");

        // Set size: X, Y
        setSize(1000, 1000);

        // Apps keep running even after you click close
        // This will exit the program when you close it
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel passwordsPanel = new JPanel();
        passwordsPanel.setLayout(new GridLayout(passwords.list.size() + 1, 3 ));

        passwordsPanel.add(new JLabel("#"));
        passwordsPanel.add(new JLabel("Hash"));
        passwordsPanel.add(new JLabel("Found"));

        for(Password p : passwords.list){
            passwordsPanel.add(new JLabel("" + p.id));
            passwordsPanel.add(new JTextField(p.getEncrypted()));
            passwordsPanel.add(p.field);

        }

        JPanel statusPanel = new JPanel();
        statusPanel.setLayout(new GridLayout(2, 6));

        statusPanel.add(new JLabel("Current"));
        statusPanel.add(new JLabel("Tested"));
        statusPanel.add(new JLabel("Total"));
        statusPanel.add(new JLabel("Seconds"));
        statusPanel.add(new JLabel("Queue Size"));
        statusPanel.add(new JLabel("Buffer Size"));

        statusPanel.add(currentTextField);
        statusPanel.add(testedTextField);
        statusPanel.add(totalTextField);
        statusPanel.add(secondsTextField);
        statusPanel.add(queueTextField);
        statusPanel.add(bufferTextField);

        add(passwordsPanel, BorderLayout.NORTH);
        add(new JSeparator(), BorderLayout.CENTER);
        add(statusPanel, BorderLayout.SOUTH);

        pack();


        // Make this the last call in the constructor
        // Components added to the JFrame after this call won't be visible
        setVisible(true);
    }

}