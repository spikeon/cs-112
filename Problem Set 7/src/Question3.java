import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/*
  Prompt the user for a file name.
  Scan the file (use data_store.next()) to determine the most commonly used word that's longer than 5 characters.

 */
public class Question3 {
  private static Scanner k = new Scanner(System.in);
  private static Map<String, Integer> m = new HashMap<>();
  public static void main(String[] args){
    System.out.println("Enter a file name");
    String filename = k.nextLine();

    File f = new File(filename);
    try {
      System.out.println("Opening "+filename);
      Scanner s = new Scanner(f);
      while(s.hasNext()){
        String current = s.next();
        Integer count = m.getOrDefault(current, 0);
        m.put(current, ++count);
      }
    }
    catch(FileNotFoundException e){
      System.out.println("File Not Found.");
    }
    String max = "";
    Integer maxnum = 0;
    for(String k : m.keySet()){
      if(k.length() > 5) {
        if (m.get(k) > maxnum) {
          max = k;
          maxnum = m.get(k);
        }
      }
    }

    System.out.println("Most common word");
    System.out.println(max + " -> " + maxnum);

  }
}
