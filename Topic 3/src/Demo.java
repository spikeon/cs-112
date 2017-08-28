public class Demo {
    public static void processAccount(BankAccount b){
        if(b.getBalance() < 1000){
            b.applyServiceFee();
        }
    }
    public static void main(String[] args){
        BankAccount my_account = new BankAccount("Mike Flynn", 566.32f);
        processAccount(my_account);
        System.out.println(my_account);
    }
}
