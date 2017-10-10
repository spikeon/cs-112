public class City implements Comparable<City> {
  private String name;
  private int population;
  public City(String name, int population){
    this.name = name;
    this.population = population;
  }
  public int compareTo(City otherCity){
    if(population < otherCity.population) return -1;
    else if(population == otherCity.population) return 0;
    else return 1;
  }
  public String toString(){
    return name + " has a population of " + population;
  }
}
