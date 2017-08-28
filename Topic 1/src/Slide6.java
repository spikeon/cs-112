import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Slide6 {
    public static void main(String[] args){
        File f = new File("Romeo_and_Juliet.txt");
        String needle = "Romeo";
        int word_count = 0;
        try {
            Scanner s = new Scanner(f);
            while(s.hasNext()){
                String word = s.next();
                if(word.contains(needle)) word_count++;
            }
            System.out.println("Found " + word_count + " instances of " + needle);
        }
        catch (FileNotFoundException e){
            System.out.println("File Not Found.");
        }

    }
}
