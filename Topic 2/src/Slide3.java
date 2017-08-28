public class Slide3 {
    public static void main(String[] args){
        BankAccount b1 = new BankAccount();
        BankAccount b2 = new BankAccount();
        b1.deposit(50);
        b2.deposit(75);

        b1.withdraw(20);
        b1.withdraw(5);
        b2.withdraw(4.50);

        System.out.println(b1.getBalance());
        System.out.println(b2.getBalance());
    }
}
