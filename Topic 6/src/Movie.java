public class Movie implements Comparable<Movie> {
  public String name;
  public Movie(String name){
    this.name = name;
  }
  public int compareTo(Movie movie) {
    if(this.name.equals(movie.name)) return 0;
    else return 1;
  }
  public String toString(){
    return this.name;
  }
}
