public class Potential implements Comparable<Potential> {

  private String s;

  public Potential(String s){
    this.s = s;
  }

  public int compareTo(Potential potential){
    if(s.length() < potential.s.length()) return 1;
    else if(s.length() == s.length()) {
      return 0;
    }
    else return -1;
  }

  public String toString(){
    return this.s;
  }

}
