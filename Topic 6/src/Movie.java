import java.util.Set;
import java.util.TreeSet;

public class Movie implements Comparable<Movie> {

  private String name;
  private int year;
  private Set<String> genres = new TreeSet<String>();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public Set getGenres(){
    return genres;
  }

  public void addGenre(String genre){
    genres.add(genre);
  }

  public Movie(String name, int year, String genre) {
    this.name = name;
    this.year = year;
    this.genres.add(genre);
  }

  public int compareTo(Movie movie) {
    if(year < movie.year) return -1;
    else if(year == movie.year) {
      return name.compareTo(movie.name);
    }
    else return 1;
  }

  public String toString(){
    return name + "\t("+year+") : " + genres;
  }
}
