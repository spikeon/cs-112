public class FilterDemo {
    public static void main(String[] args) {

        BadWordFilter f = new BadWordFilter("This is a fucking test of this shitty ass filter");

        System.out.println(f.getFiltered());
    }
}
