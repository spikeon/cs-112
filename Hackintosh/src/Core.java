import java.util.ArrayList;
import java.util.List;

public class Core {
    private static Passwords passwords = new Passwords();
    public static int max = 4;
    public static Core me;
    public static String[] alphanumeric = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","1","2","3","4","5","6","7","8","9","0"};

    public static void main(String[] args){

        passwords.add( new Password("333e0a1e27815d0ceee55c473fe3dc93d56c63e3bee2b3b4aee8eed6d70191a3"));
        passwords.add( new Password("d50aade27375357f547cd56c324fc12e877bcaf9665988766d9697cbdc435160"));
        passwords.add( new Password("0039d3f9dd3066199d77988be208de99c9b1e3441836fab2196f6918bf7033ad"));
        passwords.add( new Password("251803649b3bf23cfb1d7c787c1fae9c56922b1cf464b09058a54f319ded1519"));
        passwords.add( new Password("b7fb65a0e8cf832c6245a7a8fa2489b531085820b34cbd82ff0351f526348cf6"));
        passwords.add( new Password("ed8574126bbfe4264332111e435ca8f579004ee5c655f2190170333aa559bd41"));
        passwords.add( new Password("5e5f502dba30cc2abca534fbb1b7464d5c77c9b24a67bea1b7454d66e65c04d6"));
        passwords.add( new Password("ed399f0818f6de944d3b08221a89f5049aca31a27459d670bd521d36ee70106a"));
        passwords.add( new Password("68afef543c48dfd2679315c94676acc2111f988192b98bf4102f5ee24c3b4803"));
        passwords.add( new Password("69904d1f64b5bf321b5c01a066cf007728675ad72330be0ecd2c718e050dd2bf"));


        me.max = 0;
        while(!passwords.isDone()) {
            me.max++;
            System.out.println("Max Length: " + me.max);
            me.run("");
        }

        // END YOUR WORK

        System.out.println("Found: " + passwords.found());
    }

    public static void run(String current){
        if(current.length() > max) return;
        if(current.length() > 0) passwords.check(current);

        for (String a : alphanumeric) {
            me.run(current + a);
        }
    }
}