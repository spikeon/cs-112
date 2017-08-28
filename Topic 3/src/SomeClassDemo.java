public class SomeClassDemo {
    public static void main(String[] args){
        SomeClass test1 = new SomeClass();
        SomeClass test2 = new SomeClass();
        SomeClass test3 = new SomeClass();

        System.out.println(test1.getNum1());
        System.out.println(test1.getNum2());

        System.out.println(test2.getNum1());
        System.out.println(test2.getNum2());

        SomeClass test4 = new SomeClass();

        System.out.println(test3.getNum1());
        System.out.println(test3.getNum2());

    }
}
