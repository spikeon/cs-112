import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class GetUnique {
  private static Set<String> list = new TreeSet<String>();
  public static void main(String args[]){
    Scanner k = new Scanner(System.in);
    System.out.println("Enter name of movie file");
    String filename = k.nextLine();
    File f = new File(filename);
    try {
      Scanner s = new Scanner(f);
      while(s.hasNextLine()){
        String name = s.nextLine();
        list.add(name);
      }
    }
    catch (FileNotFoundException e){
      System.out.println("File Not Found.");
    }
    System.out.println("Number of unique movies: " + list.size());

  }
}
