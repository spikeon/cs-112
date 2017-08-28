public class Example1 {

    public static void main(String[] args){
        Rectangle r1 = new Rectangle(20,10);
        Rectangle r2 = new Rectangle();

        r2.setLength(1);
        r2.setWidth(3);

        r1.setLength(12);

        System.out.println(r1.getArea());
        System.out.println(r2.getArea());
    }
}
