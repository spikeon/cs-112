public class BankAccount {
    private double balance = 0;

    public BankAccount(double opening){
        balance = opening;
    }

    public void deposit(double amount){
        balance += amount;
    }

    public void withdraw(double amount){
        balance -= amount;
    }

    public double getBalance(){
        return balance;
    }
}
