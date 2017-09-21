import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Check {
  private static boolean shutdown = false;
  private static List<String> words = new ArrayList<String>();

  public static void checkWord(String word){
    //if(words.contains(word)){
      System.out.println("\""+word+"\" is at index " + words.indexOf(word));
    //}
  }

  public static boolean loadDictionary(){
    File f = new File("dict.txt");
    try {
      Scanner s = new Scanner(f);
      while(s.hasNextLine()){
        words.add(s.nextLine());
      }
      System.out.println(words.size() + " words were loaded.");
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

    while(!shutdown){
      System.out.println("What word are you looking for?");
      String word = keyboard.nextLine();
      checkWord(word);
      System.out.println("Search again?");
      String c = keyboard.nextLine();
      if(c.equals("no")) shutdown = true;
    }

  }
}
