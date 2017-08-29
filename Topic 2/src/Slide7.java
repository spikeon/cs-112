public class Slide7 {

    public static double add(double num1, double num2) {
        return num1 + num2;
    }

    public static String add(String a, String b) {
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println("Doubles: " + add(12, 32.2));
        System.out.println("Strings: " + add("test", "y"));
    }

}
