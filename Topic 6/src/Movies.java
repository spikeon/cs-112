import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Movies {

  private Set<Movie> list = new TreeSet<Movie>();

  public Movies(){
      File f = new File("movie_list.txt");
      try {
        Scanner s = new Scanner(f);
        while(s.hasNext()){
          list.add(new Movie(s.next()));
        }
      }
      catch (FileNotFoundException e){
        System.out.println("File Not Found.");
      }
  }

  public int size(){
    return this.list.size();
  }

  public static void main(String args[]){
    Movies movieList = new Movies();
    System.out.println("There are " + movieList.size() + " movies in the list");
  }

}
