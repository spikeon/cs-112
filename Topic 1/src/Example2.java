import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Example2 {

    public static File f;
    public static Scanner s;

    public static boolean checkWord(String word){
        s.reset();

        while(s.hasNext()){
            if(s.next().equals(word)) return true;
        }
        return false;
    }

    public static boolean loadDictionary(){
        f = new File("dictionary.txt");
        try {
            s = new Scanner(f);
            return true;
        }
        catch (FileNotFoundException e){
            System.out.println("File Not Found.");
            return false;
        }
    }

    public static void main(String[] args){
        if(! loadDictionary()) return;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a word");
        String word = keyboard.next();

        System.out.println("You entered: " + word);

        if(checkWord(word)){
            System.out.println("Correct Spelling");
        }
        else {
            System.out.println("Incorrect Spelling");
        }
    }
}
