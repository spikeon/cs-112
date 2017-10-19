public class Test extends UnitTest {

  public static void main(String[] args){
    MikeList<String> a = new MikeList<String>();

    test(a.size() == 0, "Starting size");

    a.add("1");
    test(a.size() == 1, "add 1");

    a.add("2");
    test(a.size() == 2, "add 2");

    a.add("3");
    test(a.size() == 3, "add 3");

    a.add("4");
    test(a.size() == 4, "add 4");

    test(a.get(0).equals("1"), "get 1");
    test(a.get(1).equals("2"), "get 2");
    test(a.get(2).equals("3"), "get 3");
    test(a.get(3).equals("4"), "get 4");

    test(a.remove(1).equals("2"), "remove 2");

    test(a.size() == 3, "removal resize");

    test(a.get(1).equals("3"), "removal shift 3");
    test(a.get(2).equals("4"), "removal shift 4");

    MikeList<String> b = new MikeList<String>(10);

    test(b.size() == 0, "Starting size");

    b.add("1");
    test(b.size() == 1, "add 1");

    b.add("2");
    test(b.size() == 2, "add 2");

    b.add("3");
    test(b.size() == 3, "add 3");

    b.add("4");
    test(b.size() == 4, "add 4");

    test(b.get(0).equals("1"), "get 1");
    test(b.get(1).equals("2"), "get 2");
    test(b.get(2).equals("3"), "get 3");
    test(b.get(3).equals("4"), "get 4");

    test(b.remove(1).equals("2"), "remove 2");

    test(b.size() == 3, "removal resize");

    test(b.get(1).equals("3"), "removal shift 3");
    test(b.get(2).equals("4"), "removal shift 4");

    String[] s = {"1","2","3","4"};

    MikeList<String> c = new MikeList<String>(s);

    test(c.size() == 4, "Starting size with array");

    c.add("5");
    test(c.size() == 5, "add 5");

    c.add("6");
    test(c.size() == 6, "add 6");

    c.add("7");
    test(c.size() == 7, "add 7");

    c.add("8");
    test(c.size() == 8, "add 8");

    test(c.get(0).equals("1"), "get 1");
    test(c.get(1).equals("2"), "get 2");
    test(c.get(2).equals("3"), "get 3");
    test(c.get(3).equals("4"), "get 4");
    test(c.get(4).equals("5"), "get 5");
    test(c.get(5).equals("6"), "get 6");
    test(c.get(6).equals("7"), "get 7");
    test(c.get(7).equals("8"), "get 8");

    test(c.remove(1).equals("2"), "remove 2");

    test(c.size() == 7, "removal resize");

    test(c.get(1).equals("3"), "removal shift 3");
    test(c.get(2).equals("4"), "removal shift 4");
    test(c.get(3).equals("5"), "removal shift 5");
    test(c.get(4).equals("6"), "removal shift 6");
    test(c.get(5).equals("7"), "removal shift 7");
    test(c.get(6).equals("8"), "removal shift 8");


    summary();
  }
}
