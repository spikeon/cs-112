import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Movies {

  public static HashMap<String, Movie> list = new HashMap<String, Movie>();

  public static String lastMovie = "";

  public Movies(){
      File f = new File("movie_list.txt");
      try {
        Scanner s = new Scanner(f);
        while(s.hasNextLine()){
          String name = s.nextLine();
          int year = Integer.parseInt(s.nextLine());
          String genre = s.nextLine();
          addMovie(name, year, genre);
        }
      }
      catch (FileNotFoundException e){
        System.out.println("File Not Found.");
      }
  }

  public static void addMovie(String name, int year, String genre){
    if(list.containsKey(name)){
      list.get(name).addGenre(genre);
    }
    else list.put(name, new Movie(name, year, genre));
  }

  public int size(){
    return list.size();
  }

  public static void main(String args[]){
    Movies movieList = new Movies();
    System.out.println("There are " + movieList.size() + " movies in the list");
    TreeMap<String, Movie> result = new TreeMap<String, Movie>(new ValueComparator(list));
    result.putAll(list);
    //System.out.println(result);
    for(Movie m : result.values()){
      System.out.println(m);
    }
  }

  private static class ValueComparator implements Comparator<String>{

    HashMap<String, Movie> map = new HashMap<String, Movie>();

    public ValueComparator(HashMap<String, Movie> map){
      this.map.putAll(map);
    }

    @Override
    public int compare(String s1, String s2) {
      return map.get(s1).compareTo(map.get(s2));
    }
  }
}
